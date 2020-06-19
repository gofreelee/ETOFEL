package com.tf.articlemodule.mapper;

import com.tf.articlemodule.bean.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {

    @Select("select * from article_comment where cmt_id = #{param1}")
    Comment selectByCommentId(String cmtId);

    @Select("select * from article_comment")
    List<Comment> selectAll();

    @Select("select * from article_comment where cmt_art_id=#{param1} order by cmt_date_time desc")
    List<Comment> selectByArtId(String cmtArtId);

    @Insert("insert into article_comment(cmt_username,cmt_art_id,cmt_date_time,cmt_content) values(#{comment.cmt_username},#{comment.cmt_art_id},#{comment.cmt_date_time},#{comment.cmt_content})")
    void insert(@Param("comment") Comment comment);

    @Delete("delete from article_comment where cmt_id=#{param1}")
    void deleteByCmtId(String cmtId);


}
