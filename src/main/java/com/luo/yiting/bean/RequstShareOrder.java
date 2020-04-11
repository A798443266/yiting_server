package com.luo.yiting.bean;

public class RequstShareOrder {
    private Integer userId;
    private String startTime;
    private String endTime;
    private Float price;
    private String car;
    private String beizhu;
    private Integer shareId;
    private String password;

    public RequstShareOrder() {
    }

    public RequstShareOrder(Integer userId, String startTime, String endTime, Float price, String car, String beizhu, Integer shareId,String password) {
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.car = car;
        this.beizhu = beizhu;
        this.shareId = shareId;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }
}
