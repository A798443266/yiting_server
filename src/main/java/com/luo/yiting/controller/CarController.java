package com.luo.yiting.controller;

import com.luo.yiting.bean.Car;
import com.luo.yiting.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public Map addCar(@RequestBody Car car) {
        Map<String, Object> map = new HashMap<>();
        // 1.查询是否车牌已经添加
        boolean a = carService.hasCar(car.getUserid(), car.getLicensePlate());
        if (a) {
            map.put("code", 100);
            map.put("msg", "您已经添加过该车牌");
            return map;
        }
        List<Car> cars = carService.getCars(car.getUserid());
        if(cars != null && cars.size() > 3) {
            map.put("code", 300);
            map.put("msg", "您最多只能添加3辆车");
            return map;
        }
        // 2.每个用户最多只能添加三辆车
        int res = carService.addCar(car);
        int code = res == 0 ? 500 : 200;
        String msg = res == 0 ? "添加失败" : "添加失败";
        map.put("code", code);
        map.put("msg", msg);
        return map;
    }
    @RequestMapping("/getCars")
    public Map getCarsByUserId(Integer userId) {
        Map<String, Object> map = new HashMap<>();
        List<Car> cars = carService.getCars(userId);
        map.put("cars", cars);
        return map;
    }

    @RequestMapping("/deleteCar")
    public Map deleteCar(Integer carId) {
        Map<String, Object> map = new HashMap<>();
        int res = carService.deleteCar(carId);
        map.put("code", res == 0 ? 500 : 200);
        return map;
    }
}
