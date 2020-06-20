package chatmodule.controller;

import chatmodule.service.GroupMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GroupMemberController
 * @Author 11214
 * @Date 2020/6/20
 * @Description 管理群组员
 */
@RestController
@RequestMapping("/group-member")
public class GroupMemberController {
    private GroupMemberService groupMemberService;

    @Autowired
    public void setGroupMemberService(GroupMemberService groupMemberService) {
        this.groupMemberService = groupMemberService;
    }

    @PostMapping("/updateMemberType")
    public void updateMemberType(@RequestParam("gmbUsername") String gmbUsername,
                                 @RequestParam("gmbGrpId") long gmbGrpId,
                                 @RequestParam("gmbType") String gmbType) {
        groupMemberService.updateMemberType(gmbUsername, gmbGrpId, gmbType);
    }
}
