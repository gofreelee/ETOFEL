package loginmodule.controller;

import loginmodule.bean.Teacher;
import loginmodule.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
//@ComponentScan(basePackages = "loginmodule.service.LoginService")
@RequestMapping("/teacher")
public class TeacherLoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/tlogin")
    public Teacher tLogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String tch_username = request.getParameter("username");
        String tch_password = request.getParameter("password");
        Teacher teacher = loginService.selectTeacherByUNAndPW(tch_username,tch_password);
        loginService.Verification(request, response);
        return teacher;
    }
}
