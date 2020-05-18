package com.luo.yiting.service;

import com.luo.yiting.bean.User;
import com.luo.yiting.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public String getPasswordById(Integer id) {
        return userMapper.selectPasswordById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    public List<User> getAllUsers() {
        return userMapper.selectByExample(null);
    }

    public int delUserById(Integer id) {
       return userMapper.deleteByPrimaryKey(id);
    }
}
