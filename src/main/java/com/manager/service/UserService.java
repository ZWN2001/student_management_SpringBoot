package com.manager.service;

import com.manager.mapper.StudentInfoMapper;
import com.manager.mapper.TeacherMapper;
import com.manager.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class UserService {
    @Autowired
    StudentInfoMapper studentInfoMapper;
    @Autowired
    TeacherMapper teacherMapper;

    public Integer login(String id, String password) {
        if (!studentInfoMapper.getStudentBySid(id).isEmpty()) {
            try {
                String str = studentInfoMapper.getStudentBySid(id).toString();
                str = str.substring(2, str.length() - 2);
                String[] strs = str.split("=");
                if (password.equals(strs[1])) {
                    return 0;
                }
            }catch (Exception e){}
        }else {
            try {
                LinkedList<Teacher> teacherInfo = teacherMapper.getTeacherById(id);
                if (teacherInfo!= null){
                    try {
                        String str = teacherInfo.toString();
                        str = str.substring(2, str.length() - 2);
                        String[] strs = str.split("=");
                        if (password.equals(strs[1])) {
                            return 0;
                        }
                    }catch (Exception e){}
                    return 1;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return -1;
    }


}
