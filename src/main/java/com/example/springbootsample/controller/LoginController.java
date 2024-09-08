package com.example.springbootsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    
    /**
     * ログイン画面を表示
     */
    @GetMapping("/login")
    public String getLogin() {
        return "login/login";
    }
    
}
