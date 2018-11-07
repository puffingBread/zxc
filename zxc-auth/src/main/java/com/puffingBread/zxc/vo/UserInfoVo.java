package com.puffingBread.zxc.vo;

import com.puffingBread.zxc.model.UserInfo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/2.
 */
public class UserInfoVo implements Serializable {
    private Long id;
    private Long userId;
    private String nikeName;
    private int sex;
    private int age;
    private Integer qqNumber;
    private Integer mobile;
    private String weixinNumber;
    private String eMail;
    private Integer createTime;
    private Integer updateTime;
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(Integer qqNumber) {
        this.qqNumber = qqNumber;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getWeixinNumber() {
        return weixinNumber;
    }

    public void setWeixinNumber(String weixinNumber) {
        this.weixinNumber = weixinNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static UserInfo toModel(UserInfoVo vo){
        UserInfo userInfo = new UserInfo();
//        userInfo.setUserId(vo.getUserId());
//        userInfo.setUserId(vo.getUserId());
//        userInfo.setNikeName(vo.getNikeName());
//        userInfo.setAge(vo.getAge());
//        userInfo.setSex(vo.getSex());
//        userInfo.setMobile(vo.getMobile());
//        userInfo.seteMail(vo.geteMail());
//        userInfo.setQqNumber(vo.getQqNumber());
//        userInfo.setWeixinNumber(vo.getWeixinNumber());
//        userInfo.setCreateTime(new Date(vo.getCreateTime()));
//        userInfo.setUpdateTime(new Date(vo.getCreateTime()));
//        userInfo.setStatus(vo.getStatus());
        return userInfo;
    }

    public static UserInfoVo toVo(UserInfo userInfo){
        UserInfoVo vo = new UserInfoVo();
//        vo.setUserId(userInfo.getUserId());
//        vo.setUserId(userInfo.getUserId());
//        vo.setNikeName(userInfo.getNikeName());
//        vo.setAge(userInfo.getAge());
//        vo.setSex(userInfo.getSex());
//        vo.setMobile(userInfo.getMobile());
//        vo.setQqNumber(userInfo.getQqNumber());
//        vo.setWeixinNumber(userInfo.getWeixinNumber());
//        vo.seteMail(userInfo.geteMail());
//        vo.setCreateTime((int)(userInfo.getCreateTime().getTime()));
//        vo.setUpdateTime((int)userInfo.getCreateTime().getTime());
//        vo.setStatus(userInfo.getStatus());
        return vo;
    }
}
