package com.manager.pojo;

public class Course {
    private Integer cid;
    private Integer tid;
    private String cname;
    private String teacherName;
    private Integer credit;
    private Integer courseDay;
    private Integer courseSection;
    private Integer start;
    private Integer end;
    private String courseInfo;

    public Course(Integer cid, Integer tid, String cname, String teacherName, Integer credit, Integer courseDay,
                  Integer courseSection, Integer start, Integer end, String courseInfo) {
        this.cid = cid;
        this.tid = tid;
        this.cname = cname;
        this.teacherName = teacherName;
        this.credit = credit;
        this.courseDay = courseDay;
        this.courseSection = courseSection;
        this.start = start;
        this.end = end;
        this.courseInfo = courseInfo;
    }

    public Course() {}

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", tid=" + tid +
                ", cname='" + cname + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", credit=" + credit +
                ", courseDay=" + courseDay +
                ", courseSection=" + courseSection +
                ", start=" + start +
                ", end=" + end +
                ", courseInfo='" + courseInfo + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getCourseDay() {
        return courseDay;
    }

    public void setCourseDay(Integer courseDay) {
        this.courseDay = courseDay;
    }

    public Integer getCourseSection() {
        return courseSection;
    }

    public void setCourseSection(Integer courseSection) {
        this.courseSection = courseSection;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}