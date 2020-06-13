package sichuan.umbrella.chenmm.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sichuan.umbrella.chenmm.bean.Course;
import sichuan.umbrella.chenmm.bean.CourseDetail;
import sichuan.umbrella.chenmm.service.CourseService;

import java.sql.Time;
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

    /**
     * 选择公益、热门、名师->听力、写作
     * @param type 课程大分类：公益0、热门1、名师2
     * @param cosCategory 课程分类：听力、写作……
     * @return json课程列表
     */
    @GetMapping("/welfareCastle")
    public String courseList(@RequestParam("type") int type, @RequestParam("cosCategory") String cosCategory) {
        List<Course> list = new ArrayList<>();
        switch (type) {
            case 0:
                list = courseService.selectActivityIsPublic(cosCategory);
                break;
            case 1:
                list = courseService.selectActivityIsHot(cosCategory);
                break;
            case 2:
                list = courseService.selectActivityIsFamousTeacher(cosCategory);
                break;
        }
        return gson.toJson(list);
    }

    /**
     * 发布课程-基本信息
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
     * 管理员功能——按照课程id关闭课程，调整课程状态为结课
     * @param cosId：课程的id
     * @return 返回JSON，为关闭成功提示
     */
    @GetMapping("/closeCourse")
    public String closeCourseById(@RequestParam("cosId") int cosId){
        courseService.closeCourseById(cosId);
        String result = "successfully closed course by id:" + cosId;
        return gson.toJson(result);
    }

    /**
     * 管理员功能——按照课程id恢复课程，根据当前日期和目标课程的开课日记做比较，调整课程状态为报名或者开课
     * @param cosId：课程id
     * @return Json
     * @throws Exception
     */
    @GetMapping("/recoverCourse")
    public String recoverCourseById(@RequestParam("cosId") int cosId)throws Exception{
        //获取想恢复的课程的开课日期
        Course course = courseService.selectCourseById(cosId);
        Date courseOpenDate = course.getCosStartDate();
        //获取当前的日期
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date nowDate = new Date(System.currentTimeMillis());
        String nowDateString = formatter.format(nowDate);
        nowDate = formatter.parse(nowDateString);
        String result;
        if(nowDate.compareTo(courseOpenDate) == -1){
            courseService.signUpCourseById(cosId);
            result = "课程状态改变成开课";
            return gson.toJson(result);
        }
        else {
            courseService.openCourseById(cosId);
            result = "课程状态改变成报名";
            return gson.toJson(result);
        }
    }
}
