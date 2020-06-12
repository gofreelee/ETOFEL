package chatmodule.mapper;

import chatmodule.bean.Group;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupDao {
    int createGroup(@Param("item") Group group);
    int deleteGroup(int groupId);
    int modifyGroupInfo(Group group);
    List<Group>  indistinctiveSelectByName(String groupName);
    List<Group>  selectByType(String groupName);
    Group selectByGrpID(int grpId);

}
