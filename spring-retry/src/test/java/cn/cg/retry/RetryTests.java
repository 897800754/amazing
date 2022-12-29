package cn.cg.retry;


import cn.cg.spring.retry.custom.CustomService;
import cn.cg.spring.retry.hello.HelloService;
import cn.cg.spring.retry.recover.RecoverService;
import cn.cg.spring.retry.template.RetryAutoConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;

import java.sql.SQLException;

public class RetryTests extends ApplicationTests {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RecoverService recoverService;

    @Autowired
    private CustomService customService;

    @Autowired
    private RetryTemplate retryTemplate;


    @Test
    public void test() throws InterruptedException {
        helloService.doAction();
    }


    @Test
    public void recover() throws SQLException {

        recoverService.retryServiceWithRecovery();
    }


    @Test
    public void customParam() throws SQLException {

        customService.retryServiceWithCustomization();
    }

    /**
     * @throws SQLException
     * @see RetryAutoConfig
     */
    @Test
    public void retryTemplate() throws Throwable {

        retryTemplate.execute(new RetryCallback<Object, Throwable>() {
            @Override
            public Object doWithRetry(RetryContext retryContext) throws Throwable {
                retryMethod();
                return new Object();
            }

            /***
             * DefaultListenerSupport.open
             * retryMethod
             * DefaultListenerSupport.onError
             * retryMethod
             * DefaultListenerSupport.onError
             * DefaultListenerSupport.close
             */
            private void retryMethod() {
                System.out.println("retryMethod");
                int i = 1 / 0;
            }
        });

    }
}
