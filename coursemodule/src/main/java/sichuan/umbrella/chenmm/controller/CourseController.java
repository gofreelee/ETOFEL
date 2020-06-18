
package sichuan.umbrella.chenmm.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sichuan.umbrella.chenmm.bean.Course;
import sichuan.umbrella.chenmm.bean.CourseDetail;
import sichuan.umbrella.chenmm.bean.CourseWithTeacher;
import sichuan.umbrella.chenmm.service.CourseService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseService courseService;
    private Gson gson;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }

    @GetMapping("/getCourseByCosId")
    public String courseById(@RequestParam("cosId") Integer cosId) {
        return gson.toJson(courseService.selectCourseById(cosId));
    }

    /**
     * 选择公益、热门、名师->听力、写作
     *
     * @param type        课程大分类：公益0、热门1、名师2
     * @param cosCategory 课程分类：听力、写作……
     * @return json课程列表
     */
    @GetMapping("/welfareCastle")
    public String courseList(Integer type, String cosCategory) {
        if (cosCategory == null || cosCategory.equals("全部")) cosCategory = null;
        List<Course> list;
        if (type == 0) {
            list = courseService.selectActivityIsPublic(cosCategory);
        } else if (type == 1) {
            list = courseService.selectActivityIsHot(cosCategory);
        } else if (type == 2) {
            list = courseService.selectActivityIsFamousTeacher(cosCategory);
        } else {
            list = courseService.selectCourseByCategory(cosCategory);
        }
        return gson.toJson(list);
    }

    /**
     * 发布课程-基本信息
     *
     * @param course 课程类
     * @return 添加的课程json
     */
    @GetMapping("/releaseCourse")
    public String insertCourseBasicInfo(Course course) {
        boolean releaseSuccess = courseService.insertCourseBasicInfo(course);
        if (releaseSuccess) return gson.toJson(course);
        else return null;
    }

    /**
     * 按照时间从早到晚给课程排序
     *
     * @param cosStartDate 开始日期2020-06-13
     * @param cosStartTime 开始时间10:30
     * @return 排序后的课程json
     */
    @GetMapping("/sortByTime")
    public String selectCourseByTime(@RequestParam("cosStartDate") String cosStartDate, @RequestParam("cosStartTime") String cosStartTime) {
        List<Course> list = courseService.selectCourseByTime(cosStartDate, cosStartTime);
        return gson.toJson(list);
    }

    /**
     * 管理员课程列表页动态查询课程
     *
     * @param cosTitle       课程名称
     * @param cosCategory    课程种类：写作、听力……
     * @param cdtTchUsername 该课教室名字
     * @return json
     */
    @GetMapping("/selectCourseDynamic")
    public String selectCourseDynamic(String cosTitle, String cosCategory, String cdtTchUsername) {
        List<Course> list = courseService.selectCourseDynamic(cosTitle, cosCategory, cdtTchUsername);
        return gson.toJson(list);
    }

    /**
     * 管理员功能——按照课程id恢复课程，根据当前日期和目标课程的开课日记做比较，调整课程状态为报名或者开课
     *
     * @param cosId：课程id
     * @return Json
     * @throws ParseException 日期parse异常
     */
    @GetMapping("/recoverCourse")
    public String recoverCourseById(@RequestParam("cosId") int cosId) throws ParseException {
        //获取想恢复的课程的开课日期
        Course course = courseService.selectCourseById(cosId);
        Date courseOpenDate = course.getCosStartDate();
        //获取当前的日期
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date nowDate = new Date(System.currentTimeMillis());
        String nowDateString = formatter.format(nowDate);
        nowDate = formatter.parse(nowDateString);
        String result;
        if (nowDate.compareTo(courseOpenDate) < 0) {
            courseService.signUpCourseById(cosId);
            result = "课程状态改变成开课";
            return gson.toJson(result);
        } else {
            courseService.openCourseById(cosId);
            result = "课程状态改变成报名";
            return gson.toJson(result);
        }
    }

    @RequestMapping("/getAllCourseInfo")
    public List<CourseWithTeacher> getAllCourseInfo() {
        return courseService.selectAllCourseInfo();
    }

}
