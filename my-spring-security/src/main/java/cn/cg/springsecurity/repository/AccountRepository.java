package cn.cg.springsecurity.repository;

import cn.cg.springsecurity.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * @author: cg
 * @date: 2023-08-02 19:46
 **/
@Repository
public class AccountRepository {
    private static HashMap<String, Account> userDB = new HashMap<String, Account>() {
        {
            Account account = new Account();
            account.setId(1);
            account.setUserName("zhangsan");
            account.setPassword("$2a$10$D/cEhMpArVKLhMYSbUsQ4.Zu5faVeRYkHNH84wBqO.Fj93PSEKGra");
            account.setSalt("abc");

            this.put("zhangsan", account);
        }
    };


    public Account getUserByName(String name) {
        return userDB.get(name);
    }
}
