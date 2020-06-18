package com.tf.articlemodule.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tf.articlemodule.bean.Article;
import com.tf.articlemodule.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/tofel-article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    private Gson gson;

    @Autowired
    public void setGson(Gson gson) {
        this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    }

    @RequestMapping(value = "/createArticle")
    public String create(
            @RequestParam("artImgUpload") MultipartFile file, Article article) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //article.setArt_date_time(df.format(new Date()));
        if (file != null) {
            System.out.println("file is not null");
            //article.setArt_img(file.getBytes());
        }
        articleService.addArticle(article);
        return gson.toJson(article);
    }

    @RequestMapping("/classArticle/{artType}")
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

    @GetMapping("/random-article")
    public String randomArticle() {
        int articleNumber = articleService.countArticle();
        int[] numbers = new int[articleNumber];
        for (int i = 0; i < articleNumber; i++) {
            numbers[i] = i + 1;
        }
        Random random = new Random();
        for (int i = articleNumber - 1; i > 0; i--) {
            int index = random.nextInt(i);
            int k = numbers[i];
            numbers[i] = numbers[index];
            numbers[index] = k;
        }
        List<Article> articles = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            articles.add(articleService.getArticle(String.valueOf(numbers[i])));
        }
        return gson.toJson(articles);
    }

    /**
     * 标题超过30个字就缩略
     * 不传输图片
     *
     * @param articles 文章列表
     */
    private void titleEllipsis(List<Article> articles) {
        for (Article article : articles) {
            if (article.getArt_title().length() >= 15) {
                article.setArt_title(article.getArt_title().substring(0, 15) + " ...");
                article.setArt_img(null);
            }
        }
    }

    /**
     * 托福人首页的六个文章推荐
     *
     * @return 六个文章列表
     */
    @RequestMapping("startpage")
    public String startpage() {
        List<Article> listen = articleService.selectByArtType("Listen");
        listen = listen.subList(0, Math.min(5, listen.size()));
        titleEllipsis(listen);

        List<Article> speak = articleService.selectByArtType("Speak");
        speak = speak.subList(0, Math.min(5, speak.size()));
        titleEllipsis(speak);

        List<Article> read = articleService.selectByArtType("Read");
        read = read.subList(0, Math.min(5, read.size()));
        titleEllipsis(read);

        List<Article> write = articleService.selectByArtType("Write");
        write = write.subList(0, Math.min(5, write.size()));
        titleEllipsis(write);

        List<Article> vocabulary = articleService.selectByArtType("Vocabulary");
        vocabulary = vocabulary.subList(0, Math.min(5, vocabulary.size()));
        titleEllipsis(vocabulary);

        List<Article> information = articleService.selectByArtType("Information");
        information = information.subList(0, Math.min(5, information.size()));
        titleEllipsis(information);

        Map<String, Object> map = new HashMap<>();
        map.put("Listen", listen);
        map.put("Speak", speak);
        map.put("Read", read);
        map.put("Write", write);
        map.put("Vocabulary", vocabulary);
        map.put("Information", information);
        return gson.toJson(map);
    }

    @RequestMapping("/getArtImg/{artId}")
    public String getArtImg(@PathVariable(value = "artId") String artId) {
        byte[] artImg = null;

        return gson.toJson(artImg);
    }

    @RequestMapping("/getArtInfo")
    public String getArticleInfo(@RequestParam("artId") String artId) {
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
