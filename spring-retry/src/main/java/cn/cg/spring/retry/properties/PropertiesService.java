package cn.cg.spring.retry.properties;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author: cg
 * @date: 2022-12-29 11:41
 **/
@Component
public class PropertiesService {

    /**
     * 使用配置文件
     * 最大重试两次,并且每次延迟xxx ms
     *
     * @throws SQLException
     */
    @Retryable(value = SQLException.class, maxAttemptsExpression = "${retry.maxAttempts:2}", backoff = @Backoff(delayExpression = "${retry.maxDelay:2000}"))
    public void retryServiceWithCustomization() throws SQLException {
        if (1 == 1) {
            System.err.println("retryServiceWithCustomization...........  ");
            throw new SQLException();
        }

    }
}
