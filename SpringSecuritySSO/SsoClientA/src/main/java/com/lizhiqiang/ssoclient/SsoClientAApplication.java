package com.lizhiqiang.ssoclient;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
//然后是他的启动类，要注意这里的关键就是使用@EnableOAuth2sso来声明为一个Sso服务端。
@EnableOAuth2Sso
public class SsoClientAApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoClientAApplication.class, args);
    }
}
