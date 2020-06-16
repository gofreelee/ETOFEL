package com.example.user.service.impl;

import com.example.user.bean.User;
import com.example.user.mapper.UserMapper;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String usr_username) {
        return userMapper.getUserByUsername(usr_username);
    }


    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void updatePwd(String usr_username, String pwd) {
        userMapper.updatePwd(usr_username, pwd);
    }

    @Override
    public void updatePhoto(String usr_username, String usr_portrait) {
        userMapper.updatePhoto(usr_username, usr_portrait);
    }
}
