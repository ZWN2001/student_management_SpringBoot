package com.manager.service;

import com.manager.mapper.StudentInfoMapper;
import com.manager.pojo.*;
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

    public static Map<String,Object> MypageHelper(Map<String,Object> params,List<Student> data){
        Map<String,Object> res = new HashMap<>();
        int from =((Integer)params.get("pageIndex")-1)*((Integer)params.get("pageSize"));
        int to = ((Integer)params.get("pageIndex"))*((Integer)params.get("pageSize"));
        //小小地实现一下分页，就不用pagehelper了
        res.put("data",data.subList(from,to>data.size()?data.size():to));
        res.put("pagetotal",data.size());
        return  res;
    }

    public Map<String, Object> searchStudentInfo(Map<String, Object> params) {
        Student student = new Student();
        student.setSid( params.get("sid")==""?null:Integer.parseInt((String)params.get("sid")) );
        student.setName( params.get("name")==""?null:(String)params.get("name") );
        student.setClazz( params.get("clazz")==""?null:Integer.parseInt((String)params.get("clazz")) );
        student.setMail( params.get("mail")==""?null:(String)params.get("mail") );
        student.setPhone( params.get("phone")==""?null:(String)params.get("phone") );
        return MypageHelper(params,studentInfoMapper.getStudentInfo(student));
    }


    public String getStudentNameBySid(String sid){
        String str = studentInfoMapper.getStudentNameBySid(sid).toString();
        str = str.substring(2,str.length()-2);
        String strs[] = str.split("=");
        System.out.println("name:"+strs[1]);
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
