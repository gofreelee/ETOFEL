package sichuan.umbrella.chenmm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sichuan.umbrella.chenmm.bean.Course;
import sichuan.umbrella.chenmm.mapper.CourseMapper;

import java.util.List;

@Service
public class CourseService {
    private CourseMapper courseMapper;

    @Autowired
    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    //课程选择为公益课程
    public List<Course> selectActivityIsPublic(String cosCategory) {
        return courseMapper.selectActivityIsPublic(cosCategory);
    }

    //课程选择为热门课程
    public List<Course> selectActivityIsHot(String cosCategory) {
        return courseMapper.selectActivityIsHot(cosCategory);
    }

    //课程选择为名师精品课程
    public List<Course> selectActivityIsFamousTeacher(String cosCategory) {
        return courseMapper.selectActivityIsFamousTeacher(cosCategory);
    }

    //    发布课程--基本信息
    public boolean insertCourseBasicInfo(Course course) {
        courseMapper.insertCourseBasicInfo(course);
        return course.noNullValue();
    }

    //按时间从早到晚给课程排序
    public List<Course> selectCourseByTime(String cosStartDate, String cosStartTime) {
        return courseMapper.selectCourseByTime("cosStartDate", "cosStartTime");
    }

    //    按课程老师的点赞数给课程排序
    public List<Course> selectCourseByLike() {
        return courseMapper.selectCourseByLike();
    }
}
