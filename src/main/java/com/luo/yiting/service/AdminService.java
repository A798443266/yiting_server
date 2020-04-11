package com.luo.yiting.service;

import com.luo.yiting.bean.Admin;
import com.luo.yiting.bean.AdminExample;
import com.luo.yiting.bean.ParkAdmin;
import com.luo.yiting.bean.ParkAdminExample;
import com.luo.yiting.mapper.AdminMapper;
import com.luo.yiting.mapper.ParkAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService {

    @Autowired
    AdminMapper mapper;

    public Admin getAdminByPhone(String phone) {
        AdminExample example = new AdminExample();
        example.createCriteria().andPhoneEqualTo(phone);
        ArrayList<Admin> admins = (ArrayList<Admin>) mapper.selectByExample(example);
        if (admins == null) return null;
        if (admins.size() == 0) return null;
        return admins.get(0);
    }
}
