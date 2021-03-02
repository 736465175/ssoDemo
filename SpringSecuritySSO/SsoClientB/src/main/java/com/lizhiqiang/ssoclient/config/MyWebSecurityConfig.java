package com.lizhiqiang.ssoclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//然后就是最核心的SpringSecurity的安全配置类，我们还是使用WebSecurityConfigurerAdapter来帮助我们进行配置
@Configuration
@Order(110)
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**.html").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .logout().permitAll();
//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
// .oauth2Login();

    }
}
