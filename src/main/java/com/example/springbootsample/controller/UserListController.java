package com.example.springbootsample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbootsample.domain_user.model.MUser;
import com.example.springbootsample.domain_user.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/user")
public class UserListController {
    
@Autowired
private UserService userService;

    @GetMapping("/list")
    public String getUserList(Model model) {
        // ユーザー一覧取得
        List<MUser> userList = userService.getUsers();

        // Modelに登録
        model.addAttribute("userList", userList);

        // ユーザー一覧画面を表示
        return "user/list";
    }
    
    
}
