package com.atguigu.gamll.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.service.AttrService;
import com.atguigu.gmall.bean.BaseAttrInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AttrController {

    @Reference
    AttrService attrService;

    @RequestMapping("saveAttr")
    @ResponseBody
    public String saveAttr(BaseAttrInfo baseAttrInfo) {
        attrService.saveAttr(baseAttrInfo);
        return "success";

    }

    @RequestMapping("getAttrList")
    @ResponseBody
    public List<BaseAttrInfo> getAttrList(String catalog3Id) {
        List<BaseAttrInfo> baseAttrInfos = attrService.getAttrList(catalog3Id);
        return baseAttrInfos;
    }

}
