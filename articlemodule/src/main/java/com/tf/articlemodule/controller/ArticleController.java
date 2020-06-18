package com.tf.articlemodule.controller;

import com.google.gson.Gson;
import com.tf.articlemodule.bean.Article;
import com.tf.articlemodule.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tofel-article")
public class ArticleController {

  @Autowired
  private ArticleService articleService;

  @Autowired
  private Gson gson;



//  private String art_id;
//  private String art_username;
//  private String art_title;
//  private String art_date_time;
//  private String art_img;
//  private String art_text;
//  private String art_type;
  @RequestMapping(value = "/createArticle", method = RequestMethod.POST)
  public void create(@RequestParam("artUsername") String artUsername,
                       @RequestParam("artTitle") String artTitle,
                       @RequestParam("artImg") String artImg,
                       @RequestParam("artText") String artText,
                       @RequestParam("artType") String artType) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Article article = new Article();
    article.setArt_date_time(new Date());
    article.setArt_img(artImg);
    article.setArt_text(artText);
    article.setArt_type(artType);
    article.setArt_username(artUsername);
    article.setArt_title(artTitle);
//    if (file != null) {
//      System.out.println("file is not null");
//      article.setArt_img(file.getBytes());
//    }
    articleService.addArticle(article);
  }

  @RequestMapping("classArticle/{artType}")
  public String classArticle(
          @PathVariable(value = "artType", required = false) String artType) {
    List<Article> articleList = articleService.selectByArtType(artType);
    for (Article each : articleList) {
      if (each.getArt_text().length() >= 200) {
        each.setArt_text(each.getArt_text().substring(0, 200) + "......");
      }
    }
    return gson.toJson(articleList);
  }

  @RequestMapping("startpage")
  public String startpage() {
    List<Article> articleListListening = articleService.selectByArtType("Listen");
    List<Article> articleListSpeaking = articleService.selectByArtType("Speak");
    List<Article> articleListReading = articleService.selectByArtType("Read");
    List<Article> articleListWriting = articleService.selectByArtType("Write");
    Map<String, Object> map=new HashMap<>();
    for (Article each : articleListListening) {
      if (each.getArt_title().length() >= 25) {
        each.setArt_title(each.getArt_title().substring(0, 25) + "...");
      }
    }
    for (Article each : articleListSpeaking) {
      if (each.getArt_title().length() >= 25) {
        each.setArt_title(each.getArt_title().substring(0, 25) + "...");
      }
    }
    for (Article each : articleListReading) {
      if (each.getArt_title().length() >= 25) {
        each.setArt_title(each.getArt_title().substring(0, 25) + "...");
      }
    }
    for (Article each : articleListWriting) {
      if (each.getArt_title().length() >= 25) {
        each.setArt_title(each.getArt_title().substring(0, 25) + "...");
      }
    }
    map.put("Listen",articleListListening);
    map.put("Speak",articleListSpeaking);
    map.put("Read",articleListReading);
    map.put("Write",articleListWriting);
    return gson.toJson(map);
  }

  @RequestMapping("/getArtImg/{artId}")
  public String getArtImg(@PathVariable(value = "artId") String artId)
          throws Exception {
    String artImg = null;
    try {
      artImg = articleService.getArticle(artId).getArt_img();
    } catch (Exception e) { }
    if (artImg == null) {
      artImg = articleService.getArticle("-1").getArt_img();//编号为-1的为默认图片，目前未插入
    }
    return gson.toJson(artImg);
  }

  @RequestMapping("/getArtInfo/{artId}")
  public String getArticleInfo(
          @PathVariable(value = "artId") String artId) {
    return gson.toJson(articleService.getArticle(artId));
  }

  @RequestMapping("/remove/{artId}")
  public String remove(@PathVariable("artId") String artId) {
    articleService.removeArticle(artId);
    return "redirect:/";
  }

  //  @RequestMapping("nextArticlePage")
//  public String nextArticlePage(
//          @RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNoStr) {
//
//    int pageNo = Integer.parseInt(pageNoStr);
//    if (pageNo < 1) {
//      pageNo = 1;
//    }
//
//    PageHelper.startPage(pageNo, 3);
//    List<Article> articleList = articleService.selectAll();
//    System.out.println(articleList.size());
//
//    for (Article each : articleList) {
//      if (each.getArt_text().length() >= 200) {
//        each.setArt_text(each.getArt_text().substring(0, 200) + "......");
//      }
//    }
//
//    PageInfo<Article> page = new PageInfo<>(articleList);
//
//    return gson.toJson(page);
//  }

//  @RequestMapping(value = "/preUpdate/{artId}")
//  public String preUpdate(@PathVariable("artId") String artId, Map<String, Object> map) {
//
//    map.put("article", articleService.getArticle(artId));
//
//    return "tofel-article/editArticle";
//  }

//  @RequestMapping(value = "/update")
//  public String update(@RequestParam("artImgUpload") MultipartFile file, Article article)
//          throws Exception {
//
//    Article oldArticle = articleService.getArticle(article.getArt_id());
//    oldArticle.setArt_title(article.getArt_title());
//    oldArticle.setArt_text(article.getArt_text());
//    oldArticle.setArt_type(article.getArt_type());
//
//    if (!file.isEmpty()) {
//      System.out.println("file is not null");
//      oldArticle.setArt_img(file.getBytes());
//    }
//
//    articleService.updateArticle(oldArticle);
//
//    return "redirect:/";
//  }

}
