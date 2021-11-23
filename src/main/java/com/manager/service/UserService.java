package com.manager.service;

import com.manager.mapper.StudentInfoMapper;
import com.manager.mapper.TeacherMapper;
import com.manager.pojo.Validator;

import com.manager.util.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.Security;


@Service
public class UserService {
    @Autowired
    StudentInfoMapper studentInfoMapper;
    @Autowired
    TeacherMapper teacherMapper;

    public Integer login(String id, String password) {
        if (!studentInfoMapper.getStudentBySid(id).isEmpty()) {
            try {
                Validator validator = studentInfoMapper.getStuValidator(id);
                System.out.println(validator);

                if (BCrypt.checkpw(password, validator.getPasswordData())){
                    return 0;
                }else {
                    return -1;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try {
                Validator validator = teacherMapper.getTeaValidator(id);
                if (BCrypt.checkpw(password, validator.getPasswordData())){
                    return 1;
                }else {
                    return -1;
                }
            }catch (Exception e){
                e.printStackTrace();
                return -1;
            }
        }

        return -1;
    }


}
