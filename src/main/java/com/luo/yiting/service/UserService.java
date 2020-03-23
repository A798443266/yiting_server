package com.luo.yiting.service;

import com.luo.yiting.bean.User;
import com.luo.yiting.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUserByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
