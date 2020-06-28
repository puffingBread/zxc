package com.puffingBread.zxc.service.impl;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.dao.UserRepository;
import com.puffingBread.zxc.model.User;
import com.puffingBread.zxc.service.LoginService;
import com.puffingBread.zxc.service.OAuthAgentService;
import com.puffingBread.zxc.vo.AccessToken;
import com.puffingBread.zxc.vo.OauthTokenVo;
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
