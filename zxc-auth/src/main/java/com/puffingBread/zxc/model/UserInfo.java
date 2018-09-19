package com.puffingBread.zxc.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/2.
 */
@Entity
@Table(name = "user_info", schema = "zxc_auth", catalog = "")
public class UserInfo {
    private long id;
    private long userId;
    private String nikeName;
    private int sex;
    private int age;
    private Integer qqNumber;
    private int mobile;
    private String weixinNumber;
    private String eMail;
    private Date createTime;
    private Date updateTime;
    private int status;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "nike_name", nullable = false, length = 32)
    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    @Basic
    @Column(name = "sex", nullable = false)
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "qq_number", nullable = true)
    public Integer getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(Integer qqNumber) {
        this.qqNumber = qqNumber;
    }

    @Basic
    @Column(name = "mobile", nullable = false)
    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "weixin_number", nullable = true, length = 32)
    public String getWeixinNumber() {
        return weixinNumber;
    }

    public void setWeixinNumber(String weixinNumber) {
        this.weixinNumber = weixinNumber;
    }

    @Basic
    @Column(name = "e_mail", nullable = true, length = 64)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (id != userInfo.id) return false;
        if (userId != userInfo.userId) return false;
        if (sex != userInfo.sex) return false;
        if (age != userInfo.age) return false;
        if (mobile != userInfo.mobile) return false;
        if (status != userInfo.status) return false;
        if (nikeName != null ? !nikeName.equals(userInfo.nikeName) : userInfo.nikeName != null) return false;
        if (qqNumber != null ? !qqNumber.equals(userInfo.qqNumber) : userInfo.qqNumber != null) return false;
        if (weixinNumber != null ? !weixinNumber.equals(userInfo.weixinNumber) : userInfo.weixinNumber != null)
            return false;
        if (eMail != null ? !eMail.equals(userInfo.eMail) : userInfo.eMail != null) return false;
        if (createTime != null ? !createTime.equals(userInfo.createTime) : userInfo.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(userInfo.updateTime) : userInfo.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (nikeName != null ? nikeName.hashCode() : 0);
        result = 31 * result + sex;
        result = 31 * result + age;
        result = 31 * result + (qqNumber != null ? qqNumber.hashCode() : 0);
        result = 31 * result + mobile;
        result = 31 * result + (weixinNumber != null ? weixinNumber.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }
}
