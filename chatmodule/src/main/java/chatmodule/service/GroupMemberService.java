package chatmodule.service;

import chatmodule.bean.*;
import chatmodule.mapper.GroupDao;
import chatmodule.mapper.GroupMemberDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupMemberService {
    @Autowired
    GroupMemberDao groupMemberDao;

    @Autowired
    GroupDao groupDao;

    public int addMember(GroupMember groupMember) {
        return groupMemberDao.addGroupMember(groupMember);
    }

    public int deleteMember(String gmbUsername) {
        return groupMemberDao.deleteMember(gmbUsername);
    }

    public GroupInfoQuery queryGroupInfo(long grpId) {
        GroupInfoQuery groupInfoQuery = new GroupInfoQuery();
        Group group = groupDao.selectByGrpID(grpId);
        int membersNum = groupMemberDao.calculateAllMemberNum(grpId);
        List<MemberQuery> allMembers = groupMemberDao.selectMemberInfo(grpId);
        allMembers.addAll(groupMemberDao.selectMemberTeacherInfo(grpId));
        List<MemberQuery> managers = new ArrayList<>(), members = new ArrayList<>();
        for (MemberQuery member : allMembers) {
            if (member.getUserType().equals("member"))
                members.add(member);
            else if (member.getUserType().equals("manager"))
                managers.add(member);
        }
        groupInfoQuery.setBaseInfo(group);
        groupInfoQuery.setGroupMembers(membersNum);
        groupInfoQuery.setManagers(managers);
        groupInfoQuery.setMembers(members);
        return groupInfoQuery;
    }

    public List<MemberQuery> queryGroupByType(long grpId, String gmpType) {
        return groupMemberDao.selectMemberByType(grpId, gmpType);
    }

    /*
     * 根据id列表，把管理员要的信息搞搞过去
     * */
    public List<GroupByManagerQuery> managerQueryGroupInfo(List<Long> idList) {
        List<GroupByManagerQuery> groupByManagerQueries = new ArrayList<>();
        for (Long id : idList) {
            GroupByManagerQuery groupByManagerQuery = new GroupByManagerQuery();
            GroupInfoQuery groupInfoQuery = queryGroupInfo(id);
            groupByManagerQuery.setGrpName(groupInfoQuery.getBaseInfo().getGrpName());
            groupByManagerQuery.setGrpCreateTime(groupInfoQuery.getBaseInfo().getGrpCreateTime());
            groupByManagerQuery.setGrpDescription(groupInfoQuery.getBaseInfo().getGrpDescription());
            groupByManagerQuery.setGrpAllMembers(groupInfoQuery.getGroupMembers());
            groupByManagerQuery.setGrpManagerNumber(groupInfoQuery.getManagers().size());
            groupByManagerQuery.setGrpCreator(groupMemberDao.findCreator(id));
            groupByManagerQuery.setGrpId(id);
            groupByManagerQueries.add(groupByManagerQuery);
        }
        return groupByManagerQueries;
    }


    public List<GroupByManagerQuery> managerQueryAll() {
        return managerQueryGroupInfo(groupDao.selectAllGroupId());
    }

    public void updateMemberType(String gmbUsername, long gmbGrpId, String gmbType) {
        groupMemberDao.updateMemberType(gmbUsername, gmbGrpId, gmbType);
    }

    public GroupMember getGroupMember(String gmbUsername, long gmbGrpId) {
        return groupMemberDao.getGroupMember(gmbUsername, gmbGrpId);
    }
}
