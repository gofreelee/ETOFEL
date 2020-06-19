package loginmodule.bean;

import java.io.Serializable;

public class Administer implements Serializable {

    private String ad_username;
    private String ad_password;

    public String getAd_username() {
        return ad_username;
    }

    public void setAd_username(String ad_username) {
        this.ad_username = ad_username;
    }

    public String getAd_password() {
        return ad_password;
    }

    public void setAd_password(String ad_password) {
        this.ad_password = ad_password;
    }

    public Administer() {
    }

    public Administer(String ad_username, String ad_password) {
        this.ad_username = ad_username;
        this.ad_password = ad_password;
    }

    @Override
    public String toString() {
        return "Administer{" +
                "ad_username='" + ad_username + '\'' +
                ", ad_password='" + ad_password + '\'' +
                '}';
    }
}
