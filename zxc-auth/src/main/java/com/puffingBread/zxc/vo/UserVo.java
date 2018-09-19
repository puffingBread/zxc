package com.puffingBread.zxc.vo;

import com.puffingBread.zxc.model.User;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/8/2.
 */
public class UserVo implements Serializable {

    private Long userId;
    private String userName;
    private String password;
    private Integer status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static UserVo toVo(User user){
        UserVo vo = new UserVo();
        vo.setUserId(user.getUserId());
        vo.setUserName(user.getUserName());
        vo.setPassword(user.getPassword());
        vo.setStatus(user.getStatus());
        return vo;
    }

    public static User toModel(UserVo vo){
        User user = new User();
        if (vo.getUserId() != null){
            user.setUserId(vo.getUserId());
        }
        user.setUserName(vo.getUserName());
        user.setPassword(vo.getPassword());
        user.setStatus(vo.getStatus() == null ? 0 : vo.getStatus());
        return user;
    }
}
