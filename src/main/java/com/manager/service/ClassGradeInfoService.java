package com.manager.service;

import com.manager.mapper.ClassGradeInfoMapper;
import com.manager.pojo.GradeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassGradeInfoService {

    @Autowired
    ClassGradeInfoMapper classGradeInfoMapper;

    public static Map<String,Object> MypageHelper(Map<String,Object> params,List<GradeInfo> data){
        Map<String,Object> res = new HashMap<>();
        int from =((Integer)params.get("pageIndex")-1)*((Integer)params.get("pageSize"));
        int to = ((Integer)params.get("pageIndex"))*((Integer)params.get("pageSize"));
        //小小地实现一下分页，就不用pagehelper了
        res.put("data",data.subList(from,to>data.size()?data.size():to));
        res.put("pagetotal",data.size());
        return  res;
    }

    public Map<String, Object> getClassGradeInfo(Map<String,Object> params){

        GradeInfo gradeInfo = new GradeInfo();
        gradeInfo.setCname(params.get("cname")==""?null:(String)params.get("cname"));
        gradeInfo.setStudentName(params.get("studentName")==""?null:(String)params.get("studentName"));
        gradeInfo.setCid(params.get("cid")==""?null:Integer.valueOf((String) params.get("cid")));
        gradeInfo.setSid(params.get("sid")==""?null:Integer.valueOf((String) params.get("sid")));
        gradeInfo.setTid(params.get("tid")==""?null:Integer.valueOf((String) params.get("tid")));
        gradeInfo.setClazz(params.get("clazz")==""?null:Integer.valueOf((String) params.get("clazz")));
//        gradeInfo.setTeacherName(params.get("teacherName")==""?null:(String) params.get("teacherName"));
        gradeInfo.setCredit(params.get("credit")==""?null:(String)params.get("credit"));
        System.out.println(classGradeInfoMapper.getClassGradeInfo(gradeInfo));
        return  MypageHelper(params,classGradeInfoMapper.getClassGradeInfo(gradeInfo));
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