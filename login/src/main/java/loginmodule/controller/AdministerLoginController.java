package loginmodule.controller;

import loginmodule.bean.Administer;
import loginmodule.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
//@ComponentScan(basePackages = "loginmodule.service.LoginService")
@RequestMapping("/administer")
public class AdministerLoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/alogin")
    public Administer alogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String ad_username = request.getParameter("username");
        String ad_password = request.getParameter("password");
        Administer administer = loginService.selectAdministerByUNAndPW(ad_username,ad_password);
        loginService.Verification(request, response);
        return administer;
    }
}
