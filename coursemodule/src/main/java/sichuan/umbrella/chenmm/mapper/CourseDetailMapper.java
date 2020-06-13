package sichuan.umbrella.chenmm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sichuan.umbrella.chenmm.bean.CourseDetail;
import sichuan.umbrella.chenmm.bean.Teacher;

@Component
public interface CourseDetailMapper {
    /**
     * 发布课程-课程描述
     * @param courseDetail: 要插入的课程描述的信息
     */
    void insertCourseDetailInfo(@Param("courseDetail") CourseDetail courseDetail);

    /**
     * 查找课程-课程详细信息
     * @param cdtCosId: 课程详细页面的id
     * @return CourseDetail类型
     */
    CourseDetail selectCourseDetailInfo(@Param("cdtCosId") int cdtCosId);

    /**
     * 查找课程详细页面的老师点赞数量
     * @param cdtCosId：课程详细的id
     * @return 返回int类型的点赞数量
     */
    int selectCourseDetailLikeNum(@Param("cdtCosId") int cdtCosId);

    /**
     * 查找课程详细页面的教师信息
     * @param cdtCosId: 课程详细的id
     * @return 返回Teacher类型的实例
     */
    Teacher selectCourseDetailTeacher(@Param("cdtCosId") int cdtCosId);
}
