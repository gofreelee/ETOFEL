package sichuan.umbrella.chenmm.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sichuan.umbrella.chenmm.bean.Course;
import sichuan.umbrella.chenmm.bean.UserJoinCourse;
import sichuan.umbrella.chenmm.mapper.UserJoinCourseMapper;

import java.util.List;

@Service
public class UserJoinCourseService {
    private UserJoinCourseMapper userJoinCourseMapper;

    @Autowired
    public void setUserJoinCourseMapper(UserJoinCourseMapper userJoinCourseMapper) {
        this.userJoinCourseMapper = userJoinCourseMapper;
    }

    /**
     * 计算课程的参加人数
     *
     * @param ujcCosId 用户参加的课程id
     * @return 参加该课程的人数
     */
    public int countCourseJoin(Integer ujcCosId) {
        return userJoinCourseMapper.countCourseJoin(ujcCosId);
    }


    /**
     * 用户提交课程订单信息，插入一条未支付数据
     *
     * @param ujcCosId       课程id
     * @param ujcUsrUsername 用户名
     * @return 提交订单是否成功
     */
    public boolean insertUserUnpaidOrder(Integer ujcCosId, String ujcUsrUsername) {
        userJoinCourseMapper.insertUserUnpaidOrder(ujcCosId, ujcUsrUsername);
        return ujcCosId != null && ujcUsrUsername != null;
    }

    /**
     * 当用户成功支付，更新用户支付状态为“已支付”
     *
     * @param ujcCosId       课程id
     * @param ujcUsrUsername 用户名
     */
    public void updateUserStatusToPaid(Integer ujcCosId, String ujcUsrUsername) {
        userJoinCourseMapper.updateUserStatusToPaid(ujcCosId, ujcUsrUsername);
    }


    /**
     * 查询用户加入的课程
     *
     * @param ujcUsrUsername 用户名
     * @return 课程列表
     */
    public List<Course> getJoinedCourse(String ujcUsrUsername) {
        return userJoinCourseMapper.getJoinedCourse(ujcUsrUsername);
    }

    /**
     * 查询用户的付款情况
     *
     * @param ujcCosId       课程id
     * @param ujcUsrUsername 用户名
     * @return UserJoinCourse实体类
     */
    public UserJoinCourse getJoinedStatus(@Param("ujc_cos_id") Integer ujcCosId, @Param("ujc_usr_username") String ujcUsrUsername) {
        return userJoinCourseMapper.getJoinedStatus(ujcCosId, ujcUsrUsername);
    }
}
