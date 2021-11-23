package com.manager.mapper;

import com.manager.pojo.GradeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedList;

@Mapper
public interface ClassGradeInfoMapper {


    LinkedList<GradeInfo> getClassGradeInfo(GradeInfo classGradeInfo);

    Integer updateGrade(GradeInfo classGradeInfo);

}
