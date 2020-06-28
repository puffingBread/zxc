package com.puffingBread.zxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/8/3.
 */
@Configuration
@EntityScan(basePackages = "com.puffingBread.zxc")
@EnableJpaRepositories(basePackages = "com.puffingBread.zxc.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class BlogApplication {

    public static void main(String[] args){
        SpringApplication.run(BlogApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate RestTemplate() {
        return new RestTemplate();
    }
}
