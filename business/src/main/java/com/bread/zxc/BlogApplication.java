package com.bread.zxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Administrator
 * @date 2017/8/3
 */
@Configuration
@EntityScan(basePackages = "com.puffingBread.zxc")
@EnableScheduling
@SpringBootApplication
@EnableDiscoveryClient
public class BlogApplication {

    public static void main(String[] args){
        SpringApplication.run(BlogApplication.class, args);
    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
