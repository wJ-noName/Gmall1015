package com.atguigu.gmall.service;



import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.result.ResultEntity;

import java.util.List;

public interface UserService {

    List<UserInfo> getAllUser();

    List<UserAddress> getAllAddress();

    List<UserInfo> allUser();

    ResultEntity<UserInfo> getUserByLogin(String loginName);

    List<UserAddress> getAddressByUserId(int userId);
}
