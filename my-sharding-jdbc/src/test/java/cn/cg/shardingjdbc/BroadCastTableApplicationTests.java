package cn.cg.shardingjdbc;


import cn.cg.shardingjdbc.repository.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = ShardingJdbcApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadCastTableApplicationTests {

    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TestItemRepository testItemRepository;

    @Autowired
    private TestMapper testMapper;
    @Autowired
    private BroadCastTestMapper broadCastTestMapper;


    @org.junit.Test
    public void insert() {

        BroadCastTest test = BroadCastTest
                .builder()
                .type(2)
                .channel(2)
                .name("test6")
                .build();
        broadCastTestMapper.insert(test);
    }


}
