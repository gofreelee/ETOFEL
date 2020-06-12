package sichuan.umbrella.chenmm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sichuan.umbrella.chenmm.bean.CourseData;

@Component
public interface CourseDataMapper {

    /**
     * 按照课程资料的两个编号来查找资料
     * @param cdaId: 资料本身的编号
     * @param cdaCosId: 资料对应课程的编号
     * @return CourseData类型
     */
    CourseData selectCourseDataById(@Param("cdaId") int cdaId, @Param("cdaCosId") int cdaCosId);


}
