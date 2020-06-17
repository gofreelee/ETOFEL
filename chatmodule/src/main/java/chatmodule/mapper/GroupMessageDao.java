package chatmodule.mapper;

import chatmodule.bean.GroupMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMessageDao {
    int sendMessage(GroupMessage message);
    int deleteMessage(long gmsId);
    int calculateMessageNum(long grpId);
    List<GroupMessage> selectMessageLimitBy(long grpId, int start, int end);
}
