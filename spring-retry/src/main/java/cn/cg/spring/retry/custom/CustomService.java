package cn.cg.spring.retry.custom;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author: cg
 * @date: 2022-12-29 11:41
 **/
@Component
public class CustomService {

    /**
     * 最大重试两次,并且每次延迟xxx ms
     *
     * @throws SQLException
     */
    @Retryable(value = SQLException.class, maxAttempts = 2, backoff = @Backoff(delay = 1000 * 10))
    public void retryServiceWithCustomization() throws SQLException {
        if (1 == 1) {
            System.err.println("retryServiceWithCustomization...........  ");
            throw new SQLException();
        }

    }
}
