package com.puffingBread.zxc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Arrays;

/**
 * Created by kevin on 19.11.2016.
 */
@Configuration
@EnableWebSecurity
public class GatewayWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers(
                "/userauth/oauth/**",
                "/userauth/webjars/**",
                "/userauth/images/**",
                "/userauth/login/client",
                "/userauth/login/worker",
                "/userauth/loginPage",
                "/userauth/logout/confirm"
        );//ssc-auth

        web.ignoring().mvcMatchers(
                "/user/login/client",
                "/user/login/worker",
                "/user/logout/confirm"
        );//ssc-user

        web.ignoring().mvcMatchers(HttpMethod.GET,
                "/erp/leds",
                "/erp/device",
                "/erp/**/*.html"
        );//ssc-erp


//        web.ignoring().mvcMatchers("/**");//ssc-web

//        web.ignoring().mvcMatchers("/**");//ssc-daq

//        web.ignoring().mvcMatchers("/**");//ssc-market

        String[] activeProfiles = environment.getActiveProfiles();
        if(!Arrays.toString(activeProfiles).contains("product")) {
            web.ignoring().mvcMatchers("/*/swagger-ui.html",
                    "/*/webjars/springfox-swagger-ui/**",
                    "/*/swagger-resources/configuration/ui",
                    "/*/swagger-resources",
                    "/*/v2/api-docs",
                    "/*/swagger-resources/configuration/security"
            ); // swagger
        }
    }
}