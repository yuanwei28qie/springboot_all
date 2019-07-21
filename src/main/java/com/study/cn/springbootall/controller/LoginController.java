package com.study.cn.springbootall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() { return "login"; }

    @RequestMapping("/login-error")
    public String error() {return "error"; }

    @RequestMapping("/index")
    public String index() {
        int a = 1;
        if(a==2){
            System.out.println("11111111");
        }
        System.out.println(a);
        return "index22";}

    @RequestMapping("/admin")
    public String admin() {return "admin"; }

    @RequestMapping("/user")
    public String user() {
        return "user";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "index2";
    }


}
