package com.tf.articlemodule;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.tf.articlemodule.mapper")
public class ArticlemoduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticlemoduleApplication.class, args);
    }

}
