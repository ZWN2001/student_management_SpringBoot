package com.manager.service;

import com.manager.mapper.ClassGradeInfoMapper;
import com.manager.pojo.GradeInfo;
import com.manager.util.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;

@Service
public class ClassGradeInfoService {

    @Autowired
    ClassGradeInfoMapper classGradeInfoMapper;

    public Map<String, Object> getClassGradeInfo(Map<String,Object> params){

        GradeInfo gradeInfo = new GradeInfo();
        gradeInfo.setCname(params.get("cname")==""?null:(String)params.get("cname"));
        gradeInfo.setStudentName(params.get("studentName")==""?null:(String)params.get("studentName"));
        gradeInfo.setCid(params.get("cid")==""?null:Integer.valueOf((String) params.get("cid")));
        gradeInfo.setSid(Objects.equals(params.get("sid"), "")?null:Integer.valueOf((String) params.get("sid")));
        gradeInfo.setTid(Objects.equals(params.get("tid"), "")?null:Integer.valueOf((String) params.get("tid")));
        gradeInfo.setClazz(params.get("clazz")==""?null:Integer.valueOf((String) params.get("clazz")));
        gradeInfo.setCredit(params.get("credit")==""?null:(String)params.get("credit"));
        System.out.println(classGradeInfoMapper.getClassGradeInfo(gradeInfo));
        return MyPageHelper.myPageHelper(params, classGradeInfoMapper.getClassGradeInfo(gradeInfo));
    }




    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Integer insertGrade(Map<String,Object> params){

        GradeInfo gradeInfo = new GradeInfo();
        //如果值不存在那么，就直接返回错误
        if (params.get("mark")==null) {
            return -1;
        } else{
            gradeInfo.setMark(Integer.parseInt(params.get("mark").toString()));
            gradeInfo.setCid(Integer.parseInt(params.get("cid").toString()));
            gradeInfo.setSid(Integer.parseInt(params.get("sid").toString()));
        }
        if (classGradeInfoMapper.updateGrade(gradeInfo)!=1) {return -1;}
        return  0;
    }

}