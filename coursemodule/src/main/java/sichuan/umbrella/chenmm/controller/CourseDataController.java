package sichuan.umbrella.chenmm.controller;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sichuan.umbrella.chenmm.bean.CourseData;
import sichuan.umbrella.chenmm.mapper.CourseDataMapper;
import sichuan.umbrella.chenmm.service.CourseDataService;


@RestController
@RequestMapping("/courseData")
public class CourseDataController {

    @Autowired
    private CourseDataService courseDataService;

    private Gson gson;

    public void setCourseDataService(CourseDataService courseDataService){
        this.courseDataService = courseDataService;
    }
    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }

    /**
     * 根据课程资料的id和对应课程的id来查找下载资源的uri
     * @param cdaId：课程资料本身的id
     * @param cdaCosId：对应的课程的id
     * @return 返回json格式，包含Coursedata的全部内容
     */
    @RequestMapping("/getCourseData")
    public String selectCourseDataById(@RequestParam("cdaId") int cdaId,@RequestParam("cdaCosId") int cdaCosId){
        CourseData courseData = courseDataService.selectCourseDataById(cdaId,cdaCosId);
        if(courseData == null){
            return null;
        }
        else {
            System.out.println("find course data successfully!\n " + courseData);
            return gson.toJson(courseData);
        }
    }



}
