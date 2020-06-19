package com.tf.articlemodule.bean;

import java.util.Arrays;
import java.util.Date;

public class Article {

  private String art_id;
  private String art_username;
  private String art_title;
  private Date art_date;
  private String art_img;
  private String art_text;
  private String art_type;

  public Article() {}

  public Article(
      String art_id,
      String art_username,
      String art_title,
      Date art_date_time,
      String art_img,
      String art_text,
      String art_type) {
    this.art_id = art_id;
    this.art_username = art_username;
    this.art_title = art_title;
    this.art_type = art_type;
    this.art_date = art_date_time;
    this.art_img = art_img;
    this.art_text = art_text;
  }

  public String getArt_id() {
    return art_id;
  }

  public void setArt_id(String art_id) {
    this.art_id = art_id;
  }

  public String getArt_username() {
    return art_username;
  }

  public void setArt_username(String art_username) {
    this.art_username = art_username;
  }

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

  public Date getArt_date_time() {
    return art_date;
  }

  public void setArt_date_time(Date art_date_time) {
    this.art_date = art_date_time;
  }

  public String getArt_img() {
    return art_img;
  }

  public void setArt_img(String art_img) {
    this.art_img = art_img;
  }

  public String getArt_text() {
    return art_text;
  }

  public void setArt_text(String art_text) {
    this.art_text = art_text;
  }

  @Override
  public String toString() {
    return "Article{" +
            "art_id='" + art_id + '\'' +
            ", art_username='" + art_username + '\'' +
            ", art_title='" + art_title + '\'' +
            ", art_date_time='" + art_date + '\'' +
            ", art_img=" + art_img +
            ", art_text='" + art_text + '\'' +
            ", art_type='" + art_type + '\'' +
            '}';
  }

}
