package com.puffingBread.zxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@EntityScan(basePackages = "com.puffingBread.zxc")
@EnableJpaRepositories(basePackages = "com.puffingBread.zxc.dao")
@SpringBootApplication
@EnableDiscoveryClient
@EnableGlobalMethodSecurity
@EnableFeignClients("com.puffingBread.zxc")
public class AuthApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuthApplication.class, args);
	}

}
