package com.example.multi_database;

import com.example.multi_database.repo.Mysql_1_repo;
import com.example.multi_database.repo.Mysql_2_repo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootTest
class MultiDatabaseApplicationTests {

    @Autowired
    private Mysql_1_repo mysql_1_repo;

    @Autowired
    private Mysql_2_repo mysql_2_repo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testTemplate(){

        mysql_1_repo.saveData("2", "tom", "abc@def.com", "12345", "Beijing");
        mysql_2_repo.saveData("2", "tom", "abc@def.com", "12345", "Beijing");


    }

}
