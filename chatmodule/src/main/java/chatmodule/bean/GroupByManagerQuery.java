package chatmodule.bean;

import java.sql.Timestamp;

public class GroupByManagerQuery {
    private long   grpId;
    private String grpName;
    private Timestamp grpCreateTime;
    private String grpDescription;
    private String grpCreator;
    private int grpAllMembers;
    private int grpManagerNumber;

    public GroupByManagerQuery(long grpId, String grpName, Timestamp grpCreateTime, String grpDescription, String grpCreator, int grpAllMembers, int grpManagerNumber) {
        this.grpId = grpId;
        this.grpName = grpName;
        this.grpCreateTime = grpCreateTime;
        this.grpDescription = grpDescription;
        this.grpCreator = grpCreator;
        this.grpAllMembers = grpAllMembers;
        this.grpManagerNumber = grpManagerNumber;
    }

    public GroupByManagerQuery(){}

    public long getGrpId() {
        return grpId;
    }

    public void setGrpId(long grpId) {
        this.grpId = grpId;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }

    public Timestamp getGrpCreateTime() {
        return grpCreateTime;
    }

    public void setGrpCreateTime(Timestamp grpCreateTime) {
        this.grpCreateTime = grpCreateTime;
    }

    public String getGrpDescription() {
        return grpDescription;
    }

    public void setGrpDescription(String grpDescription) {
        this.grpDescription = grpDescription;
    }

    public String getGrpCreator() {
        return grpCreator;
    }

    public void setGrpCreator(String grpCreator) {
        this.grpCreator = grpCreator;
    }

    public int getGrpAllMembers() {
        return grpAllMembers;
    }

    public void setGrpAllMembers(int grpAllMembers) {
        this.grpAllMembers = grpAllMembers;
    }

    public int getGrpManagerNumber() {
        return grpManagerNumber;
    }

    public void setGrpManagerNumber(int grpManagerNumber) {
        this.grpManagerNumber = grpManagerNumber;
    }
}
