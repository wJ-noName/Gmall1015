package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.user.bean.User;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
   private UserService userService;

    @RequestMapping("/get/all")
    @ResponseBody
    public List<User> getAllUser() {
        List<User> users = userService.getAllUser();
        return users;
    }
}
