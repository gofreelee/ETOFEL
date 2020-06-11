package chatmodule.bean;

public class GroupMember {
    private String gmbUsername;
    private int    gmbGroupId;
    private String gmbType;

    public GroupMember(String gmbUsername, int gmbGroupId, String gmbType) {
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

    public int getGmbGroupId() {
        return gmbGroupId;
    }

    public void setGmbGroupId(int gmbGroupId) {
        this.gmbGroupId = gmbGroupId;
    }

    public String getGmbType() {
        return gmbType;
    }

    public void setGmbType(String gmbType) {
        this.gmbType = gmbType;
    }
}
