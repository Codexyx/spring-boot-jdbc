package com.xyx.springbootjdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 */
@Controller
public class PageController {
    //页面跳转
    @RequestMapping("/{page}")
    public String toAddUserPage(@PathVariable String page){
        return page;
    }
}
