package loginmodule.service;

import loginmodule.bean.User;
import loginmodule.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    系统管理-用户列表接口
 */
@Service
public class UserManageService {

    @Autowired
    UserMapper userMapper;

    //通过用户名和状态显示用户列表
    public List<User> selectUserByUNAndState(String usr_username, String usr_state){
        return userMapper.selectUserByUNAndState(usr_username, usr_state);
    }

    //通过用户名查询用户（用于显示修改状态后的用户）
    public User selectUserByUsername(String usr_username){
        return userMapper.selectUserByUsername(usr_username);
    }

    //解冻选中用户
    public int updateStaToNormal(String usr_username){
        return userMapper.updateStaToNormal(usr_username);
    }

    //冻结选中用户
    public int updateStaToFrozen(String usr_username){
        return userMapper.updateStaToFrozen(usr_username);
    }

    //删除选中用户
    public int deleteUser(String usr_username){
        return userMapper.deleteUser(usr_username);
    }
}
