package com.xyx.springbootjdbc.controller;

import com.xyx.springbootjdbc.pojo.User;
import com.xyx.springbootjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //添加用户
    @PostMapping("/addUser")
    public String addUser(User user) {
        try {
            this.userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/success";
    }

    //查询全部用户
    @GetMapping("/queryUserAll")
    public String queryUserAll(Model model){
        try {
            List<User> list = this.userService.findUserAll();
            model.addAttribute("list", list);
            return "showUsers";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/preUpdateUser")
    public String preUpdateUser(Integer id, Model model){
        String name = "王二";
        // \u000dname = "王三";
        System.out.println(name);
        try{
            User user = this.userService.findUserById(id);
            model.addAttribute("user", user);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "updateUser";
    }

}
