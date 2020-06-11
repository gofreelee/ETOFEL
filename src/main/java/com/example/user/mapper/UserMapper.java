package com.example.user.mapper;

import com.example.user.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    // 获取用户信息
    User getUserByUsername(String usr_username);
    //插入用户
    void insertUser();
    //修改用户信息
    void updateUser(User user);
    //修改用户密码
    void updatePwd(@Param("usr_username") String usr_username, @Param("pwd") String pwd);
    //获取用户头像
    String getPhoto(String usr_username);
}