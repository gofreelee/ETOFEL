package sichuan.umbrella.chenmm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sichuan.umbrella.chenmm.bean.CourseComment;

import java.util.List;

@Component
public interface CourseCommentMapper {

    /**
     * 添加课程详细页面的课程评价
     * @param courseComment：评价的实例
     */
    void insertCourseDetailComment(@Param("courseComment") CourseComment courseComment);

    /**
     * 根据课程详细的id查找对应课程的全部评论
     * @param ccmtCosDetailId：课程详细页的id
     * @return 返回CourseComment的List集合
     */
    List<CourseComment> selectCourseDetailCommentById(@Param("ccmtCosDetailId") int ccmtCosDetailId);

}
