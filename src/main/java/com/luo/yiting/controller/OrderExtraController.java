package com.luo.yiting.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luo.yiting.bean.*;
import com.luo.yiting.cbmodel.TimeoutVerify;
import com.luo.yiting.service.OrderService;
import com.luo.yiting.service.ParkService;
import com.luo.yiting.service.ShareOderExtraService;
import com.luo.yiting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
public class OrderExtraController {
    @Autowired
    ShareOderExtraService service;
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    ParkService parkService;

    //车主点击开始修改订单为开始状态
    @RequestMapping(value = "/startShareOrder", method = RequestMethod.POST)
    public Map setStatus(@RequestParam(value = "pic", required = false) MultipartFile pic,
                         Integer orderId) {

        String path = System.getProperty("user.dir") + "/src/main/resources/static/image/orderextra";
        String picUrl = "";
        ShareOrderExtra shareOrderExtra = new ShareOrderExtra();
        if (!StringUtils.isEmpty(pic)) {
            String picName = pic.getOriginalFilename();
            String suffixName = picName.substring(picName.lastIndexOf("."));
            picName = UUID.randomUUID().toString().replace("-", "") + suffixName;
            File file = new File(path, picName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            picUrl = "/image/orderextra/" + picName;
            try {
                pic.transferTo(new File(path + File.separator + picName));
                shareOrderExtra.setBookerUpPic(picUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        shareOrderExtra.setOrderid(orderId);
        int res = service.updateBookerUpPic(shareOrderExtra);
        if (res > 0) {
            //更新订单状态
            orderService.updateStatusToStart(orderId);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", res > 0 ? 200 : 500);
        return map;
    }

    @RequestMapping(value = "/endShareOrder", method = RequestMethod.POST)
    public Map endShareOrder(Integer orderId) {
        int res = orderService.updateStatusToEnd(orderId);
        Map<String, Object> map = new HashMap<>();
        map.put("code", res > 0 ? 200 : 500);
        return map;
    }

    @RequestMapping("/getUpPicByOrderId")
    public Map getUpPicByOrderId(int orderId) {
        ShareOrderExtra shareOrderExtra = service.selectShareExtraByOrderId(orderId);
        Map<String, Object> map = new HashMap<>();
        if (shareOrderExtra == null) {
            map.put("code", 500);
            return map;
        }
        map.put("code", 200);
        map.put("bookerUpPic", StringUtils.isEmpty(shareOrderExtra.getBookerUpPic()) ? "" : shareOrderExtra.getBookerUpPic());
        map.put("announcerUpPic", StringUtils.isEmpty(shareOrderExtra.getAnnouncerUpPic()) ? "" : shareOrderExtra.getAnnouncerUpPic());
        map.put("verifyStatus", shareOrderExtra.getStatus());
        map.put("upVerifyTime", shareOrderExtra.getAnnouncerTime());
        return map;
    }

    //停车位业主超时违停拍照
    @RequestMapping(value = "/upTimeoutVerify", method = RequestMethod.POST)
    public Map upTimeoutVerify(MultipartFile pic, Integer orderId,
                               @RequestParam(value = "remark", required = false) String remark) {
        String path = System.getProperty("user.dir") + "/src/main/resources/static/image/orderextra";
        ShareOrderExtra shareOrderExtra = new ShareOrderExtra();
        String picName = pic.getOriginalFilename();
        String suffixName = picName.substring(picName.lastIndexOf("."));
        picName = UUID.randomUUID().toString().replace("-", "") + suffixName;
        File file = new File(path, picName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        String picUrl = "/image/orderextra/" + picName;
        try {
            pic.transferTo(new File(path + File.separator + picName));
            shareOrderExtra.setAnnouncerUpPic(picUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        shareOrderExtra.setOrderid(orderId);
        shareOrderExtra.setStatus(1);
        if (!StringUtils.isEmpty(remark)) {
            shareOrderExtra.setRemark(remark);
        }
        int res = service.updateAnnouncerUpPic(shareOrderExtra);
        Map<String, Object> map = new HashMap<>();
        map.put("code", res > 0 ? 200 : 500);
        return map;
    }

    @RequestMapping("/getTimeoutVerify")
    public Map getTimeoutVerify(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ShareOrderExtra> shareOrderExtras = service.getAllPendingReviewExtra();
        if (shareOrderExtras == null || shareOrderExtras.size() == 0) {
            map.put("timeoutVerifies", shareOrderExtras);
            return map;
        }
        List<TimeoutVerify> timeoutVerifies = new ArrayList<>();
        for(int i = 0; i < shareOrderExtras.size(); i++) {
            ShareOrderExtra extra = shareOrderExtras.get(i);
            TimeoutVerify timeoutVerify = new TimeoutVerify();

            //查找订单信息
            ShareOrder shareOrder =  orderService.getShareOrderById(extra.getOrderid());
            //查找预订者
            User booker = userService.getUserById(shareOrder.getUserid());
            //查找发布者
            UserSharePark userSharePark = parkService.getUserShareParkById(shareOrder.getShareid());
            User announcer = userService.getUserById(userSharePark.getUserid());

            timeoutVerify.setAnnouncer(announcer);
            timeoutVerify.setBooker(booker);
            timeoutVerify.setShareOrder(shareOrder);
            timeoutVerify.setShareOrderExtra(extra);
            timeoutVerify.setId(extra.getId());
            timeoutVerify.setUserSharePark(userSharePark);
            timeoutVerifies.add(timeoutVerify);
        }
        PageInfo<TimeoutVerify> pageInfo = new PageInfo<>(timeoutVerifies);
        timeoutVerifies = pageInfo.getList();
        map.put("timeoutVerifies", timeoutVerifies);
        map.put("total", timeoutVerifies == null ? 0 : timeoutVerifies.size());
        return map;
    }


    //超时违停拍照通过审核
    @RequestMapping("/passTimeoutVerify")
    public Map passTimeoutVerify(Integer id) {
        ShareOrderExtra extra = new ShareOrderExtra();
        extra.setId(id);
        extra.setStatus(2);
        int res = service.updateByPrimaryKey(extra);
        //去扣除用户的积分
        
        Map<String, Object> map = new HashMap<>();
        map.put("code", res > 0 ? 200 : 500);
        return map;
    }

    //超时违停拍照通过审核
    @RequestMapping("/refuseTimeoutVerify")
    public Map refuseTimeoutVerify(Integer id) {
        ShareOrderExtra extra = new ShareOrderExtra();
        extra.setId(id);
        extra.setStatus(3);
        int res = service.updateByPrimaryKey(extra);
        Map<String, Object> map = new HashMap<>();
        map.put("code", res > 0 ? 200 : 500);
        return map;
    }
}
