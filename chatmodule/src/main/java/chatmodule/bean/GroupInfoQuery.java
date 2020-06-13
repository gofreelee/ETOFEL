package chatmodule.bean;

import java.util.List;

public class GroupInfoQuery {
    private  Group  baseInfo;
    private  int    groupMembers;
    private List<MemberQuery> managers;
    private List<MemberQuery> members;

    public GroupInfoQuery(Group baseInfo, int groupMembers, List<MemberQuery> managers, List<MemberQuery> members) {
        this.baseInfo = baseInfo;
        this.groupMembers = groupMembers;
        this.managers = managers;
        this.members = members;
    }

    public GroupInfoQuery(){}

    public Group getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(Group baseInfo) {
        this.baseInfo = baseInfo;
    }

    public int getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(int groupMembers) {
        this.groupMembers = groupMembers;
    }

    public List<MemberQuery> getManagers() {
        return managers;
    }

    public void setManagers(List<MemberQuery> managers) {
        this.managers = managers;
    }

    public List<MemberQuery> getMembers() {
        return members;
    }

    public void setMembers(List<MemberQuery> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "GroupInfoQuery{" +
                "baseInfo=" + baseInfo +
                ", groupMembers=" + groupMembers +
                ", managers=" + managers.toString() +
                ", members=" + members.toString() +
                '}';
    }
}
