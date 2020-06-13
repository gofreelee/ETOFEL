package loginmodule.bean;

import java.util.Date;

public class Teacher {

    private String tch_username;
    private String tch_password;
    private String tch_name;
    private String tch_gender;
    private String tch_email;
    private String tch_phone;
    private Date tch_birthday;
    private String tch_description;

    public String getTch_username() {
        return tch_username;
    }

    public String getTch_password() {
        return tch_password;
    }

    public String getTch_name() {
        return tch_name;
    }

    public String getTch_gender() {
        return tch_gender;
    }

    public String getTch_email() {
        return tch_email;
    }

    public String getTch_phone() {
        return tch_phone;
    }

    public Date getTch_birthday() {
        return tch_birthday;
    }

    public String getTch_description() {
        return tch_description;
    }

    public Teacher() {
    }

    public Teacher(String tch_username, String tch_password, String tch_name, String tch_gender, String tch_email, String tch_phone, Date tch_birthday, String tch_description) {
        this.tch_username = tch_username;
        this.tch_password = tch_password;
        this.tch_name = tch_name;
        this.tch_gender = tch_gender;
        this.tch_email = tch_email;
        this.tch_phone = tch_phone;
        this.tch_birthday = tch_birthday;
        this.tch_description = tch_description;
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
                '}';
    }
}
