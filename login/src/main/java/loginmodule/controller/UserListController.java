package loginmodule.controller;

import com.google.gson.Gson;
import loginmodule.bean.User;
import loginmodule.service.LoginService;
import loginmodule.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userlist")
public class UserListController {
    @Autowired
    UserManageService userManageService;

    @Autowired
    Gson gson;

    /**
     * 系统管理-用户列表
     *  根据选则的用户和状态显示用户列表
     * @param username 用户名
     * @param state 用户的状态：normal（正常）/frozen（冻结）
     * @return 用户列表json
     */
    @GetMapping("/userlist")
    public String userList(String username, @RequestParam("state") String state){

        List<User> users = userManageService.selectUserByUNAndState(username,state);
        return gson.toJson(users);
    }

    /**
     * 系统管理-用户列表
     *  冻结选中的用户
     * @param username 用户名
     * @return 被冻结的用户json
     */
    @GetMapping("/updateUserToFrozen")
    public String updateUserToFrozen(@RequestParam("username") String username){
        int result = userManageService.updateStaToFrozen(username);
        User user;
        if(result == 1) {
            user = userManageService.selectUserByUsername(username);
            return gson.toJson(user);
        }
        else return null;
    }

    /**
     * 系统管理-用户列表
     *  解冻选中的用户
     * @param username 用户名
     * @return 被解冻的用户json
     */
    @GetMapping("/updateUserToNormal")
    public String updateUserToNormal(@RequestParam("username") String username){
        int result = userManageService.updateStaToNormal(username);
        User user;
        if(result == 1) {
            user = userManageService.selectUserByUsername(username);
            return gson.toJson(user);
        }
        else return null;
    }

    /**
     * 系统管理-用户列表
     *  删除被选中的用户
     * @param username 用户名
     * @return 被删除的用户json
     */
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("username") String username){

        User user = userManageService.selectUserByUsername(username);
        int result = userManageService.deleteUser(username);
        if(result == 1) {
            return gson.toJson(user);
        }
        else return null;
    }
}

