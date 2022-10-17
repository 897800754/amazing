package cn.cg.batch.quick.start;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: cg1
 * @date: 2022-10-06 01:54
 **/
@RestController
public class JobLauncherController {

    @Autowired
    JobLauncher jobLauncher;

    @Resource(name = "endOfDay")
    Job job;


//    @Resource(name = "demo1job")
//    Job demo1Job;


    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Autowired
    private DataSource dataSource;


    @GetMapping("/handle")
    public void handle() throws Exception {
        jobLauncher.run(job, new JobParameters());
    }


    @GetMapping("/demo1")
    public void demo1() throws Exception {
        jobLauncher.run(jobBuilderFactory
                .get("demo1")
                .start(stepBuilderFactory
                        .get("demo1Step")
                        /**
                         * Spring batch在配置Step时采用的是基于Chunk的机制，即每次读取一条数据，再处理一条数据，
                         * 累积到一定数量后再一次性交给writer进行写入操作。这样可以最大化的优化写入效率，整个事务也是基于Chunk来进行。
                         *
                         */
                        .chunk(10)
                        .reader(new JdbcCursorItemReaderBuilder<Integer>()
                                .dataSource(this.dataSource)
                                .name("testReader")
                                .sql("select id from test_data")
                                .rowMapper(new RowMapper<Integer>() {
                                    @Override
                                    public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                                        int id = resultSet.getInt("id");
                                        return id;
                                    }
                                })
                                .build())
                        .writer(new ItemWriter<Object>() {
                            @Override
                            public void write(List<?> list) throws Exception {
                                for (Object o : list) {
                                    System.out.printf("[" + o.toString() + "]");
                                }
                            }
                        })
                        .build())
                .build(), new JobParameters());
    }
}
