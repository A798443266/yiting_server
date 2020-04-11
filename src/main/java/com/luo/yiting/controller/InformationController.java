package com.luo.yiting.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luo.yiting.bean.Information;
import com.luo.yiting.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InformationController {

    @Autowired
    InformationService service;

    @RequestMapping("/getInformation")
    public Map getInformation(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        PageHelper.startPage(pageNo, pageSize);
        List<Information> informations;
        informations = service.getAllInformations();
        PageInfo<Information> pageInfo = new PageInfo<>(informations);
        informations = pageInfo.getList();
        Map<String, Object> map = new HashMap<>();
        map.put("information", informations);
        return map;
    }
}
