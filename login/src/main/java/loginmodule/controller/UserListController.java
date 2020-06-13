package loginmodule.controller;

import com.google.gson.Gson;
import loginmodule.bean.User;
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
    public String userList(@RequestParam("username") String username, @RequestParam("state") String state){

        List<User> users = userManageService.selectUserByUNAndState(username,state);
        return gson.toJson(users);
    }
}

