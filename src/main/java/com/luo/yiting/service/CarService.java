package com.luo.yiting.service;

import com.luo.yiting.bean.Car;
import com.luo.yiting.bean.CarExample;
import com.luo.yiting.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarMapper mapper;

    public int addCar(Car car) {
        return mapper.insertSelective(car);
    }

    public boolean hasCar(Integer userId, String licensePlate) {
        CarExample example = new CarExample();
        example.createCriteria().andUseridEqualTo(userId).andLicensePlateEqualTo(licensePlate);
        int res = mapper.countByExample(example);
        return res > 0;
    }

    public List<Car> getCars(Integer userId) {
        CarExample example = new CarExample();
        example.createCriteria().andUseridEqualTo(userId);
        return mapper.selectByExample(example);
    }

    public int deleteCar(Integer carId) {
        return mapper.deleteByPrimaryKey(carId);
    }
}
