package com.luo.yiting.service;

import com.luo.yiting.bean.ParkAdmin;
import com.luo.yiting.bean.ParkAdminExample;
import com.luo.yiting.bean.ParkingLotExample;
import com.luo.yiting.bean.User;
import com.luo.yiting.mapper.ParkAdminMapper;
import com.luo.yiting.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkAdminService {

    @Autowired
    ParkAdminMapper mapper;

    public ParkAdmin getUserByPhone(String phone) {
        ParkAdminExample example = new ParkAdminExample();
        example.createCriteria().andPhoneEqualTo(phone);
        ArrayList<ParkAdmin> admins = (ArrayList<ParkAdmin>) mapper.selectByExample(example);
        if(admins == null || admins.size() == 0) return null;
        return  admins.get(0);
    }

    public List<ParkAdmin> getAllParkAdmins() {
        return mapper.selectByExample(null);
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateParkAdmin(ParkAdmin user) {
        return mapper.updateByPrimaryKeySelective(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public int addParkAdmin(ParkAdmin user) {
        return mapper.insertSelective(user);
    }
}
