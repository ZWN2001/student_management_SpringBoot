package com.manager.mapper;

import com.manager.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedList;

@Mapper
public interface TeacherMapper {

    LinkedList<Teacher> getTeacher();
    LinkedList<Teacher> getTeacherById(String tid);

}
