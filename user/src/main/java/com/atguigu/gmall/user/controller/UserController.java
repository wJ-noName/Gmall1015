package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("addresses")
    @ResponseBody
    public List<UserAddress> getAllAddress(){
        List<UserAddress> userAddresses =userService.getAllAddress();
        return userAddresses;
    }

    @RequestMapping("users")
    @ResponseBody
    public List<UserInfo> getAllUser(){
        List<UserInfo> userInfos =userService.getAllUser();
        return userInfos;
    }

    @RequestMapping("allUser")
    @ResponseBody
    public List<UserInfo> allUser(){
        List<UserInfo> userInfos =userService.allUser();
        return userInfos;
    }
}
