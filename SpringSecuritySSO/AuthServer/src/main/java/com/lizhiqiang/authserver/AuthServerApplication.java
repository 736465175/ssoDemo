package com.lizhiqiang.authserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 然后他的SpringBoot启动类如下: 这里注意需要使用@EnableAuthorizationServer注解声明他为一个授
 * 权服务器
 * @author Lizhiqiang
 * @date 2021/2/26 16:05
 */
@SpringBootApplication
@EnableAuthorizationServer
public class AuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
