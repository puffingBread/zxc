package com.puffingBread.zxc.service;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.vo.OauthTokenVo;

public interface LoginService {

    OauthTokenVo login(String username, String password) throws ReadMessageException;

}
