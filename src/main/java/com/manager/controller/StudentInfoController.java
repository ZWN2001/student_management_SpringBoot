package com.manager.controller;


import com.manager.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@CrossOrigin
public class StudentInfoController {


    @Autowired
    StudentInfoService studentInfo;


    @PostMapping("/studentInfo/searchInfo")
    public Map<String, Object> GetInfo(@RequestBody Map<String,Object> params){
        System.out.println(params.get("name"));
        return studentInfo.searchStudentInfo(params);
    }

    //更新学生信息
    @PostMapping("/studentInfo/updateInfo")
    public Integer UpdateInfo(@RequestBody Map<String,Object> params){
        System.out.println(params);
        return studentInfo.updateStudentInfo(params);
    }


//
//    @PostMapping ("/StudentInfoWithCredit/search")
//    public Map<String, Object> search(@RequestBody Map<String,Object> params) {
//        System.out.println(params);
//        return studentInfo.getStudentInfoWithCredit(params);
//    }

    @PostMapping("/studentInfo/getStudentNameBySid")
    public String get(@RequestBody String sid){
        System.out.println("sid:"+sid);
        return studentInfo.getStudentNameBySid(sid);
    }

}
