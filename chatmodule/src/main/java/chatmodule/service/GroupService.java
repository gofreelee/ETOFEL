package chatmodule.service;

import chatmodule.bean.Group;
import chatmodule.bean.GroupByManagerQuery;
import chatmodule.bean.GroupInfoQuery;
import chatmodule.mapper.GroupDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GroupService {
    @Autowired
    GroupDao groupDao;

    private Logger logger = LoggerFactory.getLogger(GroupService.class);

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
        System.out.println(groupName);
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

    public List<Long> randomGroupIds(int need) {
        List<Long> list = groupDao.selectAllGroupId();
        Random random = new Random();
        int range = random.nextInt(list.size());
        for (int i = range; i > 0; i--) {
            int index = random.nextInt(i);
            Long k = list.get(index);
            list.set(index, list.get(i));
            list.set(i, k);
        }
        logger.info(list.toString());
        return list.subList(0, need);
    }

    public List<Group> selectGroupByDateAndName(String grpName, String grpCreatetime){
        if(grpName == null && grpCreatetime == null){
            return null;
        }
        if(grpName!=null) {
            String str = "%" + grpName + "%";
            return groupDao.selectGroupByDateAndName(str, grpCreatetime);
        }
        else {
            return groupDao.selectGroupByDate(grpCreatetime);
        }
    }
}
