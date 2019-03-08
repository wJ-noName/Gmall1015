package com.atguigu.gmall.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.result.ResultEntity;
import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.user.mapper.UserAddressMapper;
import com.atguigu.gmall.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserAddressMapper userAddressMapper;

    @Override
    public List<UserInfo> getAllUser() {
        List<UserInfo> userInfos = userInfoMapper.selectAllUser();

        return userInfos;
    }

    @Override
    public List<UserAddress> getAllAddress() {

        List<UserAddress> userAddresses = userAddressMapper.selectAll();

        return userAddresses;
    }

    @Override
    public List<UserInfo> allUser() {

        return userInfoMapper.selectAll();
    }

    @Override
    public ResultEntity<UserInfo> getUserByLogin(String loginName) {
       UserInfo userInfo =  userInfoMapper.selectUserByLogin(loginName);
       return new ResultEntity<UserInfo>(ResultEntity.SUCCESS, ResultEntity.NO_MESSAGE,userInfo);
    }

    @Override
    public List<UserAddress> getAddressByUserId(int userId) {
        List<UserAddress> userAddressesList =  userAddressMapper.selectAddressByUserId(userId);
        return userAddressesList;
    }
}
