package com.puffingBread.zxc.interceptor;

import com.puffingBread.zxc.service.OAuthAgentService;
import com.puffingBread.zxc.vo.AccessToken;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationInterceptor implements RequestInterceptor {

    @Autowired
    OAuthAgentService oAuthAgentService;

    public void apply(RequestTemplate template) {
        AccessToken accessToken = oAuthAgentService.getAcessTokenByClientId();
        String token = accessToken.getAccessToken();
        template.header("Authorization", "Bearer " + token);
    }
}
