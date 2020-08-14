package com.humor.zxc.service;

import com.humor.zxc.common.exception.ReadMessageException;
import com.humor.zxc.vo.OauthTokenVo;

public interface LoginService {

    OauthTokenVo login(String username, String password) throws ReadMessageException;

}
