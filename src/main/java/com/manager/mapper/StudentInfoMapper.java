package com.manager.mapper;

import com.manager.pojo.Student;
import com.manager.pojo.Validator;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedList;

@Mapper
public interface StudentInfoMapper {

    LinkedList<Student> getStudentInfo(Student student);

    Integer updateStudentInfo(Student student);

    LinkedList<String> getStudentNameBySid(String sid);

    Validator getStuValidator(String sid);

    void updatePassword(String sid, String passwordData);

    LinkedList<String> getStudentMailBySid(String sid);
}
