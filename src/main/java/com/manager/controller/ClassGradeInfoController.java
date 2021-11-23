package com.manager.controller;

import com.manager.service.ClassGradeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
public class ClassGradeInfoController {

    @Autowired
    ClassGradeInfoService classGradeInfoService;

    @PostMapping("/ClassGradeInfo/search")
    public Map<String, Object> search(@RequestBody Map<String,Object> params){
        System.out.println(params);
        return classGradeInfoService.getClassGradeInfo(params);
    }

    @PostMapping("/ClassGradeInfo/insert")
    public  Integer insert(@RequestBody Map<String,Object> params){
        System.out.println(params);
        return classGradeInfoService.insertGrade(params);
    }


}
