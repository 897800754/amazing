package cn.cg.batch.step.skip;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.FileNotFoundException;

/**
 * 发生异常跳过step配置
 *
 * @author: cg1
 * @date: 2022-10-06 02:25
 **/
//@Configuration
public class SkipJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;


    @Bean
    public Step playerLoad() {
        return this.stepBuilderFactory.get("step1")
                .<String, String>chunk(10)
                .reader(flatFileItemReader())
                .writer(itemWriter())
                .faultTolerant()
                .skipLimit(10)
                //遇到该异常跳过
                .skip(Exception.class)
                //不跳过
                .noSkip(FileNotFoundException.class)
                .build();
    }

    private ItemWriter<? super String> itemWriter() {
        return null;
    }

    private ItemReader<? extends String> flatFileItemReader() {
        return null;
    }

}
