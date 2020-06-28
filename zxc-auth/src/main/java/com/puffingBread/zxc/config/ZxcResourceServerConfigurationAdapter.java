//package com.puffingBread.zxc.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.client.OAuth2ClientContext;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//
///**
// * Since the all restful api endpoint needs to be protected to be accessed only after the
// * OAuth2 authentication is successful; the server also becomes a resource
// * server.
// *
// * @author anilallewar
// */
//@Configuration
//@EnableResourceServer
//public class ZxcResourceServerConfigurationAdapter extends ResourceServerConfigurerAdapter {
//
//
//    @Autowired
//    private ZxcAuthenticationEntryPoint authenticationEntryPoint;
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/me").access("#oauth2.hasScope('read')")
//                .antMatchers("/user/**").authenticated()
//                .and().exceptionHandling().authenticationEntryPoint(this.authenticationEntryPoint)
//                .and().formLogin().loginProcessingUrl("/login").failureForwardUrl("/login")
//                .successHandler(this.savedRequestAwareAuthenticationSuccessHandler());
//    }
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.resourceId("apis");
//    }
//
//    @Bean
//    public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {
//        SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
//        handler.setUseReferer(true);
//        return handler;
//    }
//
//    @LoadBalanced
//    @Bean
//    OAuth2RestTemplate oAuth2RestTemplate(OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context) {
//        return new OAuth2RestTemplate(resource, context);
//    }
//}
