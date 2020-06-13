package loginmodule.service;



import loginmodule.bean.*;
import loginmodule.mapper.AdministerMapper;
import loginmodule.mapper.TeacherMapper;
import loginmodule.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;
    TeacherMapper teacherMapper;
    AdministerMapper administerMapper;

    private static final long serialVersionUID = -3185301474503659058L;
    private static final String captchaId = "YOUR_CAPTCHA_ID"; // 验证码id
    private static final String secretId = "YOUR_SECRET_ID"; // 密钥对id
    private static final String secretKey = "YOUR_SECRET_KEY"; // 密钥对key
    private final NECaptchaVerifier verifier = new NECaptchaVerifier(captchaId, new NESecretPair(secretId, secretKey));

    //登陆，通过username、password获得一个user的信息
    public User selectUserByUNAndPW(String usr_username, String usr_password){
        return userMapper.selectByUNAndPW(usr_username,usr_password);
    }

    //登陆，通过username、password获得一个teacher的信息
    public Teacher selectTeacherByUNAndPW(String  tch_username,String tch_password){
        return  teacherMapper.selectByUNAndPW(tch_username, tch_password);
    }

    //登陆，通过username、password获得一个administer的信息
    public Administer selectAdministerByUNAndPW(String ad_username,String ad_password){
        return administerMapper.selectAdministerByUNAndPW(ad_username, ad_password);
    }

    //注册，通过username、password、email添加一个user
    public int addUserByNPE(String usr_username,String usr_password,String usr_email){
       return userMapper.addUserByNPE(usr_username, usr_password, usr_email);
    }

    //注册验证，判断注册用户是否已存在于user表中
    public boolean NoExistInUser(String username){
        if(userMapper.selectUsername(username)== username){
            return false;
        }
        else return true;
    }

    //注册验证，判断用户是否已存在于teacher表中
    public boolean NoExistInTeacher(String username){
        if(teacherMapper.selectUsername(username)== username){
            return false;
        }
        else return true;
    }

    //验证码检验,有必要可以重写
    public void Verification(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String validate = request.getParameter(NECaptchaVerifier.REQ_VALIDATE); // 从请求体里获得验证码validate数据
        String user = "{'id':'123456'}";

        VerifyResult result = verifier.verify(validate, user); // 发起二次校验

        System.out.println(String.format("validate = %s,  isValid = %s , msg = %s ", validate, result.isResult(),
                result.getMsg()));
        if (result.isResult()) {
            response.sendRedirect("/success.jsp");
        } else {
            response.sendRedirect("/fail.jsp");
        }
    }
}
