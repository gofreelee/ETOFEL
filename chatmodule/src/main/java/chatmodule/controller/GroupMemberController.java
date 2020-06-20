package chatmodule.controller;

import chatmodule.bean.GroupMember;
import chatmodule.service.GroupMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(GroupController.class);

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

    @PostMapping("/addGroupMember")
    public void addGroupMember(@RequestParam("gmbUsername") String gmbUsername,
                               @RequestParam("gmbGrpId") long gmbGrpId) {
        GroupMember groupMember = groupMemberService.getGroupMember(gmbUsername, gmbGrpId);
        if (groupMember != null) {
            logger.info("用户重新申请入群：" + gmbUsername + "  " + gmbGrpId);
            groupMemberService.updateMemberType(gmbUsername, gmbGrpId, "tobeMember");
        } else {
            logger.info("用户申请入群：" + gmbUsername + "  " + gmbGrpId);
            groupMember = new GroupMember(gmbUsername, gmbGrpId, "tobeMember");
            groupMemberService.addMember(groupMember);
        }
    }
}
