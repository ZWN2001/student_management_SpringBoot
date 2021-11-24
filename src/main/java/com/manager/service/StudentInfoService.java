package com.manager.service;

import com.manager.mapper.StudentInfoMapper;
import com.manager.pojo.*;
import com.manager.util.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentInfoService {

    @Autowired
    StudentInfoMapper studentInfoMapper;

    public Map<String, Object> searchStudentInfo(Map<String, Object> params) {
        Student student = new Student();
        student.setSid( params.get("sid")==""?null:Integer.parseInt((String)params.get("sid")) );
        student.setName( params.get("name")==""?null:(String)params.get("name") );
        student.setClazz( params.get("clazz")==""?null:Integer.parseInt((String)params.get("clazz")) );
        student.setMail( params.get("mail")==""?null:(String)params.get("mail") );
        student.setPhone( params.get("phone")==""?null:(String)params.get("phone") );
        return MyPageHelper.myPageHelper(params, studentInfoMapper.getStudentInfo(student));
    }


    public String getStudentNameBySid(String sid){
        String str = studentInfoMapper.getStudentNameBySid(sid).toString();
        str = str.substring(2,str.length()-2);
        String strs[] = str.split("=");
        return strs[1];
    }

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Integer updateStudentInfo(Map<String, Object> params) {
        if (getStudentNameBySid((String)params.get("sid"))==null){
            return -1;//查无此人
        }else {
            Student student = new Student();
            student.setSid((Integer)params.get("sid"));
            student.setName((String) params.get("name"));
            student.setMail((String) params.get("mail"));
            student.setPhone((String) params.get("phone"));
            student.setOther((String) params.get("other"));
            student.setAddress((String) params.get("address"));
            System.out.println(student);
            if (studentInfoMapper.updateStudentInfo(student)==0) {
                return -2;//更新失败
            }
        }
        return 0;
    }
}
