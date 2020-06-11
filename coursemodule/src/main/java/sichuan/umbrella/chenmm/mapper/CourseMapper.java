package sichuan.umbrella.chenmm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sichuan.umbrella.chenmm.bean.Course;

import java.util.List;

@Component
public interface CourseMapper {
//    选择课程类型（公益、热门、名师）
    List<Course> selectActivityIsPublic(@Param("cos_category") String cosCategory);
    List<Course> selectActivityIsHot(@Param("cos_category") String cosCategory);
    List<Course> selectActivityIsFamousTeacher(@Param("cos_category") String cosCategory);

//    发布课程--基本信息
    void insertCourseBasicInfo(@Param("course") Course course);

//    课程列表页按照时间排序
    List<Course> selectCourseByTime(@Param("cos_start_date") String cosStartDate, @Param("cos_start_time") String cosStartTime);

}
