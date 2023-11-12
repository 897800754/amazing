package cn.cg.shardingjdbc;


import cn.cg.shardingjdbc.repository.Test;
import cn.cg.shardingjdbc.repository.TestRepository;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = ShardingJdbcApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ShardingJdbcApplicationTests {

    @Autowired
    private TestRepository testRepository;

    @org.junit.Before
    public void saveBatch() {
        ArrayList<Test> tests = new ArrayList<>();

        Test test1 = Test
                .builder()
                .type(1)
                .channel(4)
                .name("test1")
                .build();
        Test test2 = Test
                .builder()
                .type(2)
                .channel(3)
                .name("test2")
                .build();
        Test test3 = Test
                .builder()
                .type(3)
                .channel(2)
                .name("test3")
                .build();
        Test test4 = Test
                .builder()
                .type(4)
                .channel(1)
                .name("test4")
                .build();
        tests.add(test1);
        tests.add(test2);
        tests.add(test3);
        tests.add(test4);
        for (Test test : tests) {
            testRepository.save(test);
        }
    }

    @org.junit.After
    public void deleteBatch() {
        testRepository.remove(new QueryWrapper<>());
    }

    @org.junit.Test
    public void select() {
        //基于id查询,会查四遍
        Test byId = testRepository.getById("904e41aad20d4c5d9ca812fcdc6784e8");
        System.out.println(byId);
    }


    @org.junit.Test
    public void selectByType() {
        List<Test> tests = testRepository.findByType(1);
        System.out.println(tests);
    }


    @org.junit.Test
    public void selectByChannel() {
        List<Test> tests = testRepository.findByChannel(1);
        System.out.println(tests);
    }


    @org.junit.Test
    public void selectByChannelAndType() {
        LambdaQueryWrapper<Test> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Test::getChannel, 1);
        wrapper.eq(Test::getType, 1);
        List<Test> tests = testRepository.findByWrapper(wrapper);
        System.out.println(tests);
    }

    @org.junit.Test
    public void selectByTypeForRange() {
        LambdaQueryWrapper<Test> wrapper = new LambdaQueryWrapper<>();
        wrapper.gt(Test::getType, 0);
        //只查ds1,ds2的test_1,只查两次
        //没有范围查询分片策略直接报错
        List<Test> tests = testRepository.findByWrapper(wrapper);
        System.out.println(tests);
    }

    @org.junit.Test
    public void selectByTypeForHint() {
        // Hint分片策略必须要使用 HintManager工具类
        HintManager hintManager = HintManager.getInstance();
        //
//        hintManager.addDatabaseShardingValue("test", 0);

//        hintManager.addTableShardingValue("test", 1);
        // 直接指定对应具体的数据库
        hintManager.setDatabaseShardingValue(1);

        //在读写分离数据库中，Hint 可以强制读主库（主从复制是存在一定延时，但在业务场景中，可能更需要保证数据的实时性）
        //hintManager.setMasterRouteOnly();

        LambdaQueryWrapper<Test> wrapper = new LambdaQueryWrapper<>();

        wrapper.gt(Test::getType, 0);

        List<Test> tests = testRepository.findByWrapper(wrapper);

        System.out.println(tests);
    }


}
