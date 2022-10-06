package cn.cg.batch.step.flow.conditional;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 条件下一步
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


    //    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("job")
                .start(stepA())
                //"*" matches zero or more characters
                //"?" matches exactly one character
                //For example, "c*t" matches "cat" and "count", while "c?t" matches "cat" but not "count".
                .on("*").to(stepB())
                .from(stepA()).on("FAILED").to(stepC())
                .end()
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
