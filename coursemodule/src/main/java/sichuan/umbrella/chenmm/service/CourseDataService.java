package sichuan.umbrella.chenmm.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sichuan.umbrella.chenmm.bean.CourseData;
import sichuan.umbrella.chenmm.mapper.CourseDataMapper;

@Service
public class CourseDataService {

    @Autowired
    private CourseDataMapper courseDataMapper;

    public CourseData selectCourseDataById(int cdaId,int cdaCosId){
        CourseData courseData = courseDataMapper.selectCourseDataById(cdaId,cdaCosId);
        return  courseData;
    }
}
