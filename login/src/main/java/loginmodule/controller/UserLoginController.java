package loginmodule.controller;

import com.google.gson.Gson;
import loginmodule.bean.User;
import loginmodule.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    Gson gson;

    /**
     * 用户登陆
     * @param username 用户名
     * @param password  密码
     * @return  登陆的用户json
     */
   @GetMapping("/ulogin")
    public String user(@RequestParam("username") String username, @RequestParam("password") String password){
       User user = loginService.selectUserByUNAndPW(username, password);
       return  gson.toJson(user);
   }

    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @param email 邮箱
     * @return 注册的新用户json
     */
   @GetMapping("/register")
    public String newuser(@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("email") String email){

       if(loginService.NoExistInUser(username)&&loginService.NoExistInTeacher(username)){
           loginService.addUserByNPE(username, password, email);
           User user = loginService.selectUserByUNAndPW(username,password);
           return gson.toJson(user);
       }
       else return null;
   }

}
