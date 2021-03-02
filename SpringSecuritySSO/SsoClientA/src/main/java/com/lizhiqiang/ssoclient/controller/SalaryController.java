package com.lizhiqiang.ssoclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("salary")
@RestController
public class SalaryController {
    @RequestMapping("/salary")
    public String salaryQuery(){
        return "salary";
    }
}
