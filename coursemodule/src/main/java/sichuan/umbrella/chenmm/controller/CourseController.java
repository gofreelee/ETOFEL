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

import java.util.ArrayList;
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

    //    选择公益、热门、名师->听力、写作
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

    //    发布课程-基本信息
    @GetMapping("/releaseCourse")
    public String insertCourseBasicInfo(Course course) {
        boolean releaseSuccess = courseService.insertCourseBasicInfo(course);
        if (releaseSuccess) return gson.toJson(course);
        else return null;
    }

    //    按照时间从早到晚给课程排序
    @GetMapping("/sortByTime")
    public String selectCourseByTime(@RequestParam("cosStartDate") String cosStartDate, @RequestParam("cosStartTime") String cosStartTime) {
        List<Course> list = courseService.selectCourseByTime(cosStartDate, cosStartTime);
        return gson.toJson(list);
    }


    //    计算课程的参加人数
    @GetMapping("/countCourseJoin")
    public String countCourseJoin(@RequestParam("ujcCosId") Integer ujcCosId) {
        int countJoin = courseService.countCourseJoin(ujcCosId);
        return gson.toJson(countJoin);
    }
}
