package com.puffingBread.zxc.server;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/8/3.
 */
@Configuration
@ComponentScan("com.puffingBread.zxc")
@EnableAutoConfiguration
@EntityScan(basePackages = "com.puffingBread.zxc")
@EnableJpaRepositories(basePackages = "com.puffingBread.zxc.dao")
@EnableScheduling
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class BlogApplication {
    public static void main(String args[]){
        SpringApplication.run(BlogApplication.class, args);
    }

    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
        return hemf.getSessionFactory();
    }

    @Bean
    @LoadBalanced
    RestTemplate RestTemplate() {
        return new RestTemplate();
    }
}
