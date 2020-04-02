package com.bread.enlighten.zxc.restful.blog.auth.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by kevin on 12.11.2016.
 */
public class AppUserDetails implements UserDetails {
    private Long userId;
    private String username;
    private String password;
    private String status;
    private String permission;
    private List<SimpleGrantedAuthority> grantedAuthorities;

    public AppUserDetails() {

    }

    public AppUserDetails(Long userId, String username, String password, String status, String permission, List<SimpleGrantedAuthority> grantedAuthorities) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.status = status;
        this.permission = permission;
        this.grantedAuthorities = grantedAuthorities;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return "enable".equalsIgnoreCase(status);
    }
}
