package com.luo.yiting.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luo.yiting.bean.Information;
import com.luo.yiting.bean.User;
import com.luo.yiting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map login(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
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

    @RequestMapping("/getUserInfo")
    public Map getUserById(Integer userId) {
        Map<String, Object> map = new HashMap<>();
        User user = userService.getUserById(userId);
        map.put("code", 200);
        map.put("user", user);
        return map;
    }

    @RequestMapping("/getUsers")
    public Map getUsers(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        PageHelper.startPage(pageNo, pageSize);
        List<User> users;
        users = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        users = pageInfo.getList();
        Map<String, Object> map = new HashMap<>();
        map.put("users", users);
        map.put("total", users == null ? 0 : users.size());
        return map;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public Map updateUser(@RequestBody User user) {
        int res = userService.updateUser(user);
        Map<String, Object> map = new HashMap<>();
        map.put("code", res == 0 ? 500 : 200);
        return map;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Map addUser(@RequestBody User user) {
        int res = userService.addUser(user);
        Map<String, Object> map = new HashMap<>();
        map.put("code", res == 0 ? 500 : 200);
        return map;
    }


}
