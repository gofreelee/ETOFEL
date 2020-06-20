package sichuan.umbrella.chenmm.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sichuan.umbrella.chenmm.bean.CourseDetail;
import sichuan.umbrella.chenmm.bean.Teacher;
import sichuan.umbrella.chenmm.serializer.CourseDetailSerializer;
import sichuan.umbrella.chenmm.service.CourseDetailService;

@RestController
@RequestMapping("/courseDetail")
public class CourseDetailController {
    @Autowired
    private CourseDetailService courseDetailService;

    private Gson gson;

    @Autowired
    public void setCourseDetailService(CourseDetailService courseDetailService) {
        this.courseDetailService = courseDetailService;
    }

    @Autowired
    public void setGson() {
        this.gson = new GsonBuilder().registerTypeAdapter(CourseDetail.class, new CourseDetailSerializer()).create();
    }

    /**
     * 发布课程描述
     *
     * @param courseDetail CourseDetail类
     * @return json
     */
    @GetMapping("/releaseCourseDetail")
    public String insertCourseDetailInfo(CourseDetail courseDetail) {
        boolean releaseSuccess = courseDetailService.insertCourseDetailInfo(courseDetail);
        if (releaseSuccess) return new Gson().toJson(courseDetail);
        else return null;
    }

    /**
     * 获取课程的详细页面信息
     *
     * @param cdtCosId：课程详细的id号
     * @return 返回的是json格式，包含课程详细页的全部信息
     */
    @GetMapping("/getCourseDetail")
    public String selectCourseDetailInfo(@RequestParam("cdtCosId") int cdtCosId) {
//            System.out.println(courseDetailService == null);
        CourseDetail courseDetail = courseDetailService.selectCourseDetailInfo(cdtCosId);
        return gson.toJson(courseDetail);
    }

    /**
     * 获取课程详细页面的教师点赞数量
     *
     * @param cdtCosId：课程详细的id号
     * @return 返回的是Json格式，包含课程详细页的教师点赞数量
     */
    @GetMapping("/getCourseDetailLikeNum")
    public String selectCourseDetailLikeNum(@RequestParam("cdtCosId") int cdtCosId) {
        int likeNum = courseDetailService.selectCourseDetailLikeNum(cdtCosId);
        return gson.toJson(likeNum);
    }

    /**
     * 获取课程详细页面的教师详细信息
     *
     * @param cdtCosId：课程详细的Id
     * @return 返回的是Json格式，包含教师详细信息
     */
    @GetMapping("/getCourseDetailTeacherInfo")
    public String selectCourseDetailTeacherInfo(@RequestParam("cdtCosId") int cdtCosId) {
        Teacher teacher = courseDetailService.selectCourseDetailTeacher(cdtCosId);
        return gson.toJson(teacher);
    }
}
