package com.luo.yiting.service;

import com.luo.yiting.bean.Information;
import com.luo.yiting.bean.InformationExample;
import com.luo.yiting.mapper.InformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationService {
    @Autowired
    InformationMapper mapper;

    public List<Information> getAllInformations() {
        InformationExample example = new InformationExample();
        example.setOrderByClause("createTime desc");
        return mapper.selectByExample(example);
    }
}
