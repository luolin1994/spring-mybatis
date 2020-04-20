package com.example.spring.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "登陆相关接口")
public class LoginController {

//    @GetMapping("/login")
//    public RespBean login(){
//        return RespBean.error("尚未登陆，请登陆");
//    }

    @GetMapping("/hello")
    public String hello(){
        return "hello,user";
    }

    @GetMapping("/admin")
    public String admin(){
        return "hello,admin";
    }
}
