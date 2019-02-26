package com.atguigu.gmall.user.mapper;

import com.atguigu.gmall.user.bean.User;

import java.util.List;

public interface UserMapper {
    List<User> selectGetAll();
}
