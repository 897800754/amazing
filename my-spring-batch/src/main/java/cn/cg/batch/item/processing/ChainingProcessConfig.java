package cn.cg.batch.item.processing;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cg
 * @date: 2022-10-09 00:56
 **/
public class ChainingProcessConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public Job ioSampleJob() {
        return this.jobBuilderFactory.get("ioSampleJob")
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {

        CompositeItemProcessor<Foo, Bar> compositeProcessor =
                new CompositeItemProcessor<Foo, Bar>();
        List itemProcessors = new ArrayList();
        itemProcessors.add(new FooProcessor());
//        itemProcessors.add(new BarProcessor());
        compositeProcessor.setDelegates(itemProcessors);


        return this.stepBuilderFactory.get("step1")
                .<Foo, Bar>chunk(2)
                .reader(new FlatFileItemReader<>())
                //复合处理器
                .processor(compositeProcessor)
                .writer(new BarWriter())
                .build();
    }


    public class Foo {
    }

    public class Bar {
        public Bar(Foo foo) {
        }
    }

    public class FooProcessor implements ItemProcessor<Foo, Bar> {
        @Override
        public Bar process(Foo foo) throws Exception {
            //Perform simple transformation, convert a Foo to a Bar
            return new Bar(foo);
        }
    }

    public class BarWriter implements ItemWriter<Bar> {

        @Override
        public void write(List<? extends Bar> bars) throws Exception {
            //write bars
        }
    }

}
