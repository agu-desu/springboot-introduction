package com.example.springbootsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/user")
public class UserListController {
    

    @GetMapping("/list")
    public String getUserList() {
        // ユーザー一覧ん画面を表示
        return "user/list";
    }
    
    
}
