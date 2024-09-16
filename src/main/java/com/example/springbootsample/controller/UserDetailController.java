package com.example.springbootsample.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbootsample.domain_user.model.MUser;
import com.example.springbootsample.domain_user.service.UserService;
import com.example.springbootsample.form.UserDetailForm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/user")
public class UserDetailController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    /** ユーザー詳細画面を表示 */
    @GetMapping("detail/{userId:.+}")
    public String getUser(UserDetailForm form, Model model, @PathVariable("userId") String userId) {
        //ユーザーを1件取得
        MUser user = userService.getUserOne(userId);
        user.setPassword(null);
        
        // MUserをformに変換
        form = modelMapper.map(user, UserDetailForm.class);

        // Modelに登録
        model.addAttribute("userDetailForm", form);

        return "/user/detail";
    }
    
}
