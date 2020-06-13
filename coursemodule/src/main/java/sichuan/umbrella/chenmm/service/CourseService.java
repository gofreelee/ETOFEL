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

    /**
     * 课程选择为公益课程(免费课程)
     * @param cosCategory 课程类型：听力、写作……
     * @return 满足选项的课程列表
     */
    public List<Course> selectActivityIsPublic(String cosCategory) {
        return courseMapper.selectActivityIsPublic(cosCategory);
    }

    /**
     * 课程选择为热门课程
     * @param cosCategory 课程种类
     * @return 满足选项的课程列表
     */
    public List<Course> selectActivityIsHot(String cosCategory) {
        return courseMapper.selectActivityIsHot(cosCategory);
    }

    /**
     * 课程选择为名师精品课程
     * @param cosCategory 课程种类
     * @return 满足选项的课程列表
     */
    public List<Course> selectActivityIsFamousTeacher(String cosCategory) {
        return courseMapper.selectActivityIsFamousTeacher(cosCategory);
    }

    /**
     * 发布课程--基本信息
     * @param course 课程类
     * @return boolean类型
     */
    public boolean insertCourseBasicInfo(Course course) {
        courseMapper.insertCourseBasicInfo(course);
        return course.noNullValue();
    }

    /**
     * 按时间从早到晚给课程排序
     * @param cosStartDate 开始日期2020-06-13
     * @param cosStartTime 开始时间10:30
     * @return 排序后的课程列表
     */
    public List<Course> selectCourseByTime(String cosStartDate, String cosStartTime) {
        return courseMapper.selectCourseByTime("cosStartDate", "cosStartTime");
    }

    /*查询个人的课程*/
    public List<Course> selectCourseByUser(String usr_username){
        return courseMapper.selectCourseByUser(usr_username);
    }
    /*查询老师的课程*/
    public List<Course> selectCourseByTeacher(String tch_username){
        return courseMapper.selectCourseByTeacher(tch_username);
    }
}
