package chatmodule.mapper;

import chatmodule.bean.GroupMember;
import chatmodule.bean.MemberQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMemberDao {
    int addGroupMember(GroupMember groupMember);
    int deleteMember(String gmbUsername);
    int calculateAllMemberNum(int grpId);
    List<MemberQuery> selectMemberInfo(int grpId);
    List<MemberQuery> selectMemberByType(int grpId, String gmbType);
}
