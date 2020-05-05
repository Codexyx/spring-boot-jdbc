package com.xyx.springbootjdbc.dao.impl;

import com.xyx.springbootjdbc.dao.UserDao;
import com.xyx.springbootjdbc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


    //查询全部用户
    @Override
    public List<User> findUserAll() {
        String sql = "select * from user";
        return this.jdbcTemplate.query(sql, new RowMapper<User>() {
            /**
             * 结果集的映射
             * @param resultSet
             * @param i
             * @return
             * @throws SQLException
             */
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setSex(resultSet.getString("sex"));
                return user;
            }
        });
    }

    @Override
    public User findUserById(Integer id) {
        User user = new User();
        String sql = "SELECT * from user WHERE id = "+id;
        this.jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setSex(resultSet.getString("sex"));
            }
        });
        return user;
    }

    @Override
    public void updateUserById(User user) {
        String sql = "update user set name = ?, age = ?, sex = ? where id = ?";
        this.jdbcTemplate.update(
                sql,
                user.getName(),
                user.getAge(),
                user.getSex(),
                user.getId()
        );
    }

    @Override
    public void deteleUser(Integer id) {
        String sql = "DELETE from user where id = " + id;
        this.jdbcTemplate.batchUpdate(sql);
    }
}
