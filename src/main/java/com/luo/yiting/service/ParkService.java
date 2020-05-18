package com.luo.yiting.service;

import com.luo.yiting.bean.*;
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

    //添加共享车位
    @Transactional(rollbackFor = Exception.class)
    public int addSharePark(UserSharePark userSharePark) {
        return userShareParkMapper.insertSelective(userSharePark);
    }

    //添加停车场
    @Transactional(rollbackFor = Exception.class)
    public int addParkingLot(ParkingLot parkingLot) {
        return parkingLotMapper.insertSelective(parkingLot);
    }


    // 获取指定经纬度方圆几公里内的用户共享停车位 并且审核要通过的 且时间还没到的
    public List<UserSharePark> getAllShareInfo(double latitude, double longitude) {
        double[] res = Util.compute(latitude, longitude, 20000);
        UserShareParkExample example = new UserShareParkExample();
        example.createCriteria().andLatitudeBetween(res[0], res[1])
                .andLongitudeBetween(res[2], res[3])
                .andDayGreaterThanOrEqualTo(new Date())
                .andReviewEqualTo(1);
        return userShareParkMapper.selectByExample(example);
    }

    // 获取指定经纬度方圆几公里内的停车场
    public List<ParkingLot> getAllParkingLot(double latitude, double longitude) {
        double[] res = Util.compute(latitude, longitude, 20000);
        ParkingLotExample example = new ParkingLotExample();
        example.createCriteria().andLatitudeBetween(res[0], res[1])
                .andLongitudeBetween(res[2], res[3]);
        return parkingLotMapper.selectByExample(example);
    }

    //获取全部停车场
    public List<ParkingLot> getAllParkingLot() {
        return parkingLotMapper.selectByExample(null);
    }

    //获取未审核的共享车位
    public List<UserSharePark> getUnVerifyShare() {
        //0 未审核 1审核通过 2审核未通过
        UserShareParkExample example = new UserShareParkExample();
        example.createCriteria().andReviewEqualTo(0);
        return userShareParkMapper.selectByExample(example);
    }

    // 根据id获取用户共享车位信息
    public UserSharePark getUserShareParkById(Integer id) {
        return userShareParkMapper.selectByPrimaryKey(id);
    }

    //根据id获取停车场信息
    public ParkingLot getParkingLogById(Integer parkLotId) {
        return parkingLotMapper.selectByPrimaryKey(parkLotId);
    }

    // 更新停车场相关信息
    @Transactional(rollbackFor = Exception.class)
    public int updateParkingLot(ParkingLot parkingLot) {
        return parkingLotMapper.updateByPrimaryKeySelective(parkingLot);
    }

    public List<UserSharePark> getUserShare(Integer userId) {
        UserShareParkExample example = new UserShareParkExample();
        example.createCriteria().andUseridEqualTo(userId);
        return userShareParkMapper.selectByExample(example);
    }

    public int updateVerify(int id, int verify) {
        UserSharePark userSharePark = new UserSharePark();
        userSharePark.setId(id);
        userSharePark.setReview(verify);
        return userShareParkMapper.updateByPrimaryKeySelective(userSharePark);
    }

    public List<UserSharePark> getShareParksByUserId(Integer userId) {
        UserShareParkExample example = new UserShareParkExample();
        example.createCriteria().andUseridEqualTo(userId);
        return userShareParkMapper.selectByExample(example);
    }
}
