package loginmodule.controller;

import loginmodule.bean.User;
import loginmodule.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/userlist")
public class UserListController {
    @Autowired
    UserManageService userManageService;

    @RequestMapping("userlist")
    public List<User> selectUserList(HttpServletRequest  request){
        String usr_username = request.getParameter("username");
        String usr_state = request.getParameter("state");
        List<User> users = userManageService.selectUserByUNAndState(usr_username,usr_state);
        return users;
    }
}

