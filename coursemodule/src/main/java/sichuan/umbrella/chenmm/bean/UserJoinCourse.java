package sichuan.umbrella.chenmm.bean;

public class UserJoinCourse {
    private Integer ujcCosId;
    private String ujcUsrUsername;
    private String ujcStatus;

    public UserJoinCourse(){}

    public UserJoinCourse(int ujcCosId, String ujcUsrUsername, String ujcStatus) {
        this.ujcCosId = ujcCosId;
        this.ujcUsrUsername = ujcUsrUsername;
        this.ujcStatus = ujcStatus;
    }

    public boolean noNullValue() {
        return getUjcCosId() != null && getUjcUsrUsername() != null && getUjcStatus() != null;
    }

    public Integer getUjcCosId() {
        return ujcCosId;
    }

    public void setUjcCosId(int ujcCosId) {
        this.ujcCosId = ujcCosId;
    }

    public String getUjcUsrUsername() {
        return ujcUsrUsername;
    }

    public void setUjcUsrUsername(String ujcUsrUsername) {
        this.ujcUsrUsername = ujcUsrUsername;
    }

    public String getUjcStatus() {
        return ujcStatus;
    }

    public void setUjcStatus(String ujcStatus) {
        this.ujcStatus = ujcStatus;
    }

    @Override
    public String toString() {
        return "UserJoinCourse{" +
                "ujcCosId=" + ujcCosId +
                ", ujcUsrUsername='" + ujcUsrUsername + '\'' +
                ", ujcStatus='" + ujcStatus + '\'' +
                '}';
    }

}
