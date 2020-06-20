package com.tf.articlemodule.mapper;

import com.tf.articlemodule.bean.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {

    @Select("select * from article where art_id = #{artId}")
    Article selectByArtId(long artId);

    @Select("select * from article")
    List<Article> selectAll();

    @Select("select * from article where art_type=#{artType}")
    List<Article> selectByArtType(String artType);

    @Insert("insert into article(art_id,art_username,art_title,art_date,art_img,art_text,art_type) values(#{art_id},#{art_username},#{art_title},#{art_date_time},#{art_img},#{art_text},#{art_type})")
    void insert(Article article);

    @Delete("delete from article where art_id=#{artId}")
    void deleteByArtId(long artId);

    @Update("update article set art_username=#{art_username} ,art_title=#{art_title}, art_date=#{art_date}, art_img=#{art_img}, art_text=#{art_img}, art_type=#{art_type} where art_id = #{art_id}")
    void modifyArticle(Article article);

    @Select("select art_id from article")
    List<Integer> selectAllArtId();

    @Select("select * from article where art_username = #{artUsername}")
    List<Article> selectByArtUsername(@Param("artUsername") String artUsername);

    @Select("select * from article,user_like_article where art_id = ula_art_id and ula_username = #{ulaUsername}")
    List<Article> selectLike(@Param("ulaUsername") String ulaUsername);

    List<Article> managerSearchArticle(@Param("artTitle")String artTitle, @Param("artUsername")String artUsername);

}
