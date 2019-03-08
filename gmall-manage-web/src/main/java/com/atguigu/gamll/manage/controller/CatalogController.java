package com.atguigu.gamll.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseCatalog1;
import com.atguigu.gmall.bean.BaseCatalog2;
import com.atguigu.gmall.bean.BaseCatalog3;
import com.atguigu.gmall.service.CatalongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CatalogController {

    @Reference
    CatalongService catalongService;

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1(){
        List<BaseCatalog1> catalog1s = catalongService.getCatalog1();
        return catalog1s;
    }

    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<BaseCatalog2> getCatalog2(String catalog1Id) {
        List<BaseCatalog2> catalog2s = catalongService.getCatalog2(catalog1Id);
        return  catalog2s;
    }

    @RequestMapping("getCatalog3")
    @ResponseBody
    public  List<BaseCatalog3> getCatalog3(String catalog2Id){
       List<BaseCatalog3> catalog3s = catalongService.getCatalog3(catalog2Id);
       return catalog3s;
    }
}
