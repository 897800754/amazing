package cn.cg.batch.step.rollback;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import javax.xml.bind.ValidationException;

/**
 * 事务回滚
 *
 * @author: cg1
 * @date: 2022-10-06 02:25
 **/
@Configuration
public class RollbackJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    //    @Bean
    public Step step1() {
        return this.stepBuilderFactory.get("step1")
                .<String, String>chunk(2)
                .reader(itemReader())
                .writer(itemWriter())
                .faultTolerant()
                //遇到该异常不回滚
                .noRollback(ValidationException.class)
                .build();
    }

    //    @Bean
    public Step step2() {
        return this.stepBuilderFactory.get("step1")
                .<String, String>chunk(2)
                .reader(itemReader())
                .writer(itemWriter())
                .readerIsTransactionalQueue()
                .build();
    }


    //    @Bean
    public Step step3() {
        DefaultTransactionAttribute attribute = new DefaultTransactionAttribute();
        attribute.setPropagationBehavior(Propagation.REQUIRED.value());
        attribute.setIsolationLevel(Isolation.DEFAULT.value());
        attribute.setTimeout(30);

        return this.stepBuilderFactory.get("step1")
                .<String, String>chunk(2)
                .reader(itemReader())
                .writer(itemWriter())
                .transactionAttribute(attribute)
                .build();
    }


    private ItemWriter<? super String> itemWriter() {
        return null;
    }

    private ItemReader<? extends String> itemReader() {
        return null;
    }


}
