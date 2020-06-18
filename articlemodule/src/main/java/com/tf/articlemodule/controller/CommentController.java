package com.tf.articlemodule.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tf.articlemodule.bean.Comment;
import com.tf.articlemodule.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
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

    private Gson gson;

    @Autowired
    public void setGson() {
        this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    @PostMapping("/releaseComment")
    public String releaseComment(@RequestParam("cmtUsername") String cmtUsername,
                                 @RequestParam("cmtArtId") String cmtArtId,
                                 @RequestParam("cmtContent") String cmtContent) {
        Comment comment = new Comment();
        comment.setCmt_username(cmtUsername);
        comment.setCmt_art_id(cmtArtId);
        comment.setCmt_content(cmtContent);
        comment.setCmt_date_time(new Timestamp(new Date().getTime()));
        commentService.addComment(comment);
        return "redirect:/";
    }

    @RequestMapping("/selectArtComment")
    public String selectArtComment(@RequestParam("art_id") String artId) {
        List<Comment> list = commentService.selectByArtId(artId);
        return gson.toJson(list);
    }
}
