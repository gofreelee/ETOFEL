package sichuan.umbrella.chenmm.bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class CourseWithTeacher implements Serializable {
    private Integer cosId;
    private String cosTitle;
    private Date cosStartDate;
    private Date cosEndDate;
    private Time cosStartTime;
    private Time cosEndTime;
    private Double cosFee;
    private String cosCategory;
    private String cosStage;
    private String cosStatus;
    private String cosTeacher;

    public CourseWithTeacher(Integer cosId, String cosTitle, Date cosStartDate, Date cosEndDate, Time cosStartTime, Time cosEndTime, Double cosFee, String cosCategory, String cosStage, String cosStatus, String cosTeacher) {
        this.cosId = cosId;
        this.cosTitle = cosTitle;
        this.cosStartDate = cosStartDate;
        this.cosEndDate = cosEndDate;
        this.cosStartTime = cosStartTime;
        this.cosEndTime = cosEndTime;
        this.cosFee = cosFee;
        this.cosCategory = cosCategory;
        this.cosStage = cosStage;
        this.cosStatus = cosStatus;
        this.cosTeacher = cosTeacher;
    }

    public CourseWithTeacher(){}

    public Integer getCosId() {
        return cosId;
    }

    public void setCosId(Integer cosId) {
        this.cosId = cosId;
    }

    public String getCosTitle() {
        return cosTitle;
    }

    public void setCosTitle(String cosTitle) {
        this.cosTitle = cosTitle;
    }

    public Date getCosStartDate() {
        return cosStartDate;
    }

    public void setCosStartDate(Date cosStartDate) {
        this.cosStartDate = cosStartDate;
    }

    public Date getCosEndDate() {
        return cosEndDate;
    }

    public void setCosEndDate(Date cosEndDate) {
        this.cosEndDate = cosEndDate;
    }

    public Time getCosStartTime() {
        return cosStartTime;
    }

    public void setCosStartTime(Time cosStartTime) {
        this.cosStartTime = cosStartTime;
    }

    public Time getCosEndTime() {
        return cosEndTime;
    }

    public void setCosEndTime(Time cosEndTime) {
        this.cosEndTime = cosEndTime;
    }

    public Double getCosFee() {
        return cosFee;
    }

    public void setCosFee(Double cosFee) {
        this.cosFee = cosFee;
    }

    public String getCosCategory() {
        return cosCategory;
    }

    public void setCosCategory(String cosCategory) {
        this.cosCategory = cosCategory;
    }

    public String getCosStage() {
        return cosStage;
    }

    public void setCosStage(String cosStage) {
        this.cosStage = cosStage;
    }

    public String getCosStatus() {
        return cosStatus;
    }

    public void setCosStatus(String cosStatus) {
        this.cosStatus = cosStatus;
    }

    public String getCosTeacher() {
        return cosTeacher;
    }

    public void setCosTeacher(String cosTeacher) {
        this.cosTeacher = cosTeacher;
    }
}
