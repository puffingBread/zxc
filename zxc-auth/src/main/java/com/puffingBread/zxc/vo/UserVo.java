package com.puffingBread.zxc.vo;

import com.puffingBread.zxc.model.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/2.
 */
public class UserVo implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String mobilePhoneNum;
    private Date createdTime;
    private Date updatedTime;
    private Long createdBy;
    private Long updatedBy;

    public static UserVo toVo(User user) {
        UserVo vo = new UserVo();
        vo.setId(user.getId());
        vo.setUsername(user.getUsername());
        vo.setPassword(user.getPassword());
        vo.setMobilePhoneNum(user.getMobilePhoneNum());
        vo.setCreatedTime(user.getCreatedTime());
        vo.setUpdatedTime(user.getUpdatedTime());
        vo.setCreatedBy(user.getCreatedBy());
        vo.setUpdatedBy(user.getUpdatedBy());
        return vo;
    }

    public static User toModel(UserVo vo) {
        User user = new User();
        user.setId(vo.getId());
        user.setUsername(vo.getUsername());
        user.setPassword(vo.getPassword());
        user.setMobilePhoneNum(vo.getMobilePhoneNum());
        if (vo.getId() == null) {
            user.setCreatedTime(new Date());
            user.setCreatedBy(vo.getCreatedBy());
        }
        user.setUpdatedTime(new Date());
        user.setUpdatedBy(vo.getUpdatedBy());
        user.setStatus("enable");
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilePhoneNum() {
        return mobilePhoneNum;
    }

    public void setMobilePhoneNum(String mobilePhoneNum) {
        this.mobilePhoneNum = mobilePhoneNum;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
}
