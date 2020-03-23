package com.luo.yiting.service;

import com.luo.yiting.bean.ParkingLot;
import com.luo.yiting.bean.ParkingLotExample;
import com.luo.yiting.bean.UserSharePark;
import com.luo.yiting.bean.UserShareParkExample;
import com.luo.yiting.mapper.ParkingLotMapper;
import com.luo.yiting.mapper.UserShareParkMapper;
import com.luo.yiting.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ParkService {

    @Autowired
    UserShareParkMapper userShareParkMapper;
    @Autowired
    ParkingLotMapper parkingLotMapper;


    @Transactional(rollbackFor = Exception.class)
    public int addSharePark(UserSharePark userSharePark) {
        return userShareParkMapper.insertSelective(userSharePark);
    }

    public List<UserSharePark> getAllShareInfo(double latitude, double longitude) {
        double[] res = Util.compute(latitude, longitude, 3535);
        UserShareParkExample example = new UserShareParkExample();
        example.createCriteria().andLatitudeBetween(res[0], res[1])
                .andLongitudeBetween(res[2], res[3])
                .andDayGreaterThanOrEqualTo(new Date());
        return userShareParkMapper.selectByExample(example);
    }

    public List<ParkingLot> getAllParkingLot(double latitude, double longitude) {
        double[] res = Util.compute(latitude, longitude, 3535);
        ParkingLotExample example = new ParkingLotExample();
        example.createCriteria().andLatitudeBetween(res[0], res[1])
                .andLongitudeBetween(res[2], res[3]);
        return parkingLotMapper.selectByExample(example);
    }
}
