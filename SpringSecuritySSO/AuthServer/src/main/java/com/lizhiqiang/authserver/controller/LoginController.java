package com.lizhiqiang.authserver.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 在实现时，我们首先要提供一个接口，用来获取当前用户的信息，注意我们的登录逻辑就由
 * SpringSecurity完成，不需要自己提供接口。所以，我们需要先实现一个LoginController
 * @author Lizhiqiang
 * @date 2021/2/26 16:06
 */

@RestController
@RequestMapping("/common")
public class LoginController {

    @GetMapping("/getLoginUser")
    public Principal getLoginUser(Principal principal){
        return principal;
    }

}
