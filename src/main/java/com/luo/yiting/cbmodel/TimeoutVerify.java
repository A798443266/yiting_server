package com.luo.yiting.cbmodel;

import com.luo.yiting.bean.ShareOrder;
import com.luo.yiting.bean.ShareOrderExtra;
import com.luo.yiting.bean.User;
import com.luo.yiting.bean.UserSharePark;

public class TimeoutVerify {
    private int id;
    //订单附加审核附加信息
    private ShareOrderExtra shareOrderExtra;
    //订单发布者
    private User announcer;
    //订单预定者
    private User booker;
    //订单信息
    private ShareOrder shareOrder;
    private UserSharePark userSharePark;

    public TimeoutVerify() {
    }

    public TimeoutVerify(int id, ShareOrderExtra shareOrderExtra, User announcer, User booker, ShareOrder shareOrder, UserSharePark userSharePark) {
        this.id = id;
        this.shareOrderExtra = shareOrderExtra;
        this.announcer = announcer;
        this.booker = booker;
        this.shareOrder = shareOrder;
        this.userSharePark = userSharePark;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserSharePark getUserSharePark() {
        return userSharePark;
    }

    public void setUserSharePark(UserSharePark userSharePark) {
        this.userSharePark = userSharePark;
    }

    public ShareOrderExtra getShareOrderExtra() {
        return shareOrderExtra;
    }

    public void setShareOrderExtra(ShareOrderExtra shareOrderExtra) {
        this.shareOrderExtra = shareOrderExtra;
    }

    public User getAnnouncer() {
        return announcer;
    }

    public void setAnnouncer(User announcer) {
        this.announcer = announcer;
    }

    public User getBooker() {
        return booker;
    }

    public void setBooker(User booker) {
        this.booker = booker;
    }

    public ShareOrder getShareOrder() {
        return shareOrder;
    }

    public void setShareOrder(ShareOrder shareOrder) {
        this.shareOrder = shareOrder;
    }
}
