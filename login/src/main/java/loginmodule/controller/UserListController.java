package loginmodule.controller;

import com.google.gson.Gson;
import loginmodule.bean.User;
import loginmodule.service.LoginService;
import loginmodule.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userlist")
public class UserListController {
    @Autowired
    UserManageService userManageService;

    @Autowired
    Gson gson;

    /**
     * 系统管理-用户列表
     * 根据选则的用户和状态显示用户列表
     *
     * @param username 用户名
     * @param state    用户的状态：normal（正常）/frozen（冻结）
     * @return 用户列表json
     */
    @GetMapping("/userlist")
    public String userList(String username, @RequestParam("state") String state) {
        List<User> users = userManageService.selectUserByUNAndState(username, state);
        return gson.toJson(users);
    }

    /**
     * 系统管理-用户列表
     * 冻结选中的用户
     *
     * @param usernames 用户名
     */
    @PostMapping("/updateUserToFrozen")
    public void updateUserToFrozen(@RequestBody Map<String, List<String>> usernames) {
        List<String> list = usernames.get("usernames");
        for (String username : list) {
            System.out.println(username);
            userManageService.updateStaToFrozen(username);
        }
    }

    /**
     * 系统管理-用户列表
     * 解冻选中的用户
     *
     * @param usernames 用户名
     */
    @PostMapping("/updateUserToNormal")
    public void updateUserToNormal(@RequestBody Map<String, List<String>> usernames) {
        List<String> list = usernames.get("usernames");
        for (String username : list) {
            userManageService.updateStaToNormal(username);
        }
    }

    /**
     * 系统管理-用户列表
     * 删除被选中的用户
     *
     * @param usernames 用户名
     */
    @PostMapping("/deleteUser")
    public void deleteUser(@RequestBody Map<String, List<String>> usernames) {
        List<String> list = usernames.get("usernames");
        for (String username : list) {
            userManageService.deleteUser(username);
        }
    }
}

