package com.puffingBread.zxc.service.impl;

import com.puffingBread.zxc.service.OAuthAgentService;
import com.puffingBread.zxc.vo.AccessToken;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;

@Service
public class OAuthAgentServiceImpl implements OAuthAgentService {

    @Value("${spring.security.oauth2.client.accessTokenUri}")
    private String accessTokenUri;

    @Value("${spring.security.oauth2.client.userAuthorizationUri}")
    private String authorizationUri;

    @Value("${spring.security.oauth2.client.clientId}")
    private String oauthClientId;

    @Value("${spring.security.oauth2.client.clientSecret}")
    private String oauthClientSecret;

    @Override
    public AccessToken getAccessToken(String username, String password) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new MyErrorHandler());
        String uri = accessTokenUri + "?grant_type=password&username=" + username + "&password=" + password;
        ResponseEntity<AccessToken> resp;
        try {
            resp = restTemplate.exchange
                    (uri, HttpMethod.POST, new HttpEntity<String>(createHeaders(oauthClientId, oauthClientSecret)), AccessToken.class);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return null;
        }

        return resp.getBody();
    }

    @Override
    public AccessToken getAccessTokenByClientId() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new MyErrorHandler());
        String uri = accessTokenUri + "?grant_type=client_credentials";
        ResponseEntity<AccessToken> resp = null;
        try {
            resp = restTemplate.exchange
                    (uri, HttpMethod.POST, new HttpEntity<String>(createHeaders(oauthClientId, oauthClientSecret)), AccessToken.class);
        } catch (HttpClientErrorException e) {
            return null;
        }
        return resp.getBody();
    }

    private HttpHeaders createHeaders(final String username, final String password) {
        return new HttpHeaders() {
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                System.out.println("==============>>> header: " + authHeader);
                set("Authorization", authHeader);
            }
        };
    }

    private class MyErrorHandler implements ResponseErrorHandler {

        @Override
        public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
            return clientHttpResponse.getStatusCode() != HttpStatus.OK;
        }

        @Override
        public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
            HttpStatus statusCode = clientHttpResponse.getStatusCode();
            throw new HttpClientErrorException(statusCode);
        }
    }

    public AccessToken refreshAccessToken(String refreshToken) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new MyErrorHandler());
        String uri = accessTokenUri + "?grant_type=refresh_token&refresh_token=" + refreshToken;
        ResponseEntity<AccessToken> resp;
        try {
            resp = restTemplate.postForEntity(uri, new HttpEntity<String>(createHeaders(oauthClientId, oauthClientSecret)), AccessToken.class);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return null;
        }

        return resp.getBody();
    }
}
