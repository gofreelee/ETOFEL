package chatmodule.mapper;

import chatmodule.bean.GroupMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMessageDao {
    int sendMessage(GroupMessage message);
    int deleteMessage(int gmsId);
}
