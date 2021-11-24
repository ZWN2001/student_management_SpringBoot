package com.manager.mapper;

import com.manager.pojo.Teacher;
import com.manager.pojo.Validator;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedList;

@Mapper
public interface TeacherMapper {

    LinkedList<Teacher> getTeacher();
    LinkedList<Teacher> getTeacherById(String tid);
    Validator getTeaValidator(String tid);
    void updatePassword(String tid,String passwordData);
}
