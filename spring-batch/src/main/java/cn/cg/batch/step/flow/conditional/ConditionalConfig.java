package cn.cg.batch.step.flow.conditional;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 条件下一步
 *
 * @author: cg1
 * @date: 2022-10-06 02:25
 **/
//@Configuration
public class ConditionalConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    /**
     * 两者是有区别的,虽然他们的枚举值可能similar
     *
     * @see org.springframework.batch.core.BatchStatus
     * th JobExecution and StepExecution and is used by the framework to record the status of a Job or Step
     * @see ExitStatus
     * ExitStatus 代表一个 Step 完成执行后的状态。
     */

    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("job")
                .start(stepA())
                //"*" matches zero or more characters
                //"?" matches exactly one character
                //For example, "c*t" matches "cat" and "count", while "c?t" matches "cat" but not "count".
                .on("*").to(stepB())
                // on("FAILED")实际上是 ExitStatus 有时和 BatchStatus相同摆了
                .from(stepA()).on("FAILED").to(stepC())
                .end()
                .build();
    }

    /**
     * step 有三种可能
     * <p>
     * The Step failed, in which case the job should fail.
     * <p>
     * The Step completed successfully.
     * <p>
     * The Step completed successfully but with an exit code of 'COMPLETED WITH SKIPS'. In this case, a different step should be run to handle the errors.
     *
     * @return
     */
    @Bean
    public Job job1() {
        return this.jobBuilderFactory.get("job")
                .start(step1()).on("FAILED").end()
                //一种全新的退出码
                .from(step1()).on("COMPLETED WITH SKIPS").to(errorPrint1())
                .from(step1()).on("*").to(step2())
                .end()
                .build();
    }


    public class SkipCheckingListener extends StepExecutionListenerSupport {
        @Override
        public ExitStatus afterStep(StepExecution stepExecution) {
            String exitCode = stepExecution.getExitStatus().getExitCode();
            if (!exitCode.equals(ExitStatus.FAILED.getExitCode()) &&
                    stepExecution.getSkipCount() > 0) {
                return new ExitStatus("COMPLETED WITH SKIPS");
            } else {
                return null;
            }
        }
    }

    private Step step2() {
        return null;
    }

    private Step errorPrint1() {
        return null;
    }

    private Step step1() {
        return null;
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
