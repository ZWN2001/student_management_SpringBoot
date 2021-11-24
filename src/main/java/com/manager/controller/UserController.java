package com.manager.controller;

import com.manager.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public Integer login(@RequestBody Map<String,Object> params){
        return userService.login((String)params.get("id"),(String)params.get("password"));
    }
    @PostMapping("/user/changePassword")
    public Integer changePassword(@RequestBody Map<String,Object> params){
        return userService.changePassword((String)params.get("role"),(String)params.get("id"),
                (String)params.get("newPassword"),(String)params.get("oldPassword"));
    }
    @PostMapping("/user/resetPassword")
    public Integer resetPassword(@RequestBody Map<String,Object> params){
        return userService.resetPassword((String)params.get("sid"),(String)params.get("mail"));
    }
    @GetMapping("/user/confirmReset")
    public String confirmReset(@RequestParam String sid, @RequestParam String token){
        System.out.println(sid+"--"+token);
        return userService.confirmReset( sid, token);
    }
}

