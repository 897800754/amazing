package cn.cg.batch.step.retry;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 重试step配置
 *
 * @author: cg1
 * @date: 2022-10-06 02:25
 **/
//@Configuration
public class RetryJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    /**
     * 重试
     *
     * @return
     */
    @Bean
    public Step step1() {
        return this.stepBuilderFactory.get("step1")
                .<String, String>chunk(2)
                .reader(itemReader())
                .writer(itemWriter())
                .faultTolerant()
                //最多三次
                .retryLimit(3)
                //遇到该异常重试
                .retry(DeadlockLoserDataAccessException.class)
                .build();
    }

    private ItemWriter<? super String> itemWriter() {
        return null;
    }

    private ItemReader<? extends String> itemReader() {
        return null;
    }


}
