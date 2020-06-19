package loginmodule.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import loginmodule.bean.User;
import loginmodule.service.LoginService;
import loginmodule.service.NECaptchaVerifier;
import loginmodule.utils.TokenProcessor;
import loginmodule.utils.VerifyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 用户登陆
     *
     * @param username 用户名
     * @param password 密码
     * @return 登陆的用户json
     */
    @GetMapping("/ulogin")
    public String user(@RequestParam("username") String username, @RequestParam("password") String password) {
        logger.info(gson.toJson(username) + "请求登录");

        JSONObject loginJson = new JSONObject();
        User user = loginService.selectUserByUNAndPW(username, password);
        loginJson.put("type", "user");
        loginJson.put("information", user);

        return loginJson.toJSONString();
    }

    /**
     * 用户注册
     *
     * @param username 用户名
     * @param password 密码
     * @param email    邮箱
     * @return 注册的新用户json
     */
    @PostMapping("/register")
    public String newUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("email") String email) {
        if (loginService.NoExistInUser(username) && loginService.NoExistInTeacher(username)) {
            loginService.addUserByNPE(username, password, email);
            return gson.toJson(loginService.selectUserByUNAndPW(username, password));
        } else {
            logger.error(username + "用户名已存在");
            return null;
        }
    }

    /**
     * 请求随机验证码
     *
     * @param width  图片宽度
     * @param height 图片长度
     * @return 验证码base64
     */
    @GetMapping("/verify-code")
    public String verifyCode(@RequestParam("width") int width, @RequestParam("height") int height) {
        JSONObject response = new JSONObject();
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.setWidth(width);
        verifyCode.setHeight(height);
        response.put("img", verifyCode.getBase64());
        response.put("text", verifyCode.getText());
        return response.toJSONString();
    }

}
