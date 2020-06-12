package sichuan.umbrella.chenmm.bean;

import java.util.Date;

public class CourseComment {
    private int ccmtId;
    private String ccmtUsername;
    private Integer ccmtCosDetailId;
    private Date ccmtDate;
    private String ccmtContent;

    public CourseComment(){}

    public CourseComment(int ccmtId, String ccmtUsername, int ccmtCosDetailId, Date ccmtDate, String ccmtContent) {
        this.ccmtId = ccmtId;
        this.ccmtUsername = ccmtUsername;
        this.ccmtCosDetailId = ccmtCosDetailId;
        this.ccmtDate = ccmtDate;
        this.ccmtContent = ccmtContent;
    }
    public CourseComment(String ccmtUsername, int ccmtCosDetailId, Date ccmtDate, String ccmtContent){
        this.ccmtUsername = ccmtUsername;
        this.ccmtCosDetailId = ccmtCosDetailId;
        this.ccmtDate = ccmtDate;
        this.ccmtContent = ccmtContent;
    }

    public int getCcmtId() {
        return ccmtId;
    }

    public void setCcmtId(int ccmtId) {
        this.ccmtId = ccmtId;
    }

    public String getCcmtUsername() {
        return ccmtUsername;
    }

    public void setCcmtUsername(String ccmtUsername) {
        this.ccmtUsername = ccmtUsername;
    }

    public Integer getCcmtCosDetailId() {
        return ccmtCosDetailId;
    }

    public void setCcmtCosDetailId(int ccmtCosDetailId) {
        this.ccmtCosDetailId = ccmtCosDetailId;
    }

    public Date getCcmtDate() {
        return ccmtDate;
    }

    public void setCcmtDate(Date ccmtDate) {
        this.ccmtDate = ccmtDate;
    }

    public String getCcmtContent() {
        return ccmtContent;
    }

    public void setCcmtContent(String ccmtContent) {
        this.ccmtContent = ccmtContent;
    }

    public boolean noNullValue() {
        if (getCcmtUsername() == null || getCcmtCosDetailId() == null || getCcmtDate() == null
                || getCcmtContent() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "CourseComment{" +
                "ccmtId=" + ccmtId +
                ", ccmtUsername='" + ccmtUsername + '\'' +
                ", ccmtCosDetailId=" + ccmtCosDetailId +
                ", ccmtDate=" + ccmtDate +
                ", ccmtContent='" + ccmtContent + '\'' +
                '}';
    }
}
