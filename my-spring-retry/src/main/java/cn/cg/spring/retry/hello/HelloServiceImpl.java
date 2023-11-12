package cn.cg.spring.retry.hello;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

/**
 * @author: cg
 * @date: 2022-12-29 11:22
 **/
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    @Retryable(value = RuntimeException.class)
    public void doAction() throws InterruptedException {
        System.err.println("...........doAction..............");
        int i = 1 / 0;
    }
}
