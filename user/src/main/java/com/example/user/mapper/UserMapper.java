package com.example.user.mapper;

import com.example.user.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    // 获取用户信息
    User getUserByUsername(String usr_username);
    //修改用户信息
    void updateUser(User user);
    //修改用户密码
    void updatePwd(@Param("usr_username") String usr_username, @Param("pwd") String pwd);
    //上传用户头像
    void updatePhoto(@Param("usr_username") String usr_username,@Param("usr_portrait") String usr_portrait);
}