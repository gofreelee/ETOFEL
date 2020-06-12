package com.example.user.service.impl;

import com.example.user.bean.Teacher;
import com.example.user.mapper.TeacherMapper;
import com.example.user.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher getTeacherByUsername(String tch_username){
        return teacherMapper.getTeacherByUsername(tch_username);
    }


    @Override
    public void updateTeacher(Teacher teacher){teacherMapper.updateTeacher(teacher);}

    @Override
    public void updatePwd(String tch_username,String pwd){teacherMapper.updatePwd(tch_username,pwd);}

    @Override
    public void updatePhoto(String tch_username,String tch_portrait){
        teacherMapper.updatePhoto(tch_username, tch_portrait);}

}
