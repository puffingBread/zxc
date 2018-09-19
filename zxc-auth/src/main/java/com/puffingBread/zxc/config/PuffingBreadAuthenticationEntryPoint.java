package com.puffingBread.zxc.config;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kevin on 18.11.2016.
 */
@Component
public class PuffingBreadAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        if ("application/json".equals(request.getContentType())) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            response.getWriter().print("{'status': 400, 'title': '您尚未登录！不允许访问'}");
        } else {
           new  LoginUrlAuthenticationEntryPoint("/loginPage").commence(request, response, authException);
        }

    }
}
