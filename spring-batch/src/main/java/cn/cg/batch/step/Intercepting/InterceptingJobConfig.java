package cn.cg.batch.step.Intercepting;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 横向拦截
 *
 * @author: cg1
 * @date: 2022-10-06 02:25
 **/
//@Configuration
public class InterceptingJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    /**
     * org.springframework.batch.core.StepExecutionListener
     * org.springframework.batch.core.ChunkListener
     * org.springframework.batch.core.ItemReadListener
     * ItemProcessListener
     * ItemWriteListener
     * SkipListener
     *
     * @return
     */

    @Bean
    public Step step1() {
        return this.stepBuilderFactory.get("step1")
                .<String, String>chunk(10)
                .reader(reader())
                .writer(writer())
                .listener(chunkListener())
                .build();
    }

    private ItemWriter<? super String> writer() {
        return null;
    }


    private Object chunkListener() {
        return null;
    }

    private ItemReader<? extends String> reader() {
        return null;
    }


}
