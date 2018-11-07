package com.puffingBread.zxc.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * Since the all restful api endpoint needs to be protected to be accessed only after the
 * OAuth2 authentication is successful; the server also becomes a resource
 * server.
 *
 * @author anilallewar
 */
@Configuration
@EnableResourceServer
public class ZxcResourceServerConfigurationAdapter extends ResourceServerConfigurerAdapter {

    @Autowired
    private ZxcAuthenticationEntryPoint authenticationEntryPoint;




    /**
     * Configure security to allow access to the /me endpoint only if the OAuth
     * authorization returns "read" scope.<br>
     * <br>
     * <p>
     * If you look at
     * {@link OAuthConfiguration#configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)}
     * to check that by default the authorization server allows "read" scope
     * only.
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http

                .authorizeRequests()
                .antMatchers("/me").access("#oauth2.hasScope('read')")
                .antMatchers("/user/**").authenticated()

                // access login page doesn't need protection

                // This is neccessary: mark url /login as login process endpoint.
                .and().exceptionHandling().authenticationEntryPoint(this.authenticationEntryPoint)

                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .failureForwardUrl("/loginPage?failed=true")
                .successHandler(this.savedRequestAwareAuthenticationSuccessHandler());

        // @formatter:on
    }

    /**
     * Id of the resource that you are letting the client have access to.
     * Supposing you have another api ("say api2"), then you can customize the
     * access within resource server to define what api is for what resource id.
     * <br>
     * <br>
     * <p>
     * So suppose you have 2 APIs, then you can define 2 resource servers.
     * <ol>
     * <li>Client 1 has been configured for access to resourceid1, so he can
     * only access "api1" if the resource server configures the resourceid to
     * "api1".</li>
     * <li>Client 1 can't access resource server 2 since it has configured the
     * resource id to "api2"
     * </li>
     * </ol>
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("apis");
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {
        SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
        handler.setUseReferer(true);
        return handler;
    }

    @LoadBalanced
    @Bean
    OAuth2RestTemplate oAuth2RestTemplate (OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context) {
        return new OAuth2RestTemplate(resource, context);
    }
}
