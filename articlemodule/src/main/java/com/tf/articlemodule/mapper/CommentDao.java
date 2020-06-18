package com.tf.articlemodule.mapper;

import com.tf.articlemodule.bean.Comment;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao{

    @Select("select * from article_comment where cmt_id = #{param1}")
    Comment selectByCommentId(String cmtId);

    @Select("select * from article_comment")
    List<Comment> selectAll();

    @Select("select * from article_comment where cmt_art_id=#{param1}")
    List<Comment> selectByArtId(String cmtArtId);

    @Insert("insert into article_comment(cmt_id,cmt_username,cmt_art_id,cmt_date_time,cmt_content) values(#{comment.cmtId},#{comment.cmtUsername},#{comment.cmtArtId},#{comment.cmtDateTime},#{comment.cmtContent})")
    void insert(Comment comment);

    @Delete("delete from article_comment where cmt_id=#{param1}")
    void deleteByCmtId(String cmtId);


}
