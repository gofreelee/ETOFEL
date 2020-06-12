package com.example.user.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Teacher {
    private String tch_username;
    private String tch_password;
    private String tch_name;
    private String tch_gender;
    private String tch_email;
    private String tch_phone;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tch_birthday;
    private String tch_description;
    private String tch_portrait;
    private String tch_education;

    public String getTch_education() {
        return tch_education;
    }

    public void setTch_education(String tch_education) {
        this.tch_education = tch_education;
    }

    public Teacher(String tch_username, String tch_password, String tch_name,
                   String tch_gender, String tch_email, String tch_phone,
                   Date tch_birthday, String tch_description, String tch_portrait,
                   String tch_education) {
        this.tch_username = tch_username;
        this.tch_password = tch_password;
        this.tch_name = tch_name;
        this.tch_gender = tch_gender;
        this.tch_email = tch_email;
        this.tch_phone = tch_phone;
        this.tch_birthday = tch_birthday;
        this.tch_description = tch_description;
        this.tch_portrait = tch_portrait;
        this.tch_education = tch_education;
    }

    public String getTch_username() {
        return tch_username;
    }

    public void setTch_username(String tch_username) {
        this.tch_username = tch_username;
    }

    public String getTch_password() {
        return tch_password;
    }

    public void setTch_password(String tch_password) {
        this.tch_password = tch_password;
    }

    public String getTch_name() {
        return tch_name;
    }

    public void setTch_name(String tch_name) {
        this.tch_name = tch_name;
    }

    public String getTch_gender() {
        return tch_gender;
    }

    public void setTch_gender(String tch_gender) {
        this.tch_gender = tch_gender;
    }

    public String getTch_email() {
        return tch_email;
    }

    public void setTch_email(String tch_email) {
        this.tch_email = tch_email;
    }

    public String getTch_phone() {
        return tch_phone;
    }

    public void setTch_phone(String tch_phone) {
        this.tch_phone = tch_phone;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getTch_birthday() {
        return tch_birthday;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    public void setTch_birthday(Date tch_birthday) {
        this.tch_birthday = tch_birthday;
    }

    public String getTch_description() {
        return tch_description;
    }

    public void setTch_description(String tch_description) {
        this.tch_description = tch_description;
    }

    public String getTch_portrait() {
        return tch_portrait;
    }

    public void setTch_portrait(String tch_portrait) {
        this.tch_portrait = tch_portrait;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tch_username='" + tch_username + '\'' +
                ", tch_password='" + tch_password + '\'' +
                ", tch_name='" + tch_name + '\'' +
                ", tch_gender='" + tch_gender + '\'' +
                ", tch_email='" + tch_email + '\'' +
                ", tch_phone='" + tch_phone + '\'' +
                ", tch_birthday=" + tch_birthday +
                ", tch_description='" + tch_description + '\'' +
                ", tch_portrait='" + tch_portrait + '\'' +
                ", tch_education='" + tch_education + '\'' +
                '}';
    }

    public Teacher() {
        super();
    }
}
