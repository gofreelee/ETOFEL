package sichuan.umbrella.chenmm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sichuan.umbrella.chenmm.bean.Course;

import java.util.List;

@Component
public interface CourseMapper {
    /**
     * 选择课程类型（公益、热门、名师）
     * @param cosCategory 课程类型：听力、写作……
     * @return 满足条件的课程列表
     */
    List<Course> selectActivityIsPublic(@Param("cos_category") String cosCategory);
    List<Course> selectActivityIsHot(@Param("cos_category") String cosCategory);
    List<Course> selectActivityIsFamousTeacher(@Param("cos_category") String cosCategory);

    /**
     * 发布课程--基本信息
     * @param course 课程
     */
    void insertCourseBasicInfo(@Param("course") Course course);

    /**
     * 课程列表页按照时间排序
     * @param cosStartDate 课程开始日期2020-06-13
     * @param cosStartTime 课程开始上课时间10:30
     * @return 排序后的课程列表
     */
    List<Course> selectCourseByTime(@Param("cos_start_date") String cosStartDate, @Param("cos_start_time") String cosStartTime);

    List<Course> selectCourseByUser(@Param("usr_username") String usr_username);
    List<Course> selectCourseByTeacher(@Param("tch_username") String tch_username);
}

