package com.atguigu.gmall.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.bean.BaseAttrValue;
import com.atguigu.gmall.manage.mapper.BaseAttrInfoMapper;
import com.atguigu.gmall.manage.mapper.BaseAttrValueMapper;
import com.atguigu.gmall.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;
    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;

    @Override
    public List<BaseAttrInfo> getAttrList(String catalog3Id) {

        List<BaseAttrInfo> select = null;

        if (StringUtils.isBlank(catalog3Id)) {// null == catalog3Id || catalog3Id.equ..
            select = baseAttrInfoMapper.selectAll();
        }else {
            BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
            baseAttrInfo.setCatalog3Id(catalog3Id);
            select = baseAttrInfoMapper.select(baseAttrInfo);
        }

        return select;
    }

    @Override
    public void saveAttr(BaseAttrInfo baseAttrInfo) {
        baseAttrInfoMapper.insertSelective(baseAttrInfo);
        String attrId = baseAttrInfo.getId();

        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue baseAttrValue : attrValueList) {
            baseAttrValue.setAttrId(attrId);
            baseAttrValueMapper.insertSelective(baseAttrValue);
        }
    }
}
