package chatmodule.bean;

import java.sql.Timestamp;
import java.util.Date;

public class GroupMessage {
    private int gmsId;
    private int gmsGrpId;
    private String gmsUsername;
    private String gmsContext;
    private Timestamp gmsCreateTime;

    public GroupMessage(int gmsId, int gmsGrpId, String gmsUsername, String gmsContext, Timestamp gmsCreateTime) {
        this.gmsId = gmsId;
        this.gmsGrpId = gmsGrpId;
        this.gmsUsername = gmsUsername;
        this.gmsContext = gmsContext;
        this.gmsCreateTime = gmsCreateTime;
    }

    public int getGmsId() {
        return gmsId;
    }

    public void setGmsId(int gmsId) {
        this.gmsId = gmsId;
    }

    public int getGmsGrpId() {
        return gmsGrpId;
    }

    public void setGmsGrpId(int gmsGrpId) {
        this.gmsGrpId = gmsGrpId;
    }

    public String getGmsUsername() {
        return gmsUsername;
    }

    public void setGmsUsername(String gmsUsername) {
        this.gmsUsername = gmsUsername;
    }

    public String getGmsContext() {
        return gmsContext;
    }

    public void setGmsContext(String gmsContext) {
        this.gmsContext = gmsContext;
    }

    public Timestamp getGmsCreateTime() {
        return gmsCreateTime;
    }

    public void setGmsCreateTime(Timestamp gmsCreateTime) {
        this.gmsCreateTime = gmsCreateTime;
    }
}
