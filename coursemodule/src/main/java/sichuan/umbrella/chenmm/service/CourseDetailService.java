package sichuan.umbrella.chenmm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sichuan.umbrella.chenmm.bean.CourseDetail;
import sichuan.umbrella.chenmm.mapper.CourseDetailMapper;

@Service
public class CourseDetailService {
    private CourseDetailMapper courseDetailMapper;

    @Autowired
    public void setCourseDetailMapper(CourseDetailMapper courseDetailMapper) {
        this.courseDetailMapper = courseDetailMapper;
    }

    //    发布课程-课程描述
    public boolean insertCourseDetailInfo(CourseDetail courseDetail) {
        courseDetailMapper.insertCourseDetailInfo(courseDetail);
        if (courseDetail.someValueNotNull()) {
            return true;
        } else {
            return false;
        }
    }
}
