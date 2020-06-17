package chatmodule.service;

import chatmodule.bean.GroupMessage;
import chatmodule.mapper.GroupMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMessageService {
    @Autowired
    GroupMessageDao groupMessageDao;
    public int addOneMessage(GroupMessage groupMessage){
        return groupMessageDao.sendMessage(groupMessage);
    }

    public int removeMessage(int gmsId)
    {
        return groupMessageDao.deleteMessage(gmsId);
    }

    public int calculateMessageNum(long grpId){
        return groupMessageDao.calculateMessageNum(grpId);
    }

    public List<GroupMessage> selectMessageLimitBy(long grpId, int start, int end){
        return groupMessageDao.selectMessageLimitBy(grpId, start, end);
    }
}
