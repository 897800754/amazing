package cn.cg.batch.step.flow.split;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * split flow
 *
 * @author: cg1
 * @date: 2022-10-06 02:25
 **/
//@Configuration
public class SplitConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;
    @Bean
    public Flow flow1() {
        return new FlowBuilder<SimpleFlow>("flow1")
                .start(step1())
                .next(step2())
                .build();
    }

    private Flow step2() {
        return null;
    }

    private Flow step1() {
        return null;
    }

    @Bean
    public Flow flow2() {
        return new FlowBuilder<SimpleFlow>("flow2")
                .start(step3())
                .build();
    }

    private Flow step3() {
        return null;
    }

    @Bean
    public Job job(Flow flow1, Flow flow2) {
        return this.jobBuilderFactory.get("job")
                .start(flow1)
                .split(new SimpleAsyncTaskExecutor())
                .add(flow2)
                .next(step4())
                .end()
                .build();
    }

    private Flow step4() {
        return null;
    }
}
