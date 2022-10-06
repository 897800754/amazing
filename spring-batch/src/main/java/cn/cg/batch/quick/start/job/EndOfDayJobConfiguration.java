package cn.cg.batch.quick.start.job;

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
 * @date: 2022-10-06 01:53
 **/
@Configuration
public class EndOfDayJobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public Job endOfDay() {
        return this.jobBuilderFactory.get("endOfDay")
                .start(endOfDayStep1())
                .build();
    }

    /**
     * reader: The ItemReader that provides items for processing.
     * <p>
     * writer: The ItemWriter that processes the items provided by the ItemReader.
     * <p>
     * transactionManager: Spring’s PlatformTransactionManager that begins and commits transactions during processing.
     * <p>
     * repository: The Java-specific name of the JobRepository that periodically stores the StepExecution and ExecutionContext during processing (just before committing).
     * <p>
     * chunk: The Java-specific name of the dependency that indicates that this is an item-based step and the number of items to be processed before the transaction is committed.
     */

    @Bean
    public Step endOfDayStep1() {
        return this.stepBuilderFactory.get("step1")
                .transactionManager(transactionManager)
                .<String, String>chunk(10)
                .reader(itemReader())
                .writer(itemWriter())
                .build();
    }

    private ItemReader<? extends String> itemReader() {
        return null;
    }

    private ItemWriter<? super String> itemWriter() {
        return null;
    }


}
