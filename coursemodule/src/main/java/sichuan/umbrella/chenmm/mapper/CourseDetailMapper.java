package sichuan.umbrella.chenmm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sichuan.umbrella.chenmm.bean.CourseDetail;

@Component
public interface CourseDetailMapper {
    //    发布课程-课程描述
    void insertCourseDetailInfo(@Param("courseDetail") CourseDetail courseDetail);
}
