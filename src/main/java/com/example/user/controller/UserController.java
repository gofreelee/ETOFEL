package com.example.user.controller;


import com.example.user.bean.User;
import com.example.user.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    Gson gson;

    @GetMapping("/info")
    @ResponseBody
    public String userInfo(@RequestParam("usr_username")String usr_username){
        User user = userService.getUserByUsername(usr_username);
        System.out.println(user);
        return gson.toJson(user);
    }

    @GetMapping("/update")
    public String update(@RequestParam("usr_username")String usr_username,
                         @RequestParam("usr_email")String usr_email,
                         @RequestParam(value = "usr_birthday",required = false)Date usr_birthday,
                         @RequestParam(value = "usr_sign",required = false)String usr_sign,
                         @RequestParam(value = "usr_phone",required = false)String usr_phone,
                         @RequestParam("usr_gender")String usr_gender) {
        User newUser = userService.getUserByUsername(usr_username);
        newUser.setUsr_email(usr_email);
        newUser.setUsr_birthday(usr_birthday);
        newUser.setUsr_sign(usr_sign);
        newUser.setUsr_phone(usr_phone);
        newUser.setUsr_gender(usr_gender);
        System.out.println(newUser);
        userService.updateUser(newUser);
        return null;
    }

    @GetMapping("/updatePwd")
    public String updatePwd(@RequestParam("usr_username")String usr_username,
                             @RequestParam("newpassword1")String newpassword1
                             ){
        userService.updatePwd(usr_username,newpassword1);
        return null;
    }

    @GetMapping("/updatePhoto")
    public String updatePhoto(){
        return null;
    }

}
