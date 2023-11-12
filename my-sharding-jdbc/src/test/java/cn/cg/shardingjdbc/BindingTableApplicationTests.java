package cn.cg.shardingjdbc;


import cn.cg.shardingjdbc.repository.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = ShardingJdbcApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BindingTableApplicationTests {

    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TestItemRepository testItemRepository;

    @Autowired
    private TestMapper testMapper;

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
        Test test5 = Test
                .builder()
                .type(1)
                .channel(1)
                .name("test5")
                .build();

        Test test6 = Test
                .builder()
                .type(2)
                .channel(2)
                .name("test6")
                .build();

        tests.add(test1);
        tests.add(test2);
        tests.add(test3);
        tests.add(test4);
        tests.add(test5);
        tests.add(test6);

        for (Test test : tests) {
            testRepository.save(test);
            LambdaQueryWrapper<Test> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Test::getType, test.getType());
            queryWrapper.eq(Test::getChannel, test.getChannel());
            queryWrapper.eq(Test::getId, test.getId());
            List<Test> testEntities = testRepository.findByWrapper(queryWrapper);
            if (CollectionUtils.isNotEmpty(testEntities)) {
                Test test0 = testEntities.get(0);
                TestItem testItem = TestItem.builder()
//                        .id()
                        .testId(test0.getId())
                        .channel(test0.getChannel())
                        .type(test0.getType())
                        .name(test0.getName())
                        .build();
                testItemRepository.save(testItem);

            }
        }
    }

    @org.junit.After
    public void deleteBatch() {
        testRepository.remove(new QueryWrapper<>());
        testItemRepository.remove(new QueryWrapper<>());
    }

    @org.junit.Test
    public void select() {
        //只有一次查询
        //子表沿用父表的 分片值 spring.shardingsphere.sharding.bindingTables[0]=test,test_item
        List<Map> objects = testMapper.selectWithItem(2, 2);
        System.out.println("------------------------------" + JsonUtil.toJsonString(objects));
    }


//    @org.junit.Test
//    public void select() {
//        List<Map> objects = testMapper.selectWithItem(2, 2);
//        System.out.println("------------------------------" + JsonUtil.toJsonString(objects));
//    }

}
