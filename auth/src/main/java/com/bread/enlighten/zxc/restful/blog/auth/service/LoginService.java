package com.bread.enlighten.zxc.restful.blog.auth.service;

import com.bread.enlighten.zxc.restful.blog.auth.vo.OauthTokenVo;
import com.bread.zxc.common.exception.ReadMessageException;

public interface LoginService {

    OauthTokenVo login(String username, String password) throws ReadMessageException;

}
