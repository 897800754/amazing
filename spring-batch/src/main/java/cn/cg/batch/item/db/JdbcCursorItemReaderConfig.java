package cn.cg.batch.item.db;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: cg
 * @date: 2022-10-08 00:30
 **/
public class JdbcCursorItemReaderConfig {
    @Autowired
    DataSource dataSource;

    @Bean
    public JdbcCursorItemReader<Map> itemReader() {
        return new JdbcCursorItemReaderBuilder<Map>()
                .dataSource(this.dataSource)
                .name("creditReader")
                .sql("select ID, NAME, CREDIT from CUSTOMER")
                .rowMapper(new CustomerCreditRowMapper())
                .build();


    }

    public class CustomerCreditRowMapper implements RowMapper {
        public static final String ID_COLUMN = "id";
        public static final String NAME_COLUMN = "name";
        public static final String CREDIT_COLUMN = "credit";

        @Override
        public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
            Map customerCredit = new HashMap();

//            customerCredit.setId(rs.getInt(ID_COLUMN));
//            customerCredit.setName(rs.getString(NAME_COLUMN));
//            customerCredit.setCredit(rs.getBigDecimal(CREDIT_COLUMN));

            return customerCredit;
        }
    }
}
