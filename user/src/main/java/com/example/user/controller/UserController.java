package com.example.user.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.user.bean.User;
import com.example.user.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    private Gson gson;

    @Autowired
    public void setGson() {
        this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    }

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/info")
    @ResponseBody
    public String userInfo(@RequestParam("usr_username") String usr_username) {
        User user = userService.getUserByUsername(usr_username);
        if (user != null) logger.info(user.toString());
        return gson.toJson(user);
    }


    @PostMapping("/update")
    public String update(@RequestParam("usr_username") String usr_username,
                         @RequestParam("usr_nickname") String usr_nickname,
                         @RequestParam("usr_email") String usr_email,
                         @RequestParam(value = "usr_birthday", required = false) String usr_birthday,
                         @RequestParam(value = "usr_sign", required = false) String usr_sign,
                         @RequestParam(value = "usr_phone", required = false) String usr_phone,
                         @RequestParam("usr_gender") String usr_gender) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        User newUser = userService.getUserByUsername(usr_username);
        newUser.setUsr_email(usr_email);
        newUser.setUsr_nickname(usr_nickname);
        Date birthday = newUser.getUsr_birthday();
        try {
            newUser.setUsr_birthday(format.parse(usr_birthday));
        } catch (ParseException e) {
            newUser.setUsr_birthday(birthday);
            logger.error("用户生日日期解析错误" + usr_birthday);
        }
        newUser.setUsr_sign(usr_sign);
        newUser.setUsr_phone(usr_phone);
        newUser.setUsr_gender(usr_gender);
        System.out.println(newUser);
        userService.updateUser(newUser);
        return gson.toJson(newUser);
    }

    @PostMapping("/updatePwd")
    public String updatePwd(@RequestParam("usr_username") String usr_username,
                            @RequestParam("newpassword1") String newpassword1) {
        userService.updatePwd(usr_username, newpassword1);
        User user = userService.getUserByUsername(usr_username);
        return user.getUsr_password();
    }

    @PostMapping("/updatePhoto")
    public String updatePhoto(@RequestParam("imgFile") String imgBase64,
                              @RequestParam("usr_username") String usr_username) {

        userService.updatePhoto(usr_username, imgBase64);
        User user = userService.getUserByUsername(usr_username);
        return user.getUsr_portrait();
    }
}
