package com.puffingBread.zxc.service;

import com.puffingBread.zxc.vo.AccessToken;

/**
 * Created by kevin on 16-11-4.
 */
public interface OAuthAgentService {

    AccessToken getAccessToken(String username, String password);

    AccessToken getAccessTokenByClientId();

    AccessToken refreshAccessToken(String refreshToken);

}
