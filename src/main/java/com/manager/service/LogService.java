package com.manager.service;

import com.manager.mapper.LogMapper;
import com.manager.pojo.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogService {
    @Autowired
    LogMapper logMapper;

    ArrayList<String> logs = new ArrayList<>();
    public ArrayList<String> selectLog(String id){
        System.out.println(id);
        logs.clear();
        for (UserLog log :logMapper.selectLog(id)) {
            logs.add(log.getLastLoginTime());
        }
        System.out.println(logs);
        return logs;
    }
}
