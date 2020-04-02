package com.bread.enlighten.zxc.restful.blog.auth.service;

import com.bread.enlighten.zxc.restful.blog.auth.vo.AccessToken;

/**
 * Created by kevin on 16-11-4.
 */
public interface OAuthAgentService {

    AccessToken getAccessToken(String username, String password);

    AccessToken getAccessTokenByClientId();

    AccessToken refreshAccessToken(String refreshToken);

}
