package com.luo.yiting.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luo.yiting.bean.ParkAdmin;
import com.luo.yiting.service.ParkAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class parkAdminController {

    @Autowired
    ParkAdminService service;

    @RequestMapping(value = "/parkAdminLogin", method = RequestMethod.POST)
    public Map login(@RequestBody ParkAdmin user) {
        Map<String, Object> map = new HashMap<>();
        ParkAdmin res = service.getUserByPhone(user.getPhone());
        if (res == null) {
            map.put("code", 500);
            map.put("msg", "用户不存在");
        } else {
            if (!res.getPassword().equals(user.getPassword())) {
                map.put("code", 500);
                map.put("msg", "密码错误");
            } else {
                map.put("code", 200);
                map.put("msg", "登录成功");
                map.put("name", res.getName());
                map.put("userId", res.getId());
                map.put("parkingLotId", res.getParkinglotid());
            }
        }
        return map;
    }

    @RequestMapping("/getParkAdmins")
    public Map getUsers(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        PageHelper.startPage(pageNo, pageSize);
        List<ParkAdmin> users;
        users = service.getAllParkAdmins();
        PageInfo<ParkAdmin> pageInfo = new PageInfo<>(users);
        users = pageInfo.getList();
        Map<String, Object> map = new HashMap<>();
        map.put("users", users);
        map.put("total", users == null ? 0 : users.size());
        return map;
    }

    @RequestMapping(value = "/updateParkAdmin", method = RequestMethod.POST)
    public Map updateUser(@RequestBody ParkAdmin user) {
        int res = service.updateParkAdmin(user);
        Map<String, Object> map = new HashMap<>();
        map.put("code", res == 0 ? 500 : 200);
        return map;
    }

    @RequestMapping(value = "/addParkAdmin", method = RequestMethod.POST)
    public Map addUser(@RequestBody ParkAdmin user) {
        int res = service.addParkAdmin(user);
        Map<String, Object> map = new HashMap<>();
        map.put("code", res == 0 ? 500 : 200);
        return map;
    }

    @RequestMapping("/getParkAdminInfo")
    public Map getParkAdminInfo(Integer userId) {
        Map<String, Object> map = new HashMap<>();
        ParkAdmin parkAdmin = service.getParkAdminInfoById(userId);
        map.put("code", 200);
        map.put("parkAdmin", parkAdmin);
        return map;
    }

}
