package com.puffingBread.zxc.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
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

}