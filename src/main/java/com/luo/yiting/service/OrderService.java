package com.luo.yiting.service;

import com.luo.yiting.bean.ShareOrder;
import com.luo.yiting.bean.ShareOrderExample;
import com.luo.yiting.bean.User;
import com.luo.yiting.mapper.ShareOrderMapper;
import com.luo.yiting.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    ShareOrderMapper shareOrderMapper;
    @Autowired
    UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public int addShareOrder(ShareOrder order) {
        return shareOrderMapper.insertSelective(order);
    }

    public List<ShareOrder> getShareOiderByUserId(Integer userId) {
        ShareOrderExample example = new ShareOrderExample();
        example.createCriteria().andUseridEqualTo(userId);
        example.setOrderByClause("status DESC");
        example.setOrderByClause("createTime DESC");
        return shareOrderMapper.selectByExample(example);
    }

    public List<ShareOrder> getShareOiderByShareId(Integer shareId) {
        ShareOrderExample example = new ShareOrderExample();
        example.createCriteria().andShareidEqualTo(shareId);
        example.setOrderByClause("status DESC");
        example.setOrderByClause("createTime DESC");
        return shareOrderMapper.selectByExample(example);
    }

    public ShareOrder getShareOrderById(Integer id) {
        return shareOrderMapper.selectByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean tuiding(int orderId, int userId) {
        ShareOrder shareOrder = shareOrderMapper.selectByPrimaryKey(orderId);
        shareOrder.setStatus(3);
        int res1 = shareOrderMapper.updateByPrimaryKeySelective(shareOrder);
        User user = userMapper.selectByPrimaryKey(userId);
        user.setBalance(user.getBalance() + shareOrder.getPrice());
        int res2 = userMapper.updateByPrimaryKeySelective(user);
        return res1 > 0 && res2 > 0;
    }

    public void updateStatusToStart(int id) {
        ShareOrder shareOrder = new ShareOrder();
        shareOrder.setId(id);
        shareOrder.setStatus(1);
        shareOrderMapper.updateByPrimaryKeySelective(shareOrder);
    }

    public int updateStatusToEnd(Integer orderId) {
        ShareOrder shareOrder = new ShareOrder();
        shareOrder.setId(orderId);
        shareOrder.setStatus(2);
        return shareOrderMapper.updateByPrimaryKeySelective(shareOrder);
    }
}
