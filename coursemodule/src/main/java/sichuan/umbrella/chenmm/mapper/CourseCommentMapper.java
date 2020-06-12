package sichuan.umbrella.chenmm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sichuan.umbrella.chenmm.bean.CourseComment;

@Component
public interface CourseCommentMapper {

    /**
     * 添加课程详细页面的课程评价
     * @param courseComment：评价的实例
     */
    void insertCourseDetailComment(@Param("courseComment") CourseComment courseComment);

}
