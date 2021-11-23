package com.manager.controller;

import com.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public Integer login(@RequestBody Map<String,Object> params){
        return userService.login((String)params.get("id"),(String)params.get("password"));
    }
}

