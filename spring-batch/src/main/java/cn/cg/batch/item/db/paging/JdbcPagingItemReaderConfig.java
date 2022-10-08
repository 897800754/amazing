package cn.cg.batch.item.db.paging;

import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: cg
 * @date: 2022-10-08 00:42
 **/
public class JdbcPagingItemReaderConfig {
    @Bean
    public JdbcPagingItemReader itemReader(DataSource dataSource, PagingQueryProvider queryProvider) {
        Map<String, Object> parameterValues = new HashMap<>();
        parameterValues.put("status", "NEW");

        return new JdbcPagingItemReaderBuilder<Map>()
                .name("creditReader")
                .dataSource(dataSource)
                .queryProvider(queryProvider)
                .parameterValues(parameterValues)
                .rowMapper(new CustomerCreditRowMapper())
                .pageSize(1000)
                .build();
    }

    public class CustomerCreditRowMapper implements RowMapper {

        @Override
        public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
            return null;
        }
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider() {
        SqlPagingQueryProviderFactoryBean provider = new SqlPagingQueryProviderFactoryBean();

        provider.setSelectClause("select id, name, credit");
        provider.setFromClause("from customer");
        provider.setWhereClause("where status=:status");
        provider.setSortKey("id");

        return provider;
    }
}
