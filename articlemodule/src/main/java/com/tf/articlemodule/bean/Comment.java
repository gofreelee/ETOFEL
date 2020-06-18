package com.tf.articlemodule.bean;

import java.sql.Timestamp;

public class Comment {

  private String cmt_id;
  private String cmt_username;
  private String cmt_art_id;
  private Timestamp cmt_date_time;
  private String cmt_content;

  public Comment() {}

  public Comment(String cmt_id, String cmtUserNo, String cmt_art_id, Timestamp cmt_date_time, String cmt_content) {
    this.cmt_id = cmt_id;
    this.cmt_username = cmtUserNo;
    this.cmt_art_id = cmt_art_id;
    this.cmt_date_time = cmt_date_time;
    this.cmt_content = cmt_content;
  }

  public String getCmt_id() {
    return cmt_id;
  }

  public void setCmt_id(String cmt_id) {
    this.cmt_id = cmt_id;
  }

  public String getCmt_username() {
    return cmt_username;
  }

  public void setCmt_username(String cmt_username) {
    this.cmt_username = cmt_username;
  }

  public String getCmt_art_id() {
    return cmt_art_id;
  }

  public void setCmt_art_id(String cmt_art_id) {
    this.cmt_art_id = cmt_art_id;
  }

  public Timestamp getCmt_date_time() {
    return cmt_date_time;
  }

  public void setCmt_date_time(Timestamp cmt_date_time) {
    this.cmt_date_time = cmt_date_time;
  }

  public String getCmt_content() {
    return cmt_content;
  }

  public void setCmt_content(String cmt_content) {
    this.cmt_content = cmt_content;
  }

  @Override
  public String toString() {
    return "Comment{" +
            "cmt_id='" + cmt_id + '\'' +
            ", cmt_username='" + cmt_username + '\'' +
            ", cmt_art_id='" + cmt_art_id + '\'' +
            ", cmt_date_time='" + cmt_date_time + '\'' +
            ", cmt_content='" + cmt_content + '\'' +
            '}';
  }
}
