package chatmodule.mapper;

import chatmodule.bean.GroupMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMessageDao {
    int sendMessage(GroupMessage message);
    int deleteMessage(int gmsId);
    int calculateMessageNum(int grpId);
    List<GroupMessage> selectMessageLimitBy(int grpId, int start, int end);
}
