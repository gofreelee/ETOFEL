package com.example.user.controller;

import com.example.user.bean.Teacher;
import com.example.user.mapper.TeacherMapper;
import com.example.user.service.TeacherService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    Gson gson;

    @GetMapping("/info")
    @ResponseBody
    public String teacherInfo(@RequestParam("tch_username")String tch_username){
        Teacher teacher = teacherService.getTeacherByUsername(tch_username);
        System.out.println(teacher);
        return gson.toJson(teacher);
    }

    @GetMapping("/update")
    public String update(@RequestParam("tch_username")String tch_username,
                         @RequestParam("tch_name")String tch_name,
                         @RequestParam("tch_education")String tch_education,
                         @RequestParam("tch_email")String tch_email,
                         @RequestParam(value = "tch_birthday",required = false) Date tch_birthday,
                         @RequestParam(value = "tch_description",required = false)String tch_description,
                         @RequestParam(value = "tch_phone",required = false)String tch_phone,
                         @RequestParam("tch_gender")String tch_gender) {
        Teacher newTeacher = teacherService.getTeacherByUsername(tch_username);
        newTeacher.setTch_name(tch_name);
        newTeacher.setTch_education(tch_education);
        newTeacher.setTch_email(tch_email);
        newTeacher.setTch_birthday(tch_birthday);
        newTeacher.setTch_description(tch_description);
        newTeacher.setTch_phone(tch_phone);
        newTeacher.setTch_gender(tch_gender);
        System.out.println(newTeacher);
        teacherService.updateTeacher(newTeacher);
        return null;
    }

    @GetMapping("/updatePwd")
    public String updatePwd(@RequestParam("tch_username")String tch_username,
                            @RequestParam("newpassword1")String newpassword1
    ){
        teacherService.updatePwd(tch_username,newpassword1);
        return null;
    }

    @PostMapping("/updatePhoto")
    public Map<String, Object> updatePhoto(@RequestParam("imgFile") MultipartFile imgFile,
                                           @RequestParam("tch_username")String tch_username) throws IOException {
        if (imgFile== null) {
            return new HashMap(0);
        }

        Map map = new HashMap(2);

        String filename = imgFile.getOriginalFilename();

        // 创建临时文件
        File tempFile = File.createTempFile("tem", null);
        imgFile.transferTo(tempFile);
        tempFile.deleteOnExit();

        FileInputStream inputStream = new FileInputStream(tempFile);

        byte[] buffer = new byte[(int)tempFile.length()];
        inputStream.read(buffer);
        inputStream.close();

        String base64 = new sun.misc.BASE64Encoder().encode(buffer);
        base64 = base64.replaceAll("[\\s*\t\n\r]", "");

        teacherService.updatePhoto(tch_username,base64);
        map.put("filename", filename);
        map.put("base64", base64);
        return map;

    }

}
