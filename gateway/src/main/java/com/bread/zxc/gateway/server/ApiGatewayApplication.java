package com.bread.zxc.gateway.server;

import com.bread.zxc.gateway.filter.ZuulExceptionFilter;
import com.bread.zxc.gateway.filter.AuthRedirectFilter;
import com.bread.zxc.gateway.filter.UserAuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kevin on 16-9-13.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.puffingBread.zxc")
@EnableZuulProxy
@SpringBootApplication
//@SpringCloudApplication    //整合了@SpringBootApplication、@EnableDiscoveryClient(服务发现）、@EnableCircuitBreaker（断路器）
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    FilterRegistrationBean getAuthRedirectFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthRedirectFilter());
        registration.addUrlPatterns(
                "/userauth/login/*",
                "/userauth/logout/*",
                "/userauth/user",
                "/userauth/userInfo/*",
                "/userauth/sms/**");
        registration.setName("AuthRedirectFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    UserAuthFilter getUserAuthFilter() {
        return new UserAuthFilter();
    }

    @Bean
    ZuulExceptionFilter getZuulExceptionFilter() {
        return new ZuulExceptionFilter();
    }
}