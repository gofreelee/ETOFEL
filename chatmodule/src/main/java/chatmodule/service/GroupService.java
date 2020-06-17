package chatmodule.service;

import chatmodule.bean.Group;
import chatmodule.mapper.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupDao groupDao;

    public int createGroup(Group group) {
        return groupDao.createGroup(group);
    }

    public int deleteGroup(long grpId) {
        return groupDao.deleteGroup(grpId);
    }

    public int modifyGroupInfo(Group group) {
        return groupDao.modifyGroupInfo(group);
    }

    public List<Group> searchByGroupNameLike(String groupName) {
        groupName = "%" + groupName + "%";
        return groupDao.indistinctiveSelectByName(groupName);
    }

    public List<Group> searchByGroupType(String groupType) {
        return groupDao.selectByType(groupType);
    }

    public int countGroupMembers(long grpId) {
        return groupDao.countGroupMembers(grpId);
    }

    public Group selectByGrpID(long grpId) {
        return groupDao.selectByGrpID(grpId);
    }

    public List<Group> selectWhoJoin(String gmbUsername, String gmbType) {
        return groupDao.selectWhoJoin(gmbUsername, gmbType);
    }
}
