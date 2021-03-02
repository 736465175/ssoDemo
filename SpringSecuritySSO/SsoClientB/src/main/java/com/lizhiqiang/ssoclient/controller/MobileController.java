package com.lizhiqiang.ssoclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mobile")
public class MobileController {
    @RequestMapping("/query")
    public String queryMobile(){
        return "mobile";
    }
}
