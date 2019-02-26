package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.user.bean.User;
import com.atguigu.gmall.user.mapper.UserMapper;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
   @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.selectGetAll();
    }
}
