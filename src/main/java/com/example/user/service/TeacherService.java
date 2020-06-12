package com.example.user.service;

import com.example.user.bean.Teacher;

public interface TeacherService {

    Teacher getTeacherByUsername(String tch_username);

    void updateTeacher(Teacher teacher);
    void updatePwd(String tch_username,String pwd);
    void updatePhoto(String tch_username,String tch_portrait);
}
