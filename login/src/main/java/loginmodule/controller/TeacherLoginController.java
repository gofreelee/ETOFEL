package loginmodule.controller;

import com.google.gson.Gson;
import loginmodule.bean.Teacher;
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
@RequestMapping("/teacher")
public class TeacherLoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    Gson gson;

    /**
     * 老师登陆
     * @param username 用户名
     * @param password 密码
     * @return 登陆的老师json
     */
    @GetMapping("/tlogin")
   public String teacher(@RequestParam("username") String username, @RequestParam("password") String password){
        Teacher teacher = loginService.selectTeacherByUNAndPW(username, password);
        return gson.toJson(teacher);
    }
}
