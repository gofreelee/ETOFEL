package com.tf.articlemodule.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.tf.articlemodule.bean.Comment;
import com.tf.articlemodule.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

  @Autowired
  private CommentService commentService;

  @Autowired
  private Gson gson;

  @RequestMapping("/releaseComment")
  public String releaseComment(Comment comment) {
    commentService.addComment(comment);
    return "redirect:/";
  }

  @RequestMapping("/selectArtComment")
  public String selectArtComment(@RequestParam("art_id") String artId) {
      List<Comment> list=commentService.selectByArtId(artId);
      return gson.toJson(list);
  }
}
