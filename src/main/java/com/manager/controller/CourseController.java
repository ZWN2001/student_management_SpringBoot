package com.manager.controller;

import com.manager.pojo.CourseSelected;
import com.manager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Map;

@RestController
@CrossOrigin
public class CourseController {
    @Autowired
    CourseService courseService;

     @PostMapping("/getCourse")
    public Map<String,Object> get_course(@RequestBody Map<String,String> params){
         System.out.println(courseService.getCourseMap(params));
        return courseService.getCourseMap(params);
    }

    @PostMapping("/selectCourse")
    public int select_course(@RequestBody Map<String,String> params){
        return courseService.selectCourse(params);
    }

    @PostMapping("/getSelectedCourse")
    public Map<String,Object> get_selected_course(@RequestBody Map<String,String> params){
        return courseService.getSelectedCourse(params);
    }

    //下面这个不会分页
    @PostMapping("/getAllSelectedCourse")
    public ArrayList<CourseSelected> get_all_selected_course(@RequestBody Map<String,String> params){
        return courseService.getAllSelectedCourse(params);
    }

    @PostMapping("/dropSelectedCourse")
    public int drop_selected_course(@RequestBody Map<String,String> params){
        return courseService.dropSelectedCourse(params);
    }

    @PostMapping("/dropCourse")
    public int drop_course(@RequestBody Map<String,String> params){
        return courseService.dropCourse(params);
    }

    @PostMapping("/updateCourse")
    public int update_course(@RequestBody Map<String,String> params){
        return courseService.updateCourse(params);
    }

    @PostMapping("/addCourse")
    public int add_course(@RequestBody Map<String,String> params){
        return courseService.addCourse(params);
    }
}
