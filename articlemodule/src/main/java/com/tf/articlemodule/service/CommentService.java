package com.tf.articlemodule.service;

import com.tf.articlemodule.bean.Comment;
import com.tf.articlemodule.mapper.CommentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

  @Autowired
  private CommentDao commentDao;

  public void addComment(Comment comment) {
    commentDao.insert(comment);
  }

  public void removeComment(String cmtId) { commentDao.deleteByCmtId(cmtId); }

  public List<Comment> selectByArtId(String artId) { return commentDao.selectByArtId(artId);  }
}
