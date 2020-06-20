package chatmodule.mapper;

import chatmodule.bean.GroupMember;
import chatmodule.bean.MemberQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMemberDao {
    int addGroupMember(GroupMember groupMember);

    int deleteMember(String gmbUsername);

    int calculateAllMemberNum(long grpId);

    List<MemberQuery> selectMemberInfo(long grpId);

    List<MemberQuery> selectMemberTeacherInfo(long grpId);

    List<MemberQuery> selectMemberByType(long grpId, String gmbType);

    String findCreator(long grpId);

    void updateMemberType(@Param("gmbUsername") String gmbUsername, @Param("gmbGrpId") long gmbGrpId, @Param("gmbType") String gmbType);

    GroupMember getGroupMember(@Param("gmbUsername") String gmbUsername, @Param("gmbGrpId") long gmbGrpId);
}
