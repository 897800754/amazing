package cn.cg.batch.step.flow.decision;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 动态的step flow
 *
 * @author: cg1
 * @date: 2022-10-06 02:25
 **/
//@Configuration
public class DecisionConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    public class MyDecider implements JobExecutionDecider {
        @Override
        public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
            String status;
            if (someCondition()) {
                status = "FAILED";
            } else {
                status = "COMPLETED";
            }
            return new FlowExecutionStatus(status);
        }

        private boolean someCondition() {
            return false;
        }
    }

    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("job")
                .start(step1())
                .next(decider()).on("FAILED").to(step2())
                .from(decider()).on("COMPLETED").to(step3())
                .end()
                .build();
    }

    private JobExecutionDecider step3() {
        return null;
    }

    private JobExecutionDecider step2() {
        return null;
    }

    private JobExecutionDecider decider() {
        return null;
    }

    private Step step1() {
        return null;
    }


}
