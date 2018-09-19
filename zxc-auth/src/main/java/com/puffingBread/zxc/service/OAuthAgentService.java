package com.puffingBread.zxc.service;

import com.puffingBread.zxc.vo.AccessToken;

/**
 * Created by kevin on 16-11-4.
 */
public interface OAuthAgentService {
    AccessToken getAcessToken(String username, String password);

    AccessToken getAcessToken(String openId);

    AccessToken getAcessTokenByClientId();
}
