package cn.cg.mybatisflex;

import cn.cg.mybatisflex.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * hello world
 */
@SpringBootTest
class MybatisFlexServiceTests {

    @Autowired
    private AccountService accountService;


    @Test
    public void hello() {
        long count = accountService.count();
        System.out.println(count);
    }

}
