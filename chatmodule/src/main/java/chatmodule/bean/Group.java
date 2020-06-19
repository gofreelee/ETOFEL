package chatmodule.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Group {
    private long grpId;
    private String grpName;
    private Timestamp grpCreateTime;
    private String grpDescription;
    private String grpRule;
    private String grpType;
    private String grpPortrait;
    private String grpCreator;
    private String grpStatus;

    public Group() {}

    public Group(long grpId, String grpName, Timestamp grpCreateTime, String grpDescription, String grpRule, String grpType, String grpPortrait, String grpCreator, String grpStatus) {
        this.grpId = grpId;
        this.grpName = grpName;
        this.grpCreateTime = grpCreateTime;
        this.grpDescription = grpDescription;
        this.grpRule = grpRule;
        this.grpType = grpType;
        this.grpPortrait = grpPortrait;
        this.grpCreator = grpCreator;
        this.grpStatus = grpStatus;
    }

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

    public String getGrpRule() {
        return grpRule;
    }

    public void setGrpRule(String grpRule) {
        this.grpRule = grpRule;
    }

    public String getGrpType() {
        return grpType;
    }

    public void setGrpType(String grpType) {
        this.grpType = grpType;
    }

    public String getGrpPortrait() {
        return grpPortrait;
    }

    public void setGrpPortrait(String grpPortrait) {
        this.grpPortrait = grpPortrait;
    }

    public String getGrpCreator() {
        return grpCreator;
    }

    public void setGrpCreator(String grpCreator) {
        this.grpCreator = grpCreator;
    }

    public String getGrpStatus() {
        return grpStatus;
    }

    public void setGrpStatus(String grpStatus) {
        this.grpStatus = grpStatus;
    }

    @Override
    public String toString() {
        return "group{" +
                "grpId=" + grpId +
                ", grpName='" + grpName + '\'' +
                ", grpCreateTime=" + grpCreateTime +
                ", grpDescription='" + grpDescription + '\'' +
                ", grpRule='" + grpRule + '\'' +
                ", grpType='" + grpType + '\'' +
                ", grpPortrait='" + grpPortrait + '\'' +
                ", grpCreator='" + grpCreator + '\'' +
                ", grpStatus='" + grpStatus + '\'' +
                '}';
    }
}
