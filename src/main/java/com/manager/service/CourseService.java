package com.manager.service;

import com.manager.mapper.CourseMapper;
import com.manager.pojo.Course;
import com.manager.pojo.CourseSelected;
import com.manager.util.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CourseService {

    @Autowired
    CourseMapper courseMapper;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<CourseSelected> selectedCourses = new ArrayList<>();


    public Map<String,Object> getCourseMap(@RequestBody Map<String,String> params){
        courses.clear();
        Course myCourse =new Course();
        myCourse.setCid(Objects.equals(params.get("cid"), "") ?null:Integer.parseInt(params.get("cid")));
        myCourse.setTid(Objects.equals(params.get("tid"), "") ?null:Integer.parseInt(params.get("tid")));
        myCourse.setCredit(Objects.equals(params.get("credit"), "") ?null:Integer.parseInt(params.get("credit")));
        myCourse.setCourseDay(Objects.equals(params.get("courseDay"), "") ?null:Integer.parseInt(params.get("courseDay")));
        myCourse.setCourseSection(Objects.equals(params.get("courseSection"), "") ?null:Integer.parseInt(params.get("courseSection")));
            for (Course course: courseMapper.getCourse(myCourse)) {
                System.out.println("course:"+course);
                courses.add(course);
            }

        return MyPageHelper.myPageHelper(params, courses);
    }

    public int dropCourse(@RequestBody Map<String,String> params){
        System.out.println(params);
            try {
                courseMapper.dropCourse(params.get("cid"));
            }catch (Exception e){
                e.printStackTrace();
                return -1;
            }
            int n = dropSelectedCourseTea(params);
            if (n==-1){
                return n;
            }else {
                return 0;
            }
    }

    public int addCourse(@RequestBody Map<String,String> params){
        System.out.println(params);
        if (params.size()!=9||Objects.equals(params.get("cname"), "") || Objects.equals(params.get("cname"), "") || Objects.equals(params.get("credit"), "")
                || Objects.equals(params.get("courseDay"), "") || Objects.equals(params.get("courseSection"), "")
                || Objects.equals(params.get("start"), "") || Objects.equals(params.get("end"), "") || Objects.equals(params.get("courseInfo"), "")){
            return -2;
        }else {
            try {
                courseMapper.addCourse(params.get("tid"),params.get("cname"),params.get("teacherName"),params.get("credit"),
                        params.get("courseDay"),params.get("courseSection"),params.get("start"),params.get("end"),
                        params.get("courseInfo"));
            }catch (Exception e){
                e.printStackTrace();
                return -1;
            }
            return 0;
        }
    }

    public int updateCourse(@RequestBody Map<String,String> params){
        System.out.println(params);
        int n;
        try {
            courseMapper.updateCourse(params.get("cid"),params.get("cname"),params.get("credit"),
                    params.get("courseDay"),params.get("courseSection"),params.get("start"),params.get("end"),
                    params.get("courseInfo"));
            n = updateSelectedCourse(params);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        if (n == -1){
            return n;
        }else {
            return 0;
        }

    }

    public int updateSelectedCourse(@RequestBody Map<String,String> params){
        System.out.println(params);
        try {
            courseMapper.updateSelectedCourse(params.get("cid"),params.get("cname"),params.get("credit"),
                    params.get("courseDay"),params.get("courseSection"),params.get("start"),params.get("end"),
                    params.get("courseInfo"));
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    //因为老师删课程而导致的变更
    public int dropSelectedCourseTea(@RequestBody Map<String,String> params){
        System.out.println(params);
        try {
            courseMapper.dropSelectedCourseTea(params.get("cid"));
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public int selectCourse(@RequestBody Map<String,String> params){
        System.out.println(params);
        if (courseMapper.checkSelected(Integer.parseInt(params.get("cid")),Integer.parseInt(params.get("sid"))).size() != 0){
            System.out.println("该课已选");
            return -2;
        }else if (courseMapper.checkSelectedTime(params.get("courseDay"),params.get("courseSection")).size() != 0){
            System.out.println("选课时间冲突");
            return -3;
        } else {
            try {
                System.out.println("选课："+params);
                courseMapper.selectCourse(Integer.parseInt(params.get("sid")),Integer.parseInt(params.get("cid")),Integer.parseInt(params.get("tid")),
                        params.get("cname"),params.get("teacherName"),params.get("studentName"),Integer.parseInt(params.get("credit")),
                        Integer.parseInt(params.get("start")),Integer.parseInt(params.get("end")),Integer.parseInt(params.get("clazz")),
                        Integer.parseInt(params.get("courseDay")),Integer.parseInt(params.get("courseSection")));
            }catch (Exception e){
                e.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    //老师或学生去查选课名单
    public Map<String,Object> getSelectedCourse(@RequestBody Map<String,String> params){
        selectedCourses.clear();
            try {
                for (CourseSelected Course: courseMapper.getSelectedCourse(
                        Objects.equals(params.get("sid"), "") ? null:params.get("sid"),
                        Objects.equals(params.get("tid"), "") ? null:params.get("tid"))) {
                    System.out.println(Course);
                    selectedCourses.add(Course);
                } assert !Objects.equals(params.get("sid"), "") || !Objects.equals(params.get("tid"), "");
            }catch (Exception e){
                e.printStackTrace();
            }
            return MyPageHelper.myPageHelper(params, selectedCourses);
    }

    //学生获取所有选课（用于课表）
    public ArrayList<CourseSelected> getAllSelectedCourse(@RequestBody Map<String,String> params){
        selectedCourses.clear();
        try {
            for (CourseSelected Course: courseMapper.getSelectedCourse(params.get("sid"),null)) {
                System.out.println(Course);
                selectedCourses.add(Course);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return selectedCourses;
    }

    public int dropSelectedCourse(@RequestBody Map<String,String> params){
        System.out.println("退课:   "+params);
            try {
                courseMapper.dropSelectedCourse(params.get("sid"),params.get("cid"));
            }catch (Exception e){
                e.printStackTrace();
                return -1;
            }
        return 0;
    }
}
