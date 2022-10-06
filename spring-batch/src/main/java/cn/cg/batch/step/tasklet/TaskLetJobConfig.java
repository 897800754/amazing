package cn.cg.batch.step.tasklet;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 小型任务,一次搞定
 *
 * @author: cg1
 * @date: 2022-10-06 02:25
 **/
@Configuration
public class TaskLetJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;


    //    @Bean
    public Step step1() {
        return this.stepBuilderFactory.get("step1")
                .tasklet(myTasklet())
                .build();
    }

    private Tasklet myTasklet() {
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                return null;
            }
        };
    }


}
