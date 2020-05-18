package com.luo.yiting.controller;

import com.luo.yiting.bean.RequstShareOrder;
import com.luo.yiting.bean.ShareOrder;
import com.luo.yiting.bean.User;
import com.luo.yiting.bean.UserSharePark;
import com.luo.yiting.cbmodel.ShareOrderInfo;
import com.luo.yiting.service.OrderService;
import com.luo.yiting.service.ParkService;
import com.luo.yiting.service.UserService;
import com.luo.yiting.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class OderController {

    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    ParkService parkService;

    //计算订单价格的接口
    @RequestMapping("/getOrderPrice")
    public Map calculatePrice(Float price, String startTime, String endTime) {
        float resPrice = getPrice(price, startTime, endTime);
        Map<String, Object> map = new HashMap<>();
        map.put("price", resPrice);
        return map;
    }

    //添加共享车位订单
    @RequestMapping(value = "/addShareOrder", method = RequestMethod.POST)
    public Map addShareOrder(@RequestBody RequstShareOrder request) {
        ShareOrder shareOrder = new ShareOrder();
        shareOrder.setUserid(request.getUserId());
        shareOrder.setStarttime(Util.stringFormatTime(request.getStartTime()));
        shareOrder.setEndtime(Util.stringFormatTime(request.getEndTime()));
        shareOrder.setPrice(request.getPrice());
        shareOrder.setRemark(request.getBeizhu());
        shareOrder.setShareid(request.getShareId());
        shareOrder.setLicensePlate(request.getCar());

        Map<String, Object> map = new HashMap<>();

        //1、先检查密码是否输入正确
        String pwd = userService.getPasswordById(request.getUserId());
        if (!request.getPassword().equals(pwd)) {
            map.put("code", 500);
            map.put("msg", "密码错误");
            return map;
        }

        //2、如果余额支付，检查余额是否足够，并且去更新余额
        User user = userService.getUserById(request.getUserId());
        if (request.getPrice() > user.getBalance()) {
            map.put("code", 300);
            map.put("msg", "您的余额不足");
            return map;
        }

        user.setBalance(user.getBalance() - request.getPrice());
        int a = userService.updateUser(user);
        //3、插入订单信息
        int res = orderService.addShareOrder(shareOrder);
        int code = res == 0 ? 201 : 200;
        String msg = res == 0 ? "失败" : "成功";
        map.put("code", code);
        map.put("msg", msg);
        return map;
    }

    @RequestMapping("/getShareOrderById")
    public Map getShareOrder(Integer userId) {
        List<ShareOrder> shareOrders = orderService.getShareOiderByUserId(userId);
        List<ShareOrderInfo> shareOrderInfos = new ArrayList<>();
        if (shareOrders != null && shareOrders.size() > 0) {
            for (int i = 0; i < shareOrders.size(); i++) {
                ShareOrder shareOrder = shareOrders.get(i);
                UserSharePark userSharePark = parkService.getUserShareParkById(shareOrder.getShareid());
                User user = userService.getUserById(userSharePark.getUserid());
                ShareOrderInfo shareOrderInfo = new ShareOrderInfo(shareOrder, user, userSharePark);
                shareOrderInfos.add(shareOrderInfo);
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("shareOrderInfos", shareOrderInfos);
        return map;
    }

    // 查看共享车位的预定情况
    @RequestMapping("/getShareOrderBookDetail")
    public Map getShareOrderBookDetail(Integer id) {
        List<ShareOrder> shareOrders = orderService.getShareOiderByShareId(id);
        List<ShareOrderInfo> shareOrderInfos = new ArrayList<>();
        if (shareOrders != null && shareOrders.size() > 0) {
            for (int i = 0; i < shareOrders.size(); i++) {
                ShareOrder shareOrder = shareOrders.get(i);
                UserSharePark userSharePark = parkService.getUserShareParkById(shareOrder.getShareid());
                User user = userService.getUserById(shareOrder.getUserid());
                ShareOrderInfo shareOrderInfo = new ShareOrderInfo(shareOrder, user, userSharePark);
                shareOrderInfos.add(shareOrderInfo);
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("shareOrderInfos", shareOrderInfos);
        return map;
    }

    //退订
    @RequestMapping("/tuiding")
    public Map tuiding(Integer orderId, Integer userId) {
        // 先检查是否当前时间在预定开始前一个小时

        //检查订单状态，如果是正在进行中的订单无法退订

        boolean res = orderService.tuiding(orderId, userId);
        Map<String, Object> map = new HashMap<>();
        map.put("code", res ? 200 : 500);
        return map;
    }

    //检查自己是否预定过该共享车位或该共享车位该时段内是否被被人预定了或者车位业主删除了此订单
    public void checkBook() {

    }

    private Float getPrice(Float price, String startTime, String endTime) {
        String[] arr1 = startTime.split(":");
        String[] arr2 = endTime.split(":");
        int startH = Integer.parseInt(arr1[0]);
        int startM = Integer.parseInt(arr1[1]);
        int endH = Integer.parseInt(arr2[0]);
        int endM = Integer.parseInt(arr2[1]);

        float time = endH - startH;
        if (startM != 0 && endM == 0) {
            time -= 0.5;
        } else if (startM == 0 && endM != 0) {
            time += 0.5;
        }
        return price * time;
    }
}
