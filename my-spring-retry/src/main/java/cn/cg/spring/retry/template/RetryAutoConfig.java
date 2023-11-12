package cn.cg.spring.retry.template;

import cn.cg.spring.retry.callback.DefaultListenerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryListener;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author: cg
 * @date: 2022-12-29 13:29
 **/
@Configuration
public class RetryAutoConfig {

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
        /**
         * 重试间隔策略
         * 固定2 ms
         *
         */
        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(2_000L);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
        /**
         * 按指数 间隔
         * 第一次回退1s，第二次回退2s，第三次4秒，第四次8秒
         */
        ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
        exponentialBackOffPolicy.setInitialInterval(1000L);
        exponentialBackOffPolicy.setMultiplier(2);
        retryTemplate.setBackOffPolicy(exponentialBackOffPolicy);
        /**
         * 重试次数
         */
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(2);
        retryTemplate.setRetryPolicy(retryPolicy);

        /**
         * 设置回调
         */

        RetryListener[] listeners = new RetryListener[]{
                new DefaultListenerSupport()
        };

        retryTemplate.setListeners(listeners);

        return retryTemplate;
    }
}
