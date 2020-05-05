package com.xyx.springbootjdbc.service;

import com.xyx.springbootjdbc.pojo.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> findUserAll();

    User findUserById(Integer id);

    void updateUserById(User user);

    void deteleUser(Integer id);
}
