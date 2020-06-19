
package sichuan.umbrella.chenmm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sichuan.umbrella.chenmm.bean.Course;
import sichuan.umbrella.chenmm.bean.CourseWithTeacher;

import java.util.List;

@Component
public interface CourseMapper {
    /**
     * 选择课程类型（公益、热门、名师）
     *
     * @param cosCategory 课程类型：听力、写作……
     * @return 满足条件的课程列表
     */
    List<Course> selectActivityIsPublic(@Param("cos_category") String cosCategory);

    List<Course> selectActivityIsHot(@Param("cos_category") String cosCategory);

    List<Course> selectActivityIsFamousTeacher(@Param("cos_category") String cosCategory);

    List<Course> selectCourseByCategory(@Param("cos_category") String cosCategory);

    /**
     * 发布课程--基本信息
     *
     * @param course 课程
     */
    void insertCourseBasicInfo(@Param("course") Course course);

    /**
     * 课程列表页按照时间排序
     *
     * @param cosStartDate 课程开始日期2020-06-13
     * @param cosStartTime 课程开始上课时间10:30
     * @return 排序后的课程列表
     */
    List<Course> selectCourseByTime(@Param("cos_start_date") String cosStartDate, @Param("cos_start_time") String cosStartTime);

    /**
     * 管理员课程列表页动态查询课程
     *
     * @param cosTitle       课程名称
     * @param cosCategory    课程种类：写作、听力……
     * @param cdtTchUsername 该课的老师
     * @return 查询到的课程列表
     */
    List<Course> selectCourseDynamic(@Param("cos_title") String cosTitle, @Param("cos_category") String cosCategory, @Param("cdt_tch_username") String cdtTchUsername);

    /**
     * 管理员关闭课程——按照课程的id——cos_id将课程状态更改成"停课"
     *
     * @param cosId: 课程号cos_id
     */
    void updateCourseToClose(@Param("cosId") int cosId);

    /**
     * 管理员恢复课程至开课——按照课程的id——cos_id将课程状态更改成"开课"
     *
     * @param cosId：课程号cos_id
     */
    void updateCourseToOpen(@Param("cosId") int cosId);

    /**
     * 管理员恢复课程至开课——按照课程的id——cos_id将课程状态更改成"报名"
     *
     * @param cosId：课程号cos_id
     */
    void updateCourseToSignUp(@Param("cosId") int cosId);

    /**
     * 按照课程id来查询课程信息
     *
     * @param cosId：课程id
     */
    Course selectCourseById(@Param("cosId") Integer cosId);

    /***
     *
     * 管理员获取所有课程
     */
    List<CourseWithTeacher> selectAllCourseInfo();
    List<Integer> selectAllCourseId();
}

