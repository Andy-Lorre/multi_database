package com.example.multi_database.configuration;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class Multi_db_1_config {

    @Bean(name = "multi_db_1")
    @ConfigurationProperties(prefix = "spring.datasource.local")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "multi_db_1_JdbcTemplate")
    public JdbcTemplate mySqlJdbcTemplate(@Qualifier("multi_db_1") DataSource mySqlDataSource) {
        return new JdbcTemplate(mySqlDataSource);
    }


}
