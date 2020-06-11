package chatmodule;

import chatmodule.bean.Group;
import chatmodule.bean.GroupMember;
import chatmodule.service.GroupMemberService;
import chatmodule.service.GroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class ChatmoduleApplicationTests {
    @Autowired
    GroupService groupService;
    @Autowired
    GroupMemberService groupMemberService;
    @Test
    void contextLoads() {
    }

    @Test
    void testGroupCrud() throws ParseException {
        Timestamp  ts=new Timestamp(new Date().getTime());
        System.out.println(ts.toString());
        Group group = new Group(1,"dev群",ts.toString(),"dev","dev","dev","dev","dev","dev");
        groupService.createGroup(group);
    }

    @Test
    void testGroupMember(){
        GroupMember groupMember = new GroupMember("lzc",1,"管理");
        groupMemberService.addMember(groupMember);
    }

}
