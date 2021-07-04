package com.lh.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @program: spring-annotation
 * @description:
 * @author: lh
 * @date: 2021-07-03 17:09
 **/
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "insert into `tbl_user`(username,age) values(?,?)";
        String username = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql,username,18);

        int i = 1/0;
    }
}
