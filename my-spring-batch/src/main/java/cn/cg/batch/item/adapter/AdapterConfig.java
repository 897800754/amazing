package cn.cg.batch.item.adapter;

import org.springframework.batch.item.adapter.ItemReaderAdapter;
import org.springframework.context.annotation.Bean;

/**
 * @author: cg
 * @date: 2022-10-08 00:48
 **/
public class AdapterConfig {
    @Bean
    public ItemReaderAdapter itemReader() {
        ItemReaderAdapter reader = new ItemReaderAdapter();

        reader.setTargetObject(fooService());
        reader.setTargetMethod("generateFoo");

        return reader;
    }

    //    @Bean
    public FooService fooService() {
        return new FooService();
    }

    public class FooService {

    }
}
