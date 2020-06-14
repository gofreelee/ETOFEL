package loginmodule.controller;

import com.google.gson.Gson;
import loginmodule.bean.User;
import loginmodule.service.LoginService;
import loginmodule.service.NECaptchaVerifier;
import loginmodule.utils.VerifyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    Gson gson;

    private final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    private static ConcurrentHashMap<String, String> verifyCodeMap = new ConcurrentHashMap<>();

    //private ConcurrentHashMap

    /**
     * 用户登陆
     *
     * @param username 用户名
     * @param password 密码
     *                 NECaptchaVerifier.REQ_VALIDATE = 'NECaptchaValidate'
     * @return 登陆的用户json
     */
    @GetMapping("/ulogin")
    public String user(@RequestParam("username") String username, @RequestParam("password") String password,
                       @RequestParam("verifyCode") String verifyCode, @RequestParam("token") String token) {
        User user = null;
        logger.info(token + "请求登录");
        if (!verifyCode.equals(verifyCodeMap.get(token))) return gson.toJson(user);
        user = loginService.selectUserByUNAndPW(username, password);
        System.out.println(gson.toJson(user));
        return gson.toJson(user);
    }

    /**
     * 用户注册
     *
     * @param username 用户名
     * @param password 密码
     * @param email    邮箱
     *                 NECaptchaVerifier.REQ_VALIDATE = 'NECaptchaValidate'
     * @return 注册的新用户json
     */
    @GetMapping("/register")
    public String newuser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) {
        User user;
        if (loginService.NoExistInUser(username) && loginService.NoExistInTeacher(username)) {
            loginService.addUserByNPE(username, password, email);
            user = loginService.selectUserByUNAndPW(username, password);
            return gson.toJson(user);
        } else return null;
    }

    @GetMapping("/verify-code")
    public String verifyCode(@RequestParam("width") int width, @RequestParam("height") int height, @RequestParam("token") String token) {
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.setWidth(width);
        verifyCode.setHeight(height);
        String base64 = verifyCode.getBase64();
        logger.info("token:" + token + " 获取验证码");
        verifyCodeMap.put(token, verifyCode.getText());
        return base64;
    }

}
