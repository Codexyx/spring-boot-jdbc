package com.xyx.springbootjdbc.service.impl;

import com.xyx.springbootjdbc.dao.UserDao;
import com.xyx.springbootjdbc.pojo.User;
import com.xyx.springbootjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //添加用户
    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.insertUser(user);
    }
}
