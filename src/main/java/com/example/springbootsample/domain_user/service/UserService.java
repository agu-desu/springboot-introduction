package com.example.springbootsample.domain_user.service;

import com.example.springbootsample.domain_user.model.MUser;

public interface UserService {
    /** ユーザー登録 */
    public void signup(MUser user);
}
