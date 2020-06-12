package chatmodule.bean;

public class MemberQuery {
    private String gmbUsername;
    private String userPortrait;
    private String userType;

    public MemberQuery(String gmbUsername, String userPortrait, String userType) {
        this.gmbUsername = gmbUsername;
        this.userPortrait = userPortrait;
        this.userType = userType;
    }

    public String getGmbUsername() {
        return gmbUsername;
    }

    public void setGmbUsername(String gmbUsername) {
        this.gmbUsername = gmbUsername;
    }

    public String getUserPortrait() {
        return userPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
