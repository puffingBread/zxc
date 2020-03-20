package com.bread.zxc.auth.service.impl;

import com.bread.zxc.auth.dao.UserRepository;
import com.bread.zxc.auth.service.LoginService;
import com.bread.zxc.auth.vo.AccessToken;
import com.bread.zxc.common.exception.ReadMessageException;
import com.bread.zxc.auth.model.User;
import com.bread.zxc.auth.service.OAuthAgentService;
import com.bread.zxc.auth.vo.OauthTokenVo;
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
