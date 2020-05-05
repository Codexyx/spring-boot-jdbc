package com.xyx.springbootjdbc.dao.impl;

import com.xyx.springbootjdbc.dao.UserDao;
import com.xyx.springbootjdbc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加用户
    @Override
    public void insertUser(User user) {
        String sql = "INSERT into user(name, age, sex) values(?, ?, ?)";
        this.jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getSex());
    }
}
