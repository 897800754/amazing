package cn.cg.batch.step;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author: cg1
 * @date: 2022-10-06 02:16
 **/
@Configuration
public class FootBallJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public Job footballJob() {
        return this.jobBuilderFactory.get("footballJob")
                .start(playerLoad())
                .next(gameLoad())
                .next(playerSummarization())
                .build();
    }

    @Bean
    public Step playerLoad() {
        return this.stepBuilderFactory.get("playerLoad")
                .<String, String>chunk(10)
                .reader(playerFileItemReader())
                .writer(playerWriter())
                .build();
    }

    private ItemReader<? extends String> playerFileItemReader() {
        return null;
    }

    private ItemWriter<? super String> playerWriter() {
        return null;
    }


    @Bean
    public Step gameLoad() {
        return this.stepBuilderFactory.get("gameLoad")
                .allowStartIfComplete(true)
                .<String, String>chunk(10)
                .reader(gameFileItemReader())
                .writer(gameWriter())
                .build();
    }

    private ItemWriter<? super String> gameWriter() {
        return null;
    }

    private ItemReader<? extends String> gameFileItemReader() {
        return null;
    }

    @Bean
    public Step playerSummarization() {
        return this.stepBuilderFactory.get("playerSummarization")
                .startLimit(2)
                .<String, String>chunk(10)
                .reader(playerSummarizationSource())
                .writer(summaryWriter())
                .build();
    }

    private ItemWriter<? super String> summaryWriter() {
        return null;
    }

    private ItemReader<? extends String> playerSummarizationSource() {
        return null;
    }
}
