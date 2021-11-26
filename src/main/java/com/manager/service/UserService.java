package com.manager.service;

import com.manager.mapper.LogMapper;
import com.manager.mapper.StudentInfoMapper;
import com.manager.mapper.TeacherMapper;
import com.manager.pojo.Validator;

import com.manager.util.BCrypt;
import com.manager.util.PBECipher;
import com.manager.util.PasswordResetMailSender;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;


@Service
public class UserService {
    @Autowired
    StudentInfoMapper studentInfoMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    PasswordResetMailSender passwordResetMailSender;
    @Autowired
    LogMapper logMapper;

    public Integer login(String id, String password) {
        Validator validator = studentInfoMapper.getStuValidator(id);
        if (validator != null) {
            try {
                if (BCrypt.checkpw(password, validator.getPasswordData())){
                    SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
                    sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date();
                    String lastLoginTime = sdf.format(date);
                    logMapper.insertLog(id,lastLoginTime);
                    return 0;
                }else {
                    return -1;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try {
                 validator = teacherMapper.getTeaValidator(id);
                if (BCrypt.checkpw(password, validator.getPasswordData())){
                    SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
                    sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
                    Date date = new Date();
                    String lastLoginTime = sdf.format(date);
                    logMapper.insertLog(id,lastLoginTime);
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

    public Integer changePassword(String role,String id, String newPassword,String oldPassword) {
        if (role.equals("0")) {
            try {
                Validator validator = studentInfoMapper.getStuValidator(id);
                if (BCrypt.checkpw(oldPassword, validator.getPasswordData())){
                    String hashed = BCrypt.hashpw(newPassword, BCrypt.gensalt());//密文
                    studentInfoMapper.updatePassword(id,hashed);
                    return 0;
                }else {
                    return -2;
                }
            }catch (Exception e){
                e.printStackTrace();
                return -1;
            }
        }else {
            try {
                Validator validator = teacherMapper.getTeaValidator(id);
                if (BCrypt.checkpw(oldPassword, validator.getPasswordData())){
                    String hashed = BCrypt.hashpw(newPassword, BCrypt.gensalt());//密文
                    teacherMapper.updatePassword(id,hashed);
                    return 0;
                }else {
                    return -2;
                }
            }catch (Exception e){
                e.printStackTrace();
                return -1;
            }
        }
    }

    public Integer  resetPassword(String sid ,String mail){
        try {
            if (studentInfoMapper.getStuValidator(sid) != null){
                Security.addProvider(new BouncyCastleProvider());
                String targetMail = studentInfoMapper.getStudentMailBySid(sid).toString();
                targetMail = targetMail.substring(2,targetMail.length()-2);
                String strs[] = targetMail.split("=");
                System.out.println(strs[1].equals(mail));
                if (strs[1].equals(mail)){
                    SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
                    sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
                    Date date = new Date();
                    String str = sdf.format(date);
                    str = str+ sid;

                    Security.addProvider(new BouncyCastleProvider());
                    byte[] data = str.getBytes(StandardCharsets.UTF_8);
                    byte[] salt = SecureRandom.getInstanceStrong().generateSeed(16);

                    //第一个变量是加密口令
                    byte[] encrypted = PBECipher.encrypt("reset", salt, data);
                    String token = Base64.getEncoder().encodeToString(encrypted);

                    //token传入数据库，在此期间用户将不能登录
                    studentInfoMapper.updatePassword(sid,token);

                    //发送邮件
                   passwordResetMailSender.sendMimeMail(sid ,mail,token);
                }else {
                    return -2;
                }
                return 0;
            }else {
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
            return -2;
        }
    }

    public String confirmReset(String sid,String token){
        Validator validator = studentInfoMapper.getStuValidator(sid);
        System.out.println(validator);
        if (validator.getPasswordData().equals(token)){
            String hashed = BCrypt.hashpw("123456", BCrypt.gensalt());
            studentInfoMapper.updatePassword(sid,hashed);
            return "重置成功，密码为123456，请尽快登录并修改密码";
        } else {
            return "token已过期";
        }
    }


}
