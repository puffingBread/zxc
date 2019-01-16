package com.puffingBread.zxc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * The Class OAuth2Config defines the authorization server that would
 * authenticate the user and define the client that seeks authorization on the
 * resource owner's behalf.
 */


@Configuration
@EnableAuthorizationServer
public class ZxcOAuthConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private DataSource dataSource;


    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * The OAuth2 tokens are defined in the datasource defined in the
     * <code>auth-server.yml</code> file stored in the Spring Cloud config
     * github jpa.
     *
     */

    @Bean
    public JdbcTokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }


    @Bean
    protected AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    @Bean
    protected ClientDetailsService clientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security)
            throws Exception {
//         security.passwordEncoder(passwordEncoder);
         security.allowFormAuthenticationForClients();

    }


    /**
     * We set our authorization storage feature specifying that we would use the
     * <p>
     *     JDBC store for token and authorization code storage .<br> <br>
     * <p>
     * <p>
     * We also attach the
     * <p>
     * {@link AuthenticationManager}
     * <p>
     * so that password grants
     * <p>
     * can be
     * processed .
     */


    @Override

    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {


        endpoints.authorizationCodeServices(authorizationCodeServices())
                .authenticationManager(auth).tokenStore(tokenStore())

                .approvalStoreDisabled();
    }

    /**
     * Setup the
     * client application
     * which attempts
     * to get
     * access to
     * user's
     * <p>
     * account after
     * user permission.
     */


    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {

        clients.jdbc(dataSource)
                // .passwordEncoder(passwordEncoder)
                .withClient("client")
                .authorizedGrantTypes("authorization_code", "client_credentials",
                        "refresh_token", "password", "implicit")
                .authorities("ROLE_CLIENT")
                .scopes("read", "write")
                .secret("secret")
                .resourceIds("apis")
                .redirectUris("http://localhost:8082/login")
                .autoApprove(true)
                .accessTokenValiditySeconds(3000);
        clients.withClientDetails(this.clientDetailsService());

    }

    /**
     * Configure the
     * <p>
     * {
     *
     * @author anilallewar
     * @link AuthenticationManagerBuilder
     * }
     * <p>
     * with initial
     * <p>
     * configuration to
     * setup users.
     */


    @Configuration
    @Order(Ordered.LOWEST_PRECEDENCE - 20)

    protected static class AuthenticationManagerConfiguration extends
            GlobalAuthenticationConfigurerAdapter {
        private Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();


        @Autowired
        private DataSource dataSource;

        @Autowired
        @Qualifier("UserDetailsServiceImpl")
        private UserDetailsService userDetailsService;


        /**
         * Setup 2
         * users with
         * different roles
         */


        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {

            ReflectionSaltSource saltSource = new ReflectionSaltSource();
            saltSource.setUserPropertyToUse("username");

            DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setSaltSource(saltSource);
            provider.setPasswordEncoder(md5PasswordEncoder);
            provider.setUserDetailsService(userDetailsService);
            auth.authenticationProvider(provider);

            DaoAuthenticationProvider wechatProvider = new DaoAuthenticationProvider();
            wechatProvider.setUserDetailsService(userDetailsService);
            auth.authenticationProvider(wechatProvider);

            // @formatter:off
//            auth.jdbcAuthentication().dataSource(dataSource).withUser("dave")
//                    .password("secret").roles("USER");
//            auth.jdbcAuthentication().dataSource(dataSource).withUser("anil")
//                    .password("password").roles("ADMIN");
            // @formatter:on
        }
    }

}
