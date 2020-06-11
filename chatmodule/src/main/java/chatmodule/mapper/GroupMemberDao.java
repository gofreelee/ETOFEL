package chatmodule.mapper;

import chatmodule.bean.GroupMember;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMemberDao {
    int addGroupMember(GroupMember groupMember);
}
