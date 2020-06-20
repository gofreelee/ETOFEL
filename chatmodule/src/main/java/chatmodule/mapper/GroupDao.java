package chatmodule.mapper;

import chatmodule.bean.Group;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface GroupDao {
    int createGroup(@Param("item") Group group);

    int deleteGroup(long groupId);

    int modifyGroupInfo(Group group);

    List<Group> indistinctiveSelectByName(String groupName);

    List<Group> selectByType(@Param("groupType") String groupType);

    Group selectByGrpID(long grpId);

    int countGroupMembers(long grpId);

    List<Group> selectWhoJoin(@Param("gmbUsername") String gmbUsername, @Param("gmbType") String gmbType);

    List<Long> selectAllGroupId();

    List<Group> selectGroupByDateAndName(@Param("grpName") String grpName, @Param("grpCreateTime") String grpCreateTime);

    List<Group> selectGroupByDate(@Param("grpCreateTime") String grpCreateTime);
}
