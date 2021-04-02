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
public class MultiDB_2 {

    @Bean(name = "multi_db_2")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "multi_db_2_JdbcTemplate")
    public JdbcTemplate mysqlJdbcTemplate(@Qualifier("multi_db_2") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
