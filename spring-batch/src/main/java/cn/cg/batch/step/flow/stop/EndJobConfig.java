package cn.cg.batch.step.flow.stop;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * end job
 *
 * @author: cg1
 * @date: 2022-10-06 02:25
 **/
//@Configuration
public class EndJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;


    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("job")
                .start(step1())
                .next(step2())
                //结束以后,restart也无效
                .on("FAILED").end()
                .from(step2()).on("*").to(step3())
                .end()
                .build();
    }

    private Step step3() {
        return null;
    }


    private Step step2() {
        return null;
    }

    private Step step1() {
        return null;
    }

}
