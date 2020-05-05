package com.xyx.springbootjdbc.service.impl;

import com.xyx.springbootjdbc.dao.UserDao;
import com.xyx.springbootjdbc.pojo.User;
import com.xyx.springbootjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    //查询全部用户
    @Override
    public List<User> findUserAll() {
        return this.userDao.findUserAll();
    }

    @Override
    public User findUserById(Integer id) {
        return this.userDao.findUserById(id);
    }

    @Override
    @Transactional
    public void updateUserById(User user) {
        this.userDao.updateUserById(user);
    }

    @Override
    @Transactional
    public void deteleUser(Integer id) {
        this.userDao.deteleUser(id);
    }
}
