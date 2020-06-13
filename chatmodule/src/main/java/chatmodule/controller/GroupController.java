package chatmodule.controller;

import chatmodule.bean.GroupInfoQuery;
import chatmodule.bean.GroupMessage;
import chatmodule.bean.MemberQuery;
import chatmodule.service.GroupMemberService;
import chatmodule.service.GroupMessageService;
import chatmodule.service.GroupService;
import chatmodule.bean.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/searchGroupByName")
    public List<Group> searchGroupByName(HttpServletRequest request){
        String groupName = request.getParameter("groupName");
        List<Group> queryResults = groupService.searchByGroupNameLike(groupName);
        return queryResults;
    }

    @RequestMapping("/searchGroupByType")
    public List<Group> searchGroupByType(HttpServletRequest request){
        String groupName = request.getParameter("groupType");
        System.out.println(groupName);
        List<Group> queryResults = groupService.searchByGroupType(groupName);
        return queryResults;
    }

    @RequestMapping("/searchGroupInfo")
    public GroupInfoQuery searchGroupInfo(HttpServletRequest request){
        int grpId = Integer.parseInt(request.getParameter("grpId"));
        GroupInfoQuery groupInfoQuery = groupMemberService.queryGroupInfo(grpId);
        return groupInfoQuery;
    }


    @RequestMapping("/searchMember")
    public List<MemberQuery> searchMember(HttpServletRequest request){
        int grpId = Integer.parseInt(request.getParameter("grpId"));
        String gmpType = request.getParameter("gmpType");
        List<MemberQuery> memberQueryList = groupMemberService.queryGroupByType(grpId, gmpType);
        return memberQueryList;
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public int sendMessage(@RequestBody GroupMessage message){
        message.setGmsCreateTime(new Timestamp(new Date().getTime()));
        return groupMessageService.addOneMessage(message);
    }

    @RequestMapping(value = "/getMessageNum")
    public int getMessageNum(HttpServletRequest request){
        int grpId = Integer.parseInt(request.getParameter("grpId"));
        return groupMessageService.calculateMessageNum(grpId);
    }

    @RequestMapping(value = "getMessage")
    public List<GroupMessage> getMessage(HttpServletRequest request){
        int grpId = Integer.parseInt(request.getParameter("grpId"));
        int index = Integer.parseInt(request.getParameter("index"));
        return groupMessageService.selectMessageLimitBy(grpId,index,index + 10);
    }


}
