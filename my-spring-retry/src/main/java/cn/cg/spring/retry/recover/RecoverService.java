package cn.cg.spring.retry.recover;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author: cg
 * @date: 2022-12-29 11:34
 **/
@Component
public class RecoverService {

    @Retryable(value = SQLException.class)
    public void retryServiceWithRecovery() throws SQLException {
        if (1 == 1) {
            System.err.println("retryServiceWithRecovery  ");
            throw new SQLException();
        }
    }

    /**
     * 该方法会被调用
     *
     * @param e
     * @param sql
     */
    @Recover
    public void recover(SQLException e, String sql) {
        System.err.println("recover.......");

    }

}
