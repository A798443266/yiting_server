package com.luo.yiting.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ShareOrderExtra {
    private Integer id;

    private String bookerUpPic;

    private String announcerUpPic;

    private Integer orderid;

    private String remark;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date bookerTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date announcerTime;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookerUpPic() {
        return bookerUpPic;
    }

    public void setBookerUpPic(String bookerUpPic) {
        this.bookerUpPic = bookerUpPic == null ? null : bookerUpPic.trim();
    }

    public String getAnnouncerUpPic() {
        return announcerUpPic;
    }

    public void setAnnouncerUpPic(String announcerUpPic) {
        this.announcerUpPic = announcerUpPic == null ? null : announcerUpPic.trim();
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getBookerTime() {
        return bookerTime;
    }

    public void setBookerTime(Date bookerTime) {
        this.bookerTime = bookerTime;
    }

    public Date getAnnouncerTime() {
        return announcerTime;
    }

    public void setAnnouncerTime(Date announcerTime) {
        this.announcerTime = announcerTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}