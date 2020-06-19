package loginmodule.service;



import loginmodule.bean.*;
import loginmodule.mapper.AdministerMapper;
import loginmodule.mapper.TeacherMapper;
import loginmodule.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    AdministerMapper administerMapper;

    private static final long serialVersionUID = -3185301474503659058L;
    private static final String captchaId = "591565d17493431aa0b31cea856c4c92"; // 验证码id
    private static final String secretId = "2be5af62b150c5ab4980e2e00a20c735"; // 密钥对id
    private static final String secretKey = "d1b4099e76efae120f496fe0a6fa8cd2"; // 密钥对key
    private final NECaptchaVerifier verifier = new NECaptchaVerifier(captchaId, new NESecretPair(secretId, secretKey));

    //登陆，通过username、password获得一个user的信息
    public User selectUserByUNAndPW(String usr_username, String usr_password) {
        return userMapper.selectUserByUNAndPW(usr_username, usr_password);
    }

    //登陆，通过username、password获得一个teacher的信息
    public Teacher selectTeacherByUNAndPW(String tch_username, String tch_password) {
        return teacherMapper.selectByUNAndPW(tch_username, tch_password);
    }

    //登陆，通过username、password获得一个administer的信息
    public Administer selectAdministerByUNAndPW(String ad_username, String ad_password) {
        return administerMapper.selectAdministerByUNAndPW(ad_username, ad_password);
    }

    //注册，通过username、password、email添加一个user
    public int addUserByNPE(String usr_username, String usr_password, String usr_email) {
        return userMapper.addUserByNPE(usr_username, usr_password, usr_email);
    }

    //注册验证，判断注册用户是否已存在于user表中
    public boolean NoExistInUser(String username) {
        User user = userMapper.selectUserByUsername(username);
        return user == null;
    }

    //注册验证，判断用户是否已存在于teacher表中
    public boolean NoExistInTeacher(String username) {
        Teacher teacher = teacherMapper.selectTeacherUsername(username);
        return teacher == null;
    }


    //验证码检验,返回二次校验的结果
    public boolean Verification(String veri) {
        String user = "{'id':'123456'}";

        VerifyResult result = verifier.verify(veri, user); // 发起二次校验

        return result.isResult();
    }
}
