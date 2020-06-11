package chatmodule.controller;

import chatmodule.service.GroupService;
import chatmodule.bean.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/test")
public class GroupController {
    @Autowired
    GroupService groupService;
    @RequestMapping("/group")
    public int test()
    {
       return 1;
    }
}
