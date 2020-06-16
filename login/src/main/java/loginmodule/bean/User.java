package loginmodule.bean;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String usr_username;
    private String usr_password;
    private String usr_nickname;
    private String usr_gender;
    private String usr_email;
    private String usr_phone;
    private Date usr_birthday;
    private String usr_sign;
    private String usr_portrait;
    private String usr_state;

    public String getUsr_username() {
        return usr_username;
    }

    public void setUsr_username(String usr_username) {
        this.usr_username = usr_username;
    }

    public String getUsr_password() {
        return usr_password;
    }

    public void setUsr_password(String usr_password) {
        this.usr_password = usr_password;
    }

    public String getUsr_nickname() {
        return usr_nickname;
    }

    public void setUsr_nickname(String usr_nickname) {
        this.usr_nickname = usr_nickname;
    }

    public String getUsr_gender() {
        return usr_gender;
    }

    public void setUsr_gender(String usr_gender) {
        this.usr_gender = usr_gender;
    }

    public String getUsr_email() {
        return usr_email;
    }

    public void setUsr_email(String usr_email) {
        this.usr_email = usr_email;
    }

    public String getUsr_phone() {
        return usr_phone;
    }

    public void setUsr_phone(String usr_phone) {
        this.usr_phone = usr_phone;
    }

    public Date getUsr_birthday() {
        return usr_birthday;
    }

    public void setUsr_birthday(Date usr_birthday) {
        this.usr_birthday = usr_birthday;
    }

    public String getUsr_sign() {
        return usr_sign;
    }

    public void setUsr_sign(String usr_sign) {
        this.usr_sign = usr_sign;
    }

    public String getUsr_portrait() {
        return usr_portrait;
    }

    public void setUsr_portrait(String usr_portrait) {
        this.usr_portrait = usr_portrait;
    }

    public String getUsr_state() {
        return usr_state;
    }

    public void setUsr_state(String usr_state) {
        this.usr_state = usr_state;
    }

    public User() {
    }

    public User(String usr_username, String usr_password, String usr_nickname, String usr_gender, String usr_email, String usr_phone, Date usr_birthday, String usr_sign, String usr_portrait, String usr_state) {
        this.usr_username = usr_username;
        this.usr_password = usr_password;
        this.usr_nickname = usr_nickname;
        this.usr_gender = usr_gender;
        this.usr_email = usr_email;
        this.usr_phone = usr_phone;
        this.usr_birthday = usr_birthday;
        this.usr_sign = usr_sign;
        this.usr_portrait = usr_portrait;
        this.usr_state = usr_state;
    }

    @Override
    public String toString() {
        return "User{" +
                "usr_username='" + usr_username + '\'' +
                ", usr_password='" + usr_password + '\'' +
                ", usr_nickname='" + usr_nickname + '\'' +
                ", usr_gender='" + usr_gender + '\'' +
                ", usr_email='" + usr_email + '\'' +
                ", usr_phone='" + usr_phone + '\'' +
                ", usr_birthday=" + usr_birthday +
                ", usr_sign='" + usr_sign + '\'' +
                ", usr_portrait='" + usr_portrait + '\'' +
                ", usr_state='" + usr_state + '\'' +
                '}';
    }
}
