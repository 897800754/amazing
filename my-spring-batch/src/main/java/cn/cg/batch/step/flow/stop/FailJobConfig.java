package cn.cg.batch.step.flow.stop;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * fail job
 *
 * @author: cg1
 * @date: 2022-10-06 02:25
 **/
//@Configuration
public class FailJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    /**
     * 考虑以下场景，如果 step2 失败，则 Job 停止，BatchStatus 为 FAILED，ExitStatus
     * 为 EARLY TERMINATION 并且 step3 不执行。否则，执行移至步骤 3。
     * 此外，如果 step2 失败并且 Job 重新启动，则在 step2 再次开始执行。
     * @return
     */
    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("job")
                .start(step1())
                .next(step2()).on("FAILED").fail()
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
