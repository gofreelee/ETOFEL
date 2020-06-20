package com.tf.articlemodule.bean;

import java.util.Date;

public class ManagerQueryArticle {
    private String art_title;
    private String art_type;
    private String art_username;
    private Date art_date;

    public ManagerQueryArticle(String art_title, String art_type, String art_username, Date art_date) {
        this.art_title = art_title;
        this.art_type = art_type;
        this.art_username = art_username;
        this.art_date = art_date;
    }

    public ManagerQueryArticle(){}

    public String getArt_title() {
        return art_title;
    }

    public void setArt_title(String art_title) {
        this.art_title = art_title;
    }

    public String getArt_type() {
        return art_type;
    }

    public void setArt_type(String art_type) {
        this.art_type = art_type;
    }

    public String getArt_username() {
        return art_username;
    }

    public void setArt_username(String art_username) {
        this.art_username = art_username;
    }

    public Date getArt_date() {
        return art_date;
    }

    public void setArt_date(Date art_date) {
        this.art_date = art_date;
    }
}
