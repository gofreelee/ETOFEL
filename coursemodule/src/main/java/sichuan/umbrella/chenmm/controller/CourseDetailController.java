package sichuan.umbrella.chenmm.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sichuan.umbrella.chenmm.bean.CourseDetail;
import sichuan.umbrella.chenmm.service.CourseDetailService;

@RestController
public class CourseDetailController {
    private CourseDetailService courseDetailService;
    private Gson gson;

    @Autowired
    public void setCourseDetailService(CourseDetailService courseDetailService) {
        this.courseDetailService = courseDetailService;
    }

    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }

//    发布课程描述
    @GetMapping("/releaseCourseDetail")
    public String insertCourseDetailInfo(CourseDetail courseDetail) {
        boolean releaseSuccess = courseDetailService.insertCourseDetailInfo(courseDetail);
        if (releaseSuccess) return gson.toJson(courseDetail);
        else return null;
    }
}
