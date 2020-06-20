package chatmodule.bean;

public class GroupMember {
    private String gmbUsername;
    private long gmbGroupId;
    private String gmbType;

    public GroupMember(String gmbUsername, long gmbGroupId, String gmbType) {
        this.gmbUsername = gmbUsername;
        this.gmbGroupId = gmbGroupId;
        this.gmbType = gmbType;
    }

    public String getGmbUsername() {
        return gmbUsername;
    }

    public void setGmbUsername(String gmbUsername) {
        this.gmbUsername = gmbUsername;
    }

    public long getGmbGroupId() {
        return gmbGroupId;
    }

    public void setGmbGroupId(long gmbGroupId) {
        this.gmbGroupId = gmbGroupId;
    }

    public String getGmbType() {
        return gmbType;
    }

    public void setGmbType(String gmbType) {
        this.gmbType = gmbType;
    }
}
