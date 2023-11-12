package cn.cg.mybatisflex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.cg.mybatisflex.mapper")
public class MybatisFlexApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisFlexApplication.class, args);
    }

}
