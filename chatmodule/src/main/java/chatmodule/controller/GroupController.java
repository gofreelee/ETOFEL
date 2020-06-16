package chatmodule.controller;

import chatmodule.bean.GroupInfoQuery;
import chatmodule.bean.GroupMessage;
import chatmodule.bean.MemberQuery;
import chatmodule.service.GroupMemberService;
import chatmodule.service.GroupMessageService;
import chatmodule.service.GroupService;
import chatmodule.bean.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupService groupService;
    @Autowired
    GroupMemberService groupMemberService;
    @Autowired
    GroupMessageService groupMessageService;

    private Logger logger = LoggerFactory.getLogger(GroupController.class);

    /**
     * 根据名称搜索群
     *
     * @param request 群名
     * @return json
     */
    @RequestMapping("/searchGroupByName")
    public List<Group> searchGroupByName(HttpServletRequest request) {
        String groupName = request.getParameter("groupName");
        return groupService.searchByGroupNameLike(groupName);
    }

    /**
     * 根据群的类别查询
     *
     * @param request 全部、同城群、名师课堂群、结伴备考群
     * @return json
     */
    @RequestMapping("/searchGroupByType")
    public List<Group> searchGroupByType(HttpServletRequest request) {
        String groupType = request.getParameter("groupType");
        if (groupType.equals("全部")) groupType = null;
        System.out.println(groupType);
        return groupService.searchByGroupType(groupType);
    }

    /**
     * 根据id查询群人数
     *
     * @param grpId 群id
     * @return 群人数
     */
    @GetMapping("/countMembers")
    public int countGroupMembers(int grpId) {
        logger.info("群id" + grpId + "查询群人数");
        return groupService.countGroupMembers(grpId);
    }

    @RequestMapping("/searchGroupInfo")
    public GroupInfoQuery searchGroupInfo(HttpServletRequest request) {
        int grpId = Integer.parseInt(request.getParameter("grpId"));
        return groupMemberService.queryGroupInfo(grpId);
    }


    @RequestMapping("/searchMember")
    public List<MemberQuery> searchMember(HttpServletRequest request) {
        int grpId = Integer.parseInt(request.getParameter("grpId"));
        String gmpType = request.getParameter("gmpType");
        return groupMemberService.queryGroupByType(grpId, gmpType);
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public int sendMessage(@RequestBody GroupMessage message) {
        message.setGmsCreateTime(new Timestamp(new Date().getTime()));
        return groupMessageService.addOneMessage(message);
    }

    @RequestMapping(value = "/getMessageNum")
    public int getMessageNum(HttpServletRequest request) {
        int grpId = Integer.parseInt(request.getParameter("grpId"));
        return groupMessageService.calculateMessageNum(grpId);
    }

    @RequestMapping(value = "getMessage")
    public List<GroupMessage> getMessage(HttpServletRequest request) {
        int grpId = Integer.parseInt(request.getParameter("grpId"));
        int index = Integer.parseInt(request.getParameter("index"));
        return groupMessageService.selectMessageLimitBy(grpId, index, index + 10);
    }


}
