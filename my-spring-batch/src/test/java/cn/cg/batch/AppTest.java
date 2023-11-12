package cn.cg.batch;

import cn.cg.batch.quick.start.JobLauncherController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: cg1
 * @date: 2022-10-06 01:32
 **/
@SpringBootTest(classes = App.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
    @Autowired
    JobLauncherController jobLauncherController;

    @Test
    public void test() throws Exception {
        jobLauncherController.handle();
    }
}
