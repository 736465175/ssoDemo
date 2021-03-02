package com.lizhiqiang.authserver.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;

/**
 * 然后就是我们最核心的授权配置，同样是使用AuthorizationServerConfigurerAdapter类来帮助我们进
 * 行配置
 * @author Lizhiqiang
 * @date 2021/2/26 16:25
 */

@Configuration
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private TokenStore tokenStore;
    @Resource
    private AuthenticationManager authenticationManager;

    //用来配置令牌端点的安全约束
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("permitAll()") // oauth/token_key公开
                .checkTokenAccess("permitAll()") // oauth/check_token公开
                .allowFormAuthenticationForClients();  // 表单认证，申请令牌
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client1")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token", "implicit")
                .resourceIds("res1")
                .scopes("all")
                .autoApprove(true) //自动授权
                .redirectUris("http://localhost:8301/clientA/login","http://localhost:8302/clientB/login")

                .and()

                .withClient("client2")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token", "implicit")
                .resourceIds("res2")
                .scopes("all")
                .autoApprove(true)
                .redirectUris("http://localhost:8301/clientA/login","http://localhost:8302/clientB/login");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager);
    }
}
