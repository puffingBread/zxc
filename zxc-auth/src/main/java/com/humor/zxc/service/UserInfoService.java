package com.humor.zxc.service;

import com.humor.zxc.model.UserInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
public interface UserInfoService {

    List<UserInfo> getAll();

    UserInfo getByUserId(Long userId);
}
