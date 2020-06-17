package com.tf.articlemodule.mapper;

import com.tf.articlemodule.bean.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao{

    @Select("select * from article where art_id = #{artId}")
    Article selectByArtId(String artId);

    @Select("select * from article")
    List<Article> selectAll();

    @Select("select * from article where art_type=#{artType}")
    List<Article> selectByArtType(String artType);

    @Insert("insert into article(art_id,art_username,art_title,art_date,art_img,art_text,art_type) values(#{artId},#{artUsername},#{artTitle},#{artDate},#{artImg},#{artText},#{artType})")
    void insert(Article article);

    @Delete("delete from article where art_id=#{artId}")
    void deleteByArtId(String artId);

}
