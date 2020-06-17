package com.tf.articlemodule.service;

import com.tf.articlemodule.bean.Article;
import com.tf.articlemodule.mapper.ArticleDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

  @Autowired
  private ArticleDao articleDao;

  public Article getArticle(String artId) { return articleDao.selectByArtId(artId);  }

  public void addArticle(Article article) { articleDao.insert(article);  }

  public List<Article> selectAll() { return articleDao.selectAll();  }

  public void removeArticle(String artId) { articleDao.deleteByArtId(artId);  }

  public List<Article> selectByArtType(String artType) { return articleDao.selectByArtType(artType);  }
}
