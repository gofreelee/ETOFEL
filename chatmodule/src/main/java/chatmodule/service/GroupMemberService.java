package chatmodule.service;

import chatmodule.bean.GroupMember;
import chatmodule.mapper.GroupMemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupMemberService {
    @Autowired
    GroupMemberDao groupMemberDao;
    public int addMember(GroupMember groupMember){
       return  groupMemberDao.addGroupMember(groupMember);
    }

    public int deleteMember(String gmbUsername){
        return groupMemberDao.deleteMember(gmbUsername);
    }

}
