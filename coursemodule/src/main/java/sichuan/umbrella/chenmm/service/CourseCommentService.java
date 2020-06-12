package sichuan.umbrella.chenmm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sichuan.umbrella.chenmm.bean.CourseComment;
import sichuan.umbrella.chenmm.mapper.CourseCommentMapper;

import java.util.List;

@Service
public class CourseCommentService {

    @Autowired
    private CourseCommentMapper courseCommentMapper;

    /**
     * 插入课程详细页的评论信息
     * @param courseComment：课程评论实例
     * @return 返回boolean，判断评论是否为空
     */
    public boolean insertCourseDetailComment(CourseComment courseComment){
        courseCommentMapper.insertCourseDetailComment(courseComment);
        return courseComment.noNullValue();
    }

    /**
     * 根据课程详细的id查找其所有评论
     * @param ccmtCosDetailId：课程详细的id
     * @return CourseComment的List集合
     */
    public List<CourseComment> selectAllCourseDetailCommentById(int ccmtCosDetailId){
        List<CourseComment> courseComments = courseCommentMapper.selectCourseDetailCommentById(ccmtCosDetailId);
        return courseComments;
    }


}
