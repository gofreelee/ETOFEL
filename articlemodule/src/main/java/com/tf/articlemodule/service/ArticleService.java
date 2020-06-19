package com.tf.articlemodule.service;

import com.tf.articlemodule.bean.Article;
import com.tf.articlemodule.mapper.ArticleDao;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public Article getArticle(String artId) {
        return articleDao.selectByArtId(artId);
    }

    public void addArticle(Article article) {
        articleDao.insert(article);
    }

    public List<Article> selectAll() {
        return articleDao.selectAll();
    }

    public void removeArticle(String artId) {
        articleDao.deleteByArtId(artId);
    }

    public List<Article> selectByArtType(String artType) {
        return articleDao.selectByArtType(artType);
    }

    public void modifyArticle(Article article) {
        articleDao.modifyArticle(article);
    }

    public List<Article> randomArticle(int need) {
        List<Integer> ids = articleDao.selectAllArtId();
        Random random = new Random();
        int range = random.nextInt(ids.size());
        for (int i = range; i > 0; i--) {
            int index = random.nextInt(i);
            int k = ids.get(index);
            ids.set(index, ids.get(i));
            ids.set(i, k);
        }
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < need; i++) {
            articles.add(articleDao.selectByArtId(String.valueOf(ids.get(i))));
        }
        return articles;
    }

    public List<Article> selectByArtUsername(String artUsername) {
        return articleDao.selectByArtUsername(artUsername);
    }

    public List<Article> selectLike(@Param("ulaUsername") String ulaUsername) {
        return articleDao.selectLike(ulaUsername);
    }
}
