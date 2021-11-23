package com.manager.service;

import com.manager.mapper.TeacherMapper;
import com.manager.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Map;

@Service
public class TeacherService {

    @Autowired
    TeacherMapper teacherMapper;
    ArrayList<Teacher> teacherArrayList = new ArrayList<>();

    public ArrayList<Teacher> getTeacher(){
        teacherArrayList.clear();
        teacherArrayList.addAll(teacherMapper.getTeacher());
        return teacherArrayList;
    }
    public ArrayList<Teacher> getTeacherById( Map<String,Object> params){
        teacherArrayList.clear();
        teacherArrayList.addAll(teacherMapper.getTeacherById((String)params.get("tid")));
        return teacherArrayList;
    }
}
