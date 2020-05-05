package com.xyx.springbootjdbc.dao;

import com.xyx.springbootjdbc.pojo.User;

import java.util.List;

public interface UserDao {

    void insertUser(User user);

    List<User> findUserAll();

    User findUserById(Integer id);

    void updateUserById(User user);

    void deteleUser(Integer id);

}
