package com.luo.yiting.controller;

import com.luo.yiting.bean.User;
import com.luo.yiting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map login(@RequestBody User user) {
        Map<String,Object> map = new HashMap<>();
        User res = userService.getUserByPhone(user.getPhone());
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
            }
        }
        return map;
    }
}
