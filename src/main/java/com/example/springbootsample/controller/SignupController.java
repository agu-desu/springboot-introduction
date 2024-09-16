package com.example.springbootsample.controller;

import java.util.Map;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.springbootsample.applicationService.UserApplicationService;
import com.example.springbootsample.domain_user.model.MUser;
import com.example.springbootsample.domain_user.service.UserService;
import com.example.springbootsample.form.GroupOrder;
import com.example.springbootsample.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/user")
@Slf4j // 簡単にログが出力できる。
public class SignupController {
    
    @Autowired
    private UserApplicationService userApplicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    /**
     * ユーザー登録画面を表示
     * 
     */
    @GetMapping("/signup")
    public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
        // 性別を取得
        Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("genderMap", genderMap);
        // ユーザー登録画面に遷移
        return "user/signup";
    }

    /**
     * ユーザー登録処理
     */
    @PostMapping("/signup")
    public String postSignup(Model model, Locale locale, @ModelAttribute @Validated(GroupOrder.class)SignupForm form,
    BindingResult bindingResult) {
        // 入力チェック
        if(bindingResult.hasErrors()) {
            // NG: ユーザー登録画面に戻ります
            return getSignup(model, locale, form);
        }
        // ログイン画面にリダイレクト
        log.info(form.toString());

        // formをMUserクラスに変換
        MUser user = modelMapper.map(form, MUser.class);

        userService.signup(user);

        return "redirect:/login";
    }
}
