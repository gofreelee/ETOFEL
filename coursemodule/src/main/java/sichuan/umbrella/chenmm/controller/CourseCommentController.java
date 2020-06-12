package sichuan.umbrella.chenmm.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sichuan.umbrella.chenmm.bean.Course;
import sichuan.umbrella.chenmm.bean.CourseComment;
import sichuan.umbrella.chenmm.service.CourseCommentService;

import java.util.List;

@RestController
@RequestMapping("/courseComment")
public class CourseCommentController {

    @Autowired
    private CourseCommentService courseCommentService;

    private Gson gson;

    @Autowired
    public void setCourseCommentService(CourseCommentService courseCommentService) {
        this.courseCommentService = courseCommentService;
    }

    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }

    @GetMapping("/insertCourseComment")
    public String insertCourseComment(CourseComment courseComment){
        boolean insertCourseCommentSucc = courseCommentService.insertCourseDetailComment(courseComment);

        if(insertCourseCommentSucc) return gson.toJson(courseComment);
        else return null;
    }

    @GetMapping("/getAllCourseComment")
    public String getAllCourseComment(int ccmtCosDetailId){
        List<CourseComment> courseComments = courseCommentService.selectAllCourseDetailCommentById(ccmtCosDetailId);
        return gson.toJson(courseComments);
    }



}
