package com.humor.zxc.config;

import com.humor.zxc.filter.CrossFilter;
import com.humor.zxc.filter.UserAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *  Date: 2019/4/29
 *  Time: 11:51
 *  @author xuzz
 */
@Configuration
public class GatewayConfig {

    @Bean
    public UserAuthFilter userAuthFilter() {
        return new UserAuthFilter();
    }

    @Bean
    public CrossFilter crossFilter() {
        return new CrossFilter();
    }

}
