package com.luo.yiting.service;

import com.luo.yiting.bean.ShareOrderExample;
import com.luo.yiting.bean.ShareOrderExtra;
import com.luo.yiting.bean.ShareOrderExtraExample;
import com.luo.yiting.mapper.ShareOrderExtraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShareOderExtraService {
    @Autowired
    ShareOrderExtraMapper mapper;

    //车主开始停车拍照上传
    @Transactional(rollbackFor = Exception.class)
    public int updateBookerUpPic(ShareOrderExtra extra) {
        //已经有了记录
        if (hasExtra(extra.getOrderid())) {
            ShareOrderExtraExample extraExample = new ShareOrderExtraExample();
            ShareOrderExtraExample.Criteria criteria =  extraExample.createCriteria();
            criteria.andOrderidEqualTo(extra.getOrderid());
            return mapper.updateByExampleSelective(extra, extraExample);
        } else {
            return mapper.insertSelective(extra);
        }
    }

    // 停车位业主超时违停拍照上传
    @Transactional(rollbackFor = Exception.class)
    public int updateAnnouncerUpPic(ShareOrderExtra extra) {
        //已经有了记录
        if (hasExtra(extra.getOrderid())) {
            ShareOrderExtraExample extraExample = new ShareOrderExtraExample();
            ShareOrderExtraExample.Criteria criteria =  extraExample.createCriteria();
            criteria.andOrderidEqualTo(extra.getOrderid());
            return mapper.updateByExampleSelective(extra, extraExample);
        } else {
            return mapper.insertSelective(extra);
        }
    }

    public ShareOrderExtra selectShareExtraByOrderId(int orderId) {
        ShareOrderExtraExample extraExample = new ShareOrderExtraExample();
        extraExample.createCriteria().andOrderidEqualTo(orderId);
        List<ShareOrderExtra> extras =  mapper.selectByExample(extraExample);
        if (extras == null) {
            return null;
        }
        if (extras.size() == 0) {
            return null;
        }
        return extras.get(0);
    }

    //得到所有待审核的超时违停拍照
    public List<ShareOrderExtra> getAllPendingReviewExtra() {
        ShareOrderExtraExample extraExample = new ShareOrderExtraExample();
        extraExample.createCriteria().andStatusEqualTo(1);
        return mapper.selectByExample(extraExample);
    }

    public int updateByPrimaryKey(ShareOrderExtra extra) {
        return mapper.updateByPrimaryKeySelective(extra);
    }

    //判断数据库中是否已经有这条记录
    public boolean hasExtra(int oderId) {
        ShareOrderExtraExample extraExample = new ShareOrderExtraExample();
        extraExample.createCriteria().andOrderidEqualTo(oderId);
        List<ShareOrderExtra> extras =  mapper.selectByExample(extraExample);
        if (extras == null) return false;
        if (extras.size() == 0) return false;
        return true;
    }

}
