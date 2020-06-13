package loginmodule.controller;

import loginmodule.bean.User;
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
@ComponentScan(basePackages = "loginmodule.service.LoginService")
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    LoginService loginService;

    /*
        user登陆
     */
   @RequestMapping("/uLogin")
    public User ulogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
       String usr_username = request.getParameter("username");
       String usr_password = request.getParameter("password");
       User user = loginService.selectUserByUNAndPW(usr_username,usr_password);
       loginService.Verification(request, response);
       return user;
   }

   /*
        注册
    */
    @RequestMapping("/register")
    public int register(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String usr_username = request.getParameter("username");
        String usr_password = request.getParameter("password");
        String usr_email = request.getParameter("email");
        loginService.Verification(request, response);
        return loginService.addUserByNPE(usr_username,usr_password,usr_email);

    }
}
