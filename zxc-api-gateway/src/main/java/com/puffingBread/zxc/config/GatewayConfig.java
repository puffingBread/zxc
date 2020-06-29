package com.puffingBread.zxc.config;

import com.puffingBread.zxc.filter.CrossFilter;
import com.puffingBread.zxc.filter.UserAuthFilter;
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
    public UserAuthFilter tokenFilter() {
        return new UserAuthFilter();
    }

    @Bean
    public CrossFilter crossFilter() {
        return new CrossFilter();
    }

}
