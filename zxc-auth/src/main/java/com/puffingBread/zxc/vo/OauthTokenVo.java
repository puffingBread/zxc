package com.puffingBread.zxc.vo;

import com.puffingBread.zxc.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angus on 2016/8/15.
 */
public class OauthTokenVo {
    private Long userId;
    private String mobile;
     private String userName;
     private String token;
     private int expiresIn;
     private String refreshToken;
     private List<String> roles;

    public OauthTokenVo() {
    }

    public OauthTokenVo(Long userId,
                        String mobile,
                        String userName,
                        String token,
                        int expiresIn,
                        String refreshToken,
                        List<String> roles) {
        this.userId = userId;
        this.mobile = mobile;
        this.userName = userName;
        this.token = token;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.roles = roles;
    }

    public static OauthTokenVo toVo(User user, AccessToken accessToken) {
        OauthTokenVo oauthTokenVo = new OauthTokenVo();
        oauthTokenVo.setUserId(user.getId());
        oauthTokenVo.setMobile(user.getMobilePhoneNum());
        oauthTokenVo.setToken(accessToken.getAccessToken());
        oauthTokenVo.setExpiresIn(accessToken.getExpiresIn() - 5);
        oauthTokenVo.setRefreshToken(accessToken.getRefreshToken());
        oauthTokenVo.setUserName(user.getUsername());

        List<String> roleList = new ArrayList<>(0);
//        Set<Role> roleSet = appUser.getRoles();
//        Iterator<Role> iterator = roleSet.iterator();
//        while (iterator.hasNext()) {
//            Role role = iterator.next();
//            roleList.add(role.getRole());
//        }
        oauthTokenVo.setRoles(roleList);
        return oauthTokenVo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "OauthTokenVo{" +
                "userId=" + userId +
                ", mobile='" + mobile + '\'' +
                ", userName='" + userName + '\'' +
                ", token='" + token + '\'' +
                ", expiresIn=" + expiresIn +
                ", refreshToken='" + refreshToken + '\'' +
                ", roles=" + roles +
                '}';
    }
}
