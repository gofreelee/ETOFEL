package com.tf.articlemodule;

import com.tf.articlemodule.bean.Article;
import com.tf.articlemodule.service.ArticleService;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ArticlemoduleApplicationTests {

    @Autowired
    private ArticleService as;

    @Test
    void contextLoads() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
        System.out.println(df.format(new Date()));
    }


}
