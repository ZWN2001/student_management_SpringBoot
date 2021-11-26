package com.manager.service;

import com.manager.mapper.LogMapper;
import com.manager.pojo.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LogService {
    @Autowired
    LogMapper logMapper;

    List<UserLog> myList;
    ArrayList<UserLog> resultList = new ArrayList<>();
    UserLog log;
    public ArrayList<UserLog> selectLog(String id){
        resultList.clear();
        LinkedList<UserLog> logList = logMapper.selectLog(id);

        if (logList.size()>=8){
            myList = logList.subList(logList.size() - 8,logList.size()-1);
            for (int i = 1;i<8;i++){
                log = myList.get(i-1);
                log.setId(i+"");
                resultList.add(log);
            }
        }else {
            myList = logList;
            for (int i = 1;i<=myList.size();i++){
                log = myList.get(i-1);
                log.setId(i+"");
                resultList.add(log);
            }
        }
        return resultList;
    }
}
