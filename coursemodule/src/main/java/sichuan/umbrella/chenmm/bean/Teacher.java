package sichuan.umbrella.chenmm.bean;

import java.util.Date;

public class Teacher {
    private String tchUsername;
    private String tchPassword;
    private String tchName;
    private String tchGender;
    private String tchEmail;
    private String tchPhone;
    private Date tchBirthday;
    private String tchDescription;
    private String tchPortrait;

    public Teacher(){}

    public Teacher(String tchUsername, String tchPassword, String tchName, String tchGender, String tchEmail, String tchPhone, Date tchBirthday, String tchDescription, String tchPortrait) {
        this.tchUsername = tchUsername;
        this.tchPassword = tchPassword;
        this.tchName = tchName;
        this.tchGender = tchGender;
        this.tchEmail = tchEmail;
        this.tchPhone = tchPhone;
        this.tchBirthday = tchBirthday;
        this.tchDescription = tchDescription;
        this.tchPortrait = tchPortrait;
    }

    public String getTchUsername() {
        return tchUsername;
    }

    public void setTchUsername(String tchUsername) {
        this.tchUsername = tchUsername;
    }

    public String getTchPassword() {
        return tchPassword;
    }

    public void setTchPassword(String tchPassword) {
        this.tchPassword = tchPassword;
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName;
    }

    public String getTchGender() {
        return tchGender;
    }

    public void setTchGender(String tchGender) {
        this.tchGender = tchGender;
    }

    public String getTchEmail() {
        return tchEmail;
    }

    public void setTchEmail(String tchEmail) {
        this.tchEmail = tchEmail;
    }

    public String getTchPhone() {
        return tchPhone;
    }

    public void setTchPhone(String tchPhone) {
        this.tchPhone = tchPhone;
    }

    public Date getTchBirthday() {
        return tchBirthday;
    }

    public void setTchBirthday(Date tchBirthday) {
        this.tchBirthday = tchBirthday;
    }

    public String getTchDescription() {
        return tchDescription;
    }

    public void setTchDescription(String tchDescription) {
        this.tchDescription = tchDescription;
    }

    public String getTchPortrait() {
        return tchPortrait;
    }

    public void setTchPortrait(String tchPortrait) {
        this.tchPortrait = tchPortrait;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tchUsername='" + tchUsername + '\'' +
                ", tchPassword='" + tchPassword + '\'' +
                ", tchName='" + tchName + '\'' +
                ", tchGender='" + tchGender + '\'' +
                ", tchEmail='" + tchEmail + '\'' +
                ", tchPhone='" + tchPhone + '\'' +
                ", tchBirthday=" + tchBirthday +
                ", tchDescription='" + tchDescription + '\'' +
                ", tchPortrait='" + tchPortrait + '\'' +
                '}';
    }
}
