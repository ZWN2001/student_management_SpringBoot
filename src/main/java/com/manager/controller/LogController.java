package com.manager.controller;

import com.manager.pojo.UserLog;
import com.manager.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class LogController {
    @Autowired
    LogService logService;

    @PostMapping("/log/selectLog")
    public ArrayList<UserLog> GetLogInfo(@RequestBody String id){
        return logService.selectLog(id);
    }

}
