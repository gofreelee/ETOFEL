package com.example.user.service;

import com.example.user.bean.User;

public interface UserService {
    User getUserByUsername(String usr_username);
    void insertUser();

    void updateUser(User user);
    void updatePwd(String usr_username,String pwd);


}