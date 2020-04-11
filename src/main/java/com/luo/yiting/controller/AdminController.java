package com.luo.yiting.controller;

import com.luo.yiting.bean.Admin;
import com.luo.yiting.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    AdminService service;

    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public Map login(@RequestBody Admin admin) {
        Map<String, Object> map = new HashMap<>();
        Admin res = service.getAdminByPhone(admin.getPhone());
        if (res == null) {
            map.put("code", 500);
            map.put("msg", "用户不存在");
        } else {
            if (!res.getPassword().equals(admin.getPassword())) {
                map.put("code", 500);
                map.put("msg", "密码错误");
            } else {
                Admin admin1 = new Admin();
                admin1.setId(res.getId());
                admin1.setName(res.getName());
                admin1.setPhone(res.getPhone());
                admin1.setPic(res.getPic());
                map.put("code", 200);
                map.put("msg", "登录成功");
                map.put("admin", admin1);
            }
        }
        return map;
    }
}
