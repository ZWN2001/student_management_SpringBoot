package com.manager.mapper;

import com.manager.pojo.UserLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedList;

@Mapper
public interface LogMapper {
    void insertLog(String id,String lastLoginTime);
    LinkedList<UserLog> selectLog(String id);
}
