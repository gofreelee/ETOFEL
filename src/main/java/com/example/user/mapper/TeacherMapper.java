package com.example.user.mapper;

import com.example.user.bean.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    // 获取教师信息
    Teacher getTeacherByUsername(String tch_username);

    //修改教师信息
    void updateTeacher(Teacher teacher);
    //修改教师密码
    void updatePwd(@Param("tch_username") String tch_username, @Param("pwd") String pwd);
    //上传教师头像
    String updatePhoto(@Param("tch_username") String tch_username,@Param("tch_portrait") String tch_portrait);
}
