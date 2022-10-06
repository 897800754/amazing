package cn.cg.batch.step.flow;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 快速开始
 *
 * @author: cg1
 * @date: 2022-10-06 02:25
 **/
//@Configuration
public class HelloJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;


    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("job")
                .start(stepA())
                .next(stepB())
                .next(stepC())
                .build();
    }

    private Step stepC() {
        return null;
    }

    private Step stepB() {

        return null;
    }

    private Step stepA() {
        return null;
    }


}
