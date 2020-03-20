package com.bread.zxc.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 *
 *
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
@EnableGlobalMethodSecurity
@EnableFeignClients("com.puffingBread.zxc")
public class AuthApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuthApplication.class, args);
	}

}
