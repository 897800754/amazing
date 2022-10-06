package cn.cg.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: cg1
 * @date: 2022-10-06 01:19
 **/
@SpringBootApplication
@EnableBatchProcessing
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
