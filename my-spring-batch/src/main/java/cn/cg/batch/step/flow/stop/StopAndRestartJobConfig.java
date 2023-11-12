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
public class StopAndRestartJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    /**
     * if step1 finishes with COMPLETE, then the job then stops. Once it is restarted, execution begins on step2.
     *
     * @return
     */
    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("job")
                .start(step1()).on("COMPLETED").stopAndRestart(step2())
                .end()
                .build();
    }


    private Step step2() {
        return null;
    }

    private Step step1() {
        return null;
    }

}
