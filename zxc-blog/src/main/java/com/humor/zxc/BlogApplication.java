package com.humor.zxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Administrator on 2017/8/3.
 */
@Configuration
@EntityScan(basePackages = "com.humor.zxc")
@EnableJpaRepositories(basePackages = "com.humor.zxc.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class BlogApplication {

    public static void main(String[] args){
        SpringApplication.run(BlogApplication.class, args);
    }

}
