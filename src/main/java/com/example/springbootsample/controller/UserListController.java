package com.example.springbootsample.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbootsample.domain_user.model.MUser;
import com.example.springbootsample.domain_user.service.UserService;
import com.example.springbootsample.form.UserListForm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/user")
public class UserListController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping("/list")
    public String getUserList(UserListForm form,Model model) {

        // formをMUserクラスに変換
        MUser user = modelMapper.map(form, MUser.class);

        // ユーザー一覧取得
        List<MUser> userList = userService.getUsers(user);

        // Modelに登録
        model.addAttribute("userList", userList);

        // ユーザー一覧画面を表示
        return "user/list";
    }
    
    @PostMapping("/list")
    public String postUserList(UserListForm form, Model model) {
        // formをMUserクラスに変換
        MUser user = modelMapper.map(form, MUser.class);

        //　ユーザー検索
        List<MUser> users = userService.getUsers(user);

        //　モデルに登録
        model.addAttribute("userList", users);

        // ユーザー一覧画面を表示
        return "user/list";
    }
    
    
}
