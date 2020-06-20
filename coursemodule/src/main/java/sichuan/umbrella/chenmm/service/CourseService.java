
package sichuan.umbrella.chenmm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sichuan.umbrella.chenmm.bean.Course;
import sichuan.umbrella.chenmm.bean.CourseWithTeacher;
import sichuan.umbrella.chenmm.mapper.CourseMapper;

import java.util.List;
import java.util.Random;

@Service
public class CourseService {
    private CourseMapper courseMapper;

    @Autowired
    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    /**
     * 根据类型查课
     *
     * @param cosCategory 听力、阅读
     * @return 列表
     */
    public List<Course> selectCourseByCategory(String cosCategory) {
        return courseMapper.selectCourseByCategory(cosCategory);
    }

    /**
     * 课程选择为公益课程(免费课程)
     *
     * @param cosCategory 课程类型：听力、写作……
     * @return 满足选项的课程列表
     */
    public List<Course> selectActivityIsPublic(String cosCategory) {
        return courseMapper.selectActivityIsPublic(cosCategory);
    }

    /**
     * 课程选择为热门课程
     *
     * @param cosCategory 课程种类
     * @return 满足选项的课程列表
     */
    public List<Course> selectActivityIsHot(String cosCategory) {
        return courseMapper.selectActivityIsHot(cosCategory);
    }

    /**
     * 课程选择为名师精品课程
     *
     * @param cosCategory 课程种类
     * @return 满足选项的课程列表
     */
    public List<Course> selectActivityIsFamousTeacher(String cosCategory) {
        return courseMapper.selectActivityIsFamousTeacher(cosCategory);
    }

    /**
     * 发布课程--基本信息
     *
     * @param course 课程类
     * @return boolean类型
     */
    public boolean insertCourseBasicInfo(Course course) {
        courseMapper.insertCourseBasicInfo(course);
        return course.noNullValue();
    }

    /**
     * 按时间从早到晚给课程排序
     *
     * @param cosStartDate 开始日期2020-06-13
     * @param cosStartTime 开始时间10:30
     * @return 排序后的课程列表
     */
    public List<Course> selectCourseByTime(String cosStartDate, String cosStartTime) {
        return courseMapper.selectCourseByTime("cosStartDate", "cosStartTime");
    }

    /**
     * 管理员课程列表页动态查询课程
     *
     * @param cosTitle       课程名称
     * @param cosCategory    课程种类：听力、写作……
     * @param cdtTchUsername 该课的老师
     * @return 查询的list列表
     */
    public List<Course> selectCourseDynamic(String cosTitle, String cosCategory, String cdtTchUsername) {
        if (cosTitle != null) cosTitle = "%" + cosTitle + "%";
        if (cosCategory != null) cosCategory = "%" + cosCategory + "%";
        if (cdtTchUsername != null) cdtTchUsername = "%" + cdtTchUsername + "%";
        return courseMapper.selectCourseDynamic(cosTitle, cosCategory, cdtTchUsername);
    }

    /**
     * 管理员功能——按照课程号cos_id将课程状态调整为"停课"
     *
     * @param cosId 课程id
     */
    public void closeCourseById(int cosId) {
        courseMapper.updateCourseToClose(cosId);
    }

    /**
     * 管理员功能——按照课程号cos_id将课程状态调整为"开课"
     *
     * @param cosId 课程id
     */
    public void openCourseById(int cosId) {
        courseMapper.updateCourseToOpen(cosId);
    }

    /**
     * 管理员功能——按照课程号cos_id将课程状态调整为"报名"
     *
     * @param cosId 课程id
     */
    public void signUpCourseById(int cosId) {
        courseMapper.updateCourseToSignUp(cosId);
    }

    /**
     * 根据课程id查找课程信息
     *
     * @param cosId 课程id
     * @return 课程实体类
     */
    public Course selectCourseById(Integer cosId) {
        return courseMapper.selectCourseById(cosId);
    }

    public List<CourseWithTeacher> selectAllCourseInfo() {
        return courseMapper.selectAllCourseInfo();
    }

    /**
     * 随机选取need个课程的id进行推荐
     *
     * @param need 需要的数量
     * @return id列表
     */
    public List<Integer> randomCourseId(int need) {
        List<Integer> ids = courseMapper.selectAllCourseId();
        Random random = new Random();
        int range = random.nextInt(ids.size());
        for (int i = range; i > 0; i--) {
            int index = random.nextInt(i);
            int k = ids.get(index);
            ids.set(index, ids.get(i));
            ids.set(i, k);
        }
        return ids.subList(0, need);
    }

    /**
     * 获取所有课程的id
     *
     * @return 课程id列表
     */
    public List<Integer> selectAllCourseId() {
        return courseMapper.selectAllCourseId();
    }
}
