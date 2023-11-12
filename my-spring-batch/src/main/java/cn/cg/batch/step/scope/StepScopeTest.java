package cn.cg.batch.step.scope;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @author: cg
 * @date: 2022-10-07 23:58
 **/
public class StepScopeTest {
    /**
     * StepScope
     * 类似
     * singleton,prototype  spring bean的作用范围
     * <p>
     * 被@StepScope注解修饰的bean只会在job启动时进行初始化,job处理完成后便会被销毁
     * (也就是说被@StepScope注解所修饰bean的生命周期与job的生命周期保持同步 （经指正：“是和Step一致，同一个Step执行两次你会发现Writer创建了两次”）)
     *
     * @param
     * @return
     */
    @Bean
    @StepScope
    //@Value("#{jobParameters['contractInfoDat']}")
    public FlatFileItemWriter<Map> contInfoMyItemWriter(String contractInfoDat) {
//        return getGbkFlatFileItemWriter(contractInfoDat);

        return null;
    }


}
