package com.bread.zxc.auth.service;

import com.bread.zxc.auth.vo.AccessToken;

/**
 * Created by kevin on 16-11-4.
 */
public interface OAuthAgentService {

    AccessToken getAccessToken(String username, String password);

    AccessToken getAccessTokenByClientId();

    AccessToken refreshAccessToken(String refreshToken);

}
