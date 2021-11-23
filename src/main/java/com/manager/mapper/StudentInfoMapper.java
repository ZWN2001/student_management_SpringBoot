package com.manager.mapper;

import com.manager.pojo.Student;
import com.manager.pojo.Validator;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedList;

@Mapper
public interface StudentInfoMapper {


    //使用的模糊查询
//    LinkedList<StudentInfoView> getStudentInfoByName(StudentInfoView studentInfo);
//    LinkedList<StudentInfoView> getStudentInfo();
//    LinkedList<StudentInfoView> getStudentInfoByMajor(StudentInfoView studentInfo);

    LinkedList<Student> getStudentInfo(Student student);

    Integer updateStudentInfo(Student student);

//    void addNewStudent(Student student);

    LinkedList<String> getStudentNameBySid(String sid);
    LinkedList<String> getStudentBySid(String sid);
    Validator getStuValidator(String sid);
}
