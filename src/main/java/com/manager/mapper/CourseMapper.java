package com.manager.mapper;

import com.manager.pojo.Course;
import com.manager.pojo.CourseSelected;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedList;

@Mapper
public interface CourseMapper {

    LinkedList<Course> getCourse(Course course);

//    LinkedList<Course> getCourseByID(int id);

    void selectCourse(int sid,int cid,int tid,String cname,String teacherName,String studentName,int credit,
                      int start, int end,int clazz, int courseDay,int courseSection);

    LinkedList<String> checkSelected(int cid,int sid);

    LinkedList<String> checkSelectedTime(String courseDay,String courseSection);

    LinkedList<CourseSelected> getSelectedCourse(String sid,String tid);

    void dropSelectedCourse(String sid,String cid);

    void addCourse(String tid,String cname,String teacherName,String credit,String courseDay,
                   String courseSection,String start,String end,String courseInfo);

    void updateCourse(String cid,String cname,String credit,String courseDay,
                      String courseSection,String start,String end,String courseInfo);

    void dropCourse(String cid);

    //因为老师删课程而导致的变更
    void dropSelectedCourseTea(String cid);

    void updateSelectedCourse(String cid,String cname,String credit,String courseDay,
                              String courseSection,String start,String end,String courseInfo);
}
