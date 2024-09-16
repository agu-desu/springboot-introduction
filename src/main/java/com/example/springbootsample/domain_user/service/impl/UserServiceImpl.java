package com.example.springbootsample.domain_user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootsample.domain_user.model.MUser;
import com.example.springbootsample.domain_user.service.UserService;
import com.example.springbootsample.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService{
    
@Autowired
private UserMapper mapper;

/** ユーザー登録　*/
@Override
public void signup(MUser user) {
    user.setDepartmentId(1);
    user.setRole("ROLE_GENERAL");
    mapper.insertOne(user);
}

/** ユーザー取得 */
@Override
public List<MUser> getUsers() {
    return mapper.findMany();
}
}
