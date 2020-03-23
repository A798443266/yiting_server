package com.luo.yiting.cbmodel;

import com.luo.yiting.bean.User;
import com.luo.yiting.bean.UserSharePark;

public class ShareInfo {
    private UserSharePark userSharePark;
    private User user;

    public ShareInfo() {
    }

    public UserSharePark getUserSharePark() {
        return userSharePark;
    }

    public void setUserSharePark(UserSharePark userSharePark) {
        this.userSharePark = userSharePark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
