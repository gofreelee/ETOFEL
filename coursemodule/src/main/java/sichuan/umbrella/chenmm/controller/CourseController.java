package sichuan.umbrella.chenmm.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sichuan.umbrella.chenmm.bean.Course;
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

    @GetMapping("/welfareCastle")
    public String courseList(@RequestParam("type")int type, @RequestParam("cosCategory")String cosCategory) {
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
    public String insertCourseBasicInfo(Course course){
        boolean releaseSuccess=courseService.insertCourseBasicInfo(course);
        if (releaseSuccess) return gson.toJson(course);
        else return null;
    }
}
