package loginmodule.mapper;

import loginmodule.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //显示用户姓名，用于注册时判断用户是否已存在于user
    String selectUsername(String usr_username);

    //通过username和password获取用户信息，用于用户登陆
    User selectByUNAndPW(String usr_username, String usr_password);

    //用过username,password和email添加用户，用于用户注册
    int addUserByNPE(String usr_username,String usr_password,String usr_email);

    //通过改变username和state显示用户列表
    List<User> selectUserByUNAndState(String usr_username, String usr_state);

    //将选中的用户解冻
    int updateStaToNormal(String usr_username);

    //将选中的用户冻结
    int updateStaToFrozen(String usr_username);

    //根据选中的用户的用户名删除用户
    int deleteUser(String usr_username);
}
