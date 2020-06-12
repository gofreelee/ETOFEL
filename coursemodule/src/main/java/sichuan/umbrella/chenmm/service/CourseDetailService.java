package sichuan.umbrella.chenmm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sichuan.umbrella.chenmm.bean.CourseDetail;
import sichuan.umbrella.chenmm.mapper.CourseDetailMapper;

@Service
public class CourseDetailService {
    @Autowired
    private CourseDetailMapper courseDetailMapper;



    //    发布课程-课程描述
    public boolean insertCourseDetailInfo(CourseDetail courseDetail) {
        courseDetailMapper.insertCourseDetailInfo(courseDetail);
        if (courseDetail.someValueNotNull()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查找课程-根据课程详细id查找课程详细所有信息
     * @param cdtCosId：课程详细的id
     * @return CourseDetail的实例
     */
    public CourseDetail selectCourseDetailInfo(Integer cdtCosId){
        CourseDetail courseDetail = courseDetailMapper.selectCourseDetailInfo(cdtCosId);

        return courseDetail;
    }

    /**
     * 查找老师点赞数-根据课程详细的Id来查找该课程详细的教师点赞数
     * @param cdtCosId：课程详细的id
     * @return int类型的点赞数量
     */
    public int selectCourseDetailLikeNum(int cdtCosId){
        int likeNum = courseDetailMapper.selectCourseDetailLikeNum(cdtCosId);
        return likeNum;
    }
}
