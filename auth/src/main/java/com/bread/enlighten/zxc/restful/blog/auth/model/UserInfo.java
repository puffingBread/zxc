package com.bread.enlighten.zxc.restful.blog.auth.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_info", schema = "zxc_user", catalog = "")
public class UserInfo {
    private Long id;
    private Long userId;
    private String nikeName;
    private Integer sex;
    private Integer age;
    private String mobile;
    private Integer qqNumber;
    private String wechatNumber;
    private String email;
    private Date createdTime;
    private Date updateTime;
    private Integer status;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "nike_name")
    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    @Basic
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "qq_number")
    public Integer getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(Integer qqNumber) {
        this.qqNumber = qqNumber;
    }

    @Basic
    @Column(name = "wechat_number")
    public String getWechatNumber() {
        return wechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        this.wechatNumber = wechatNumber;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "created_time")
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (id != null ? !id.equals(userInfo.id) : userInfo.id != null) return false;
        if (userId != null ? !userId.equals(userInfo.userId) : userInfo.userId != null) return false;
        if (nikeName != null ? !nikeName.equals(userInfo.nikeName) : userInfo.nikeName != null) return false;
        if (sex != null ? !sex.equals(userInfo.sex) : userInfo.sex != null) return false;
        if (age != null ? !age.equals(userInfo.age) : userInfo.age != null) return false;
        if (mobile != null ? !mobile.equals(userInfo.mobile) : userInfo.mobile != null) return false;
        if (qqNumber != null ? !qqNumber.equals(userInfo.qqNumber) : userInfo.qqNumber != null) return false;
        if (wechatNumber != null ? !wechatNumber.equals(userInfo.wechatNumber) : userInfo.wechatNumber != null)
            return false;
        if (email != null ? !email.equals(userInfo.email) : userInfo.email != null) return false;
        if (createdTime != null ? !createdTime.equals(userInfo.createdTime) : userInfo.createdTime != null)
            return false;
        if (updateTime != null ? !updateTime.equals(userInfo.updateTime) : userInfo.updateTime != null) return false;
        if (status != null ? !status.equals(userInfo.status) : userInfo.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (nikeName != null ? nikeName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (qqNumber != null ? qqNumber.hashCode() : 0);
        result = 31 * result + (wechatNumber != null ? wechatNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
