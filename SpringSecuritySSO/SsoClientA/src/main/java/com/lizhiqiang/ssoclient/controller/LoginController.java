package com.lizhiqiang.ssoclient.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//我们提供一个LoginController来获取用户的登录状态
@RestController
@RequestMapping("/common")
public class LoginController {

    @RequestMapping("/getLoginUser")
    public Authentication getLoginUser(Authentication user){
        return user;
    }

}
