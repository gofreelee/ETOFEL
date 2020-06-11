package chatmodule.mapper;

import chatmodule.bean.Group;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDao {
    int createGroup(@Param("item") Group group);
    int deleteGroup(int groupId);
    int modifyGroupInfo(Group group);

}
