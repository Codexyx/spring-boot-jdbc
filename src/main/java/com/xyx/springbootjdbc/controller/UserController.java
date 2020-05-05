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


    //预更新查询用户
    @GetMapping("/preUpdateUser")
    public String preUpdateUser(Integer id, Model model){
        try{
            User user = this.userService.findUserById(id);
            model.addAttribute("user", user);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "updateUser";
    }


    /**
     * 修改用户
     * @param user
     */
    @PostMapping("/updateUser")
    public String updateUser(User user){
        try {
            this.userService.updateUserById(user);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "redirect:/success";
    }

    //删除用户
    @GetMapping("/deteleUser")
    public String deteleUser(Integer id){
        try {
            this.userService.deteleUser(id);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "redirect:/success";
    }
}
