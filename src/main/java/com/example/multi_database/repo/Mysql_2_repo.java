package com.example.multi_database.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class Mysql_2_repo {

    @Autowired
    @Qualifier("multi_db_2_JdbcTemplate")
    private JdbcTemplate mySqlJdbcTemplate;

    public void saveData(String id, String name, String emailid, String phoneno, String location){
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("emailid", emailid);
        map.put("phoneno", phoneno);
        map.put("location", location);
        mySqlJdbcTemplate.update("insert into usermaster (id, name, emailid, phoneno, location) values (?, ?, ?, ?, ?)", id, name, emailid, phoneno, location);

    }

}
