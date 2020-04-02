package com.bread.enlighten.zxc.restful.blog.auth.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017/8/5.
 */
public class AuthUserDetails implements UserDetails {
    private Long userId;
    private String username;
    private String password;
    private String status;
    private List<SimpleGrantedAuthority> grantedAuthorities;

    public AuthUserDetails() {

    }

    public AuthUserDetails(Long userId, String username, String password, String status, List<SimpleGrantedAuthority> grantedAuthorities) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.status = status;
        this.grantedAuthorities = grantedAuthorities;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SimpleGrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(List<SimpleGrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }
}
