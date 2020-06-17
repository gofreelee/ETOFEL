package chatmodule.service;

import chatmodule.bean.Group;
import chatmodule.bean.GroupInfoQuery;
import chatmodule.bean.GroupMember;
import chatmodule.bean.MemberQuery;
import chatmodule.mapper.GroupDao;
import chatmodule.mapper.GroupMemberDao;
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

    public int addMember(GroupMember groupMember){
       return  groupMemberDao.addGroupMember(groupMember);
    }

    public int deleteMember(String gmbUsername){
        return groupMemberDao.deleteMember(gmbUsername);
    }

    public GroupInfoQuery queryGroupInfo(long grpId){
        GroupInfoQuery groupInfoQuery = new GroupInfoQuery();
        Group group = groupDao.selectByGrpID(grpId);
        int membersNum = groupMemberDao.calculateAllMemberNum(grpId);
        List<MemberQuery>  allMembers = groupMemberDao.selectMemberInfo(grpId);
        List<MemberQuery>  managers = new ArrayList<>(), members = new ArrayList<>();
        for(MemberQuery member: allMembers){
            if(member.getUserType().equals("manager"))
                managers.add(member);
            else
                members.add(member);
        }
        groupInfoQuery.setBaseInfo(group);
        groupInfoQuery.setGroupMembers(membersNum);
        groupInfoQuery.setManagers(managers);
        groupInfoQuery.setMembers(members);
        return groupInfoQuery;
    }

    public List<MemberQuery> queryGroupByType(long grpId, String gmpType){
        return groupMemberDao.selectMemberByType(grpId, gmpType);
    }


}
