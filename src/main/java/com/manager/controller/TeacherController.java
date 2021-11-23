package com.manager.controller;

import com.manager.pojo.Teacher;
import com.manager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/teacher/getTeacher")
    public ArrayList<Teacher> get_teacher(){
        return teacherService.getTeacher();
    }

    @PostMapping("/teacher/getTeacherById")
    public ArrayList<Teacher> get_teacherById(@RequestBody Map<String,Object> params){
        return teacherService.getTeacherById(params);
    }
}
