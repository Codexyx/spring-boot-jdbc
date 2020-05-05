package com.xyx.springbootjdbc.controller;

import com.xyx.springbootjdbc.pojo.User;
import com.xyx.springbootjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //添加用户
    @PostMapping("/addUser")
    public String addUser(User user){
        try {
            this.userService.addUser(user);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "redirect:/success";
    }

}
