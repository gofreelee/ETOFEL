package chatmodule;

import chatmodule.bean.Group;
import chatmodule.bean.GroupInfoQuery;
import chatmodule.bean.GroupMember;
import chatmodule.bean.GroupMessage;
import chatmodule.mapper.GroupMemberDao;
import chatmodule.service.GroupMemberService;
import chatmodule.service.GroupMessageService;
import chatmodule.service.GroupService;
import com.sun.javaws.IconUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ChatmoduleApplicationTests {
    @Autowired
    GroupService groupService;
    @Autowired
    GroupMemberService groupMemberService;
    @Autowired
    GroupMessageService groupMessageService;
    @Autowired
    GroupMemberDao groupMemberDao;

    @Test
    void contextLoads() {
    }

    @Test
    void testGroupInsert() throws ParseException {
        Timestamp ts = new Timestamp(new Date().getTime());
        System.out.println(ts.toString());
        Group group = new Group(1, "dev群", ts, "dev", "dev", "dev", "dev", "dev", "dev");
        groupService.createGroup(group);
    }

    @Test
    void testGroupDelete() {
        groupService.deleteGroup(1);
    }

    @Test
    void testGroupUpdate() {
        Timestamp ts = new Timestamp(new Date().getTime());
        Group group = new Group(2, "dev群", ts, "dev", "dev", "dev", "dev", "dev", "dev");
        group.setGrpName("update");
        groupService.modifyGroupInfo(group);
    }

    @Test
    void testGroupMemberAdd() {
        GroupMember groupMember = new GroupMember("lzc", 2, "manager");
        groupMemberService.addMember(groupMember);
        groupMember.setGmbUsername("yj");
        groupMember.setGmbType("member");
        groupMemberService.addMember(groupMember);
    }

    @Test
    void testGroupMember() {
        groupMemberService.deleteMember("lzc");
    }

    @Test
    void testGroupMessage() {
        Timestamp ts = new Timestamp(new Date().getTime());
        GroupMessage message = new GroupMessage(1, 2, "lzc", "测试群聊", ts);
        groupMessageService.addOneMessage(message);
    }

    @Test
    void testGroupMessageRemove() {
        groupMessageService.removeMessage(1);
    }

    @Test
    void testGroupSearch() {
        String str = "托福";
        List<Group> groupList = groupService.searchByGroupNameLike(str);

        for (Group group : groupList) {
            System.out.println(group.toString());
        }
    }


    @Test
    void testGroupMemberCounts() {
        System.out.println(groupMemberDao.calculateAllMemberNum(1));
    }

    @Test
    void testQueryGroupInfo() {
        GroupInfoQuery groupInfoQuery = groupMemberService.queryGroupInfo(2);
        System.out.println(groupInfoQuery.toString());

    }

    @Test
    void testMessageSend() {
        GroupMessage message = new GroupMessage(1, 2, "苏苏苏", " = groupService.searchByGroupNameLike(\"dev\");\n" +
                "\n" +
                "        for(Group group: groupList){\n" +
                "            System.out.println(group.toString());", new Timestamp(new Date().getTime()));
        groupMessageService.addOneMessage(message);
    }

    @Test
    void testCalculateNum() {
        System.out.println(groupMessageService.calculateMessageNum(2));
    }

    @Test
    void testGroupSelect(){
        String str = "托福";
        List<Group> groups = groupService.selectGroupByDateAndName(str,null);
        for(Group group : groups){
            System.out.println(group.getGrpName());
        }
    }

}
