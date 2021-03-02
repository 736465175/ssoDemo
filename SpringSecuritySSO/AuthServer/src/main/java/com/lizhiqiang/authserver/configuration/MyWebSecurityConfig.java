package com.lizhiqiang.authserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.annotation.Resource;

/**
 * 然后我们需要按照SpringSecurity的方式，首先提供一个继承于WebSecurityConfigurerAdapter类的
 * SpringSecurity的配置管理器，负责整个SpringSecurity的权限配置
 * @author Lizhiqiang
 * @date 2021/2/26 16:19
 */
@EnableWebSecurity
//这里使用了@EnableGlobalMethodSecurity方法打开了基于注解的方法级别的权限验证
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(
                User.withUsername("admin").password(passwordEncoder.encode("admin")).authorities("mobile","salary").build(),
                User.withUsername("manager").password(passwordEncoder.encode("manager")).authorities("salary").build(),
                User.withUsername("worker").password(passwordEncoder.encode("worker")).authorities("worker").build()
        );
        return userDetailsManager;
    }

    //配置用户的安全拦截策略
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated() //其他请求需要登录
                .and()
                .csrf().disable() //关闭csrf跨域检查
                .formLogin(); //可从默认的login页面登录，并且登录后跳转到main.html

    }
}
