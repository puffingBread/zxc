package com.bread.zxc.auth.service;

import com.bread.zxc.common.exception.ReadMessageException;
import com.bread.zxc.auth.vo.OauthTokenVo;

public interface LoginService {

    OauthTokenVo login(String username, String password) throws ReadMessageException;

}
