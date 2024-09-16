package com.example.springbootsample.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.springbootsample.domain_user.model.MUser;

@Mapper
public interface UserMapper {
    /** ユーザー登録*/
    public int insertOne(MUser user);
}
