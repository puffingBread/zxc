package com.bread.enlighten.zxc.restful.blog.auth.service.impl;

import com.bread.enlighten.zxc.restful.blog.auth.dao.UserRepository;
import com.bread.enlighten.zxc.restful.blog.auth.model.User;
import com.bread.enlighten.zxc.restful.blog.auth.service.OAuthAgentService;
import com.bread.enlighten.zxc.restful.blog.auth.vo.AccessToken;
import com.bread.enlighten.zxc.restful.blog.auth.vo.OauthTokenVo;
import com.bread.enlighten.zxc.restful.blog.auth.service.LoginService;
import com.bread.zxc.common.exception.ReadMessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    OAuthAgentService oAuthAgentService;

    @Autowired
    UserRepository userRepository;

    @Override
    public OauthTokenVo login(String username, String password) throws ReadMessageException {

        AccessToken accessToken = oAuthAgentService.getAccessToken(username, password);
        if (accessToken == null || accessToken.getAccessToken() == null) {
            throw new ReadMessageException("密码错误");
        }

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ReadMessageException("找不到用户");
        }

        return OauthTokenVo.toVo(user, accessToken);
    }
}
