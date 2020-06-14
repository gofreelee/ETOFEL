package loginmodule.mapper;

import loginmodule.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserMapper {

    //通过用户名获取用户信息
    User selectUserByUsername(String usr_username);

    //通过username和password获取用户信息，用于用户登陆
    User selectUserByUNAndPW(@Param("usr_username")String usr_username, @Param("usr_password") String usr_password);

    //用过username,password和email添加用户，用于用户注册
    int addUserByNPE(@Param("usr_username") String usr_username, @Param("usr_password")String usr_password,@Param("usr_email") String usr_email);

    //通过改变username和state显示用户列表
    List<User> selectUserByUNAndState(@Param("usr_username")String usr_username, @Param("usr_state") String usr_state);

    //通过改变state显示用户列表，username为空


    //将选中的用户解冻
    int updateStaToNormal(String usr_username);

    //将选中的用户冻结
    int updateStaToFrozen(String usr_username);

    //根据选中的用户的用户名删除用户
    int deleteUser(String usr_username);
}
