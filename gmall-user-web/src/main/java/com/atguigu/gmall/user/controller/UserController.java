package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.result.ResultEntity;
import com.atguigu.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Id;
import javax.xml.crypto.Data;
import java.util.List;

@Controller
public class UserController {

    @Reference
    private UserService userService;


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

    @RequestMapping("/get/user/by/login")
    @ResponseBody
    public ResultEntity<UserInfo> getUserByLogin(@RequestParam("loginName") String loginName, @RequestParam("passwd") String passwd){

            ResultEntity<UserInfo> userInfoResultEntity = userService.getUserByLogin(loginName);
            UserInfo userInfo = userInfoResultEntity.getData();
        if (userInfo == null) {
            return new ResultEntity<UserInfo>(ResultEntity.FAILED, ResultEntity.NO_MESSAGE,null);
        }
            String resultPasswd = userInfo.getPasswd();
        if (passwd.equals(resultPasswd)) {
            return new ResultEntity<UserInfo>(ResultEntity.SUCCESS, ResultEntity.NO_MESSAGE, userInfo);
        } else {
            return new ResultEntity<UserInfo>(ResultEntity.FAILED, ResultEntity.NO_MESSAGE, null);
        }
    }

    @RequestMapping("/get/address/by/user/id")
    @ResponseBody
    public List<UserAddress> getAddressByUserId(@RequestParam("userId") int userId){
           List<UserAddress> userAddresses = userService.getAddressByUserId(userId);
           return userAddresses;
    }
}
