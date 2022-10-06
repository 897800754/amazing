package cn.cg.batch.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @author: cg1
 * @date: 2022-10-06 01:19
 **/
@Configuration
public class H2DataSource {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("/org/springframework/batch/core/schema-drop-h2.sql")
                .addScript("/org/springframework/batch/core/schema-h2.sql")
                .build();
    }


}
