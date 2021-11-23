package com.manager.pojo;

public class CourseSelected {
    private Integer sid;
    private Integer cid;
    private Integer tid;
    private String cname;
    private String teacherName;
    private String studentName;
    private Integer credit;
    private Integer start;
    private Integer end;
    private Integer mark;
    private Integer courseDay;
    private Integer courseSection;

    public CourseSelected(Integer sid, Integer cid, Integer tid, String cname, String teacherName, String studentName,
                          Integer credit, Integer start, Integer end, Integer mark, Integer courseDay, Integer courseSection) {
        this.sid = sid;
        this.cid = cid;
        this.tid = tid;
        this.cname = cname;
        this.teacherName = teacherName;
        this.studentName = studentName;
        this.credit = credit;
        this.start = start;
        this.end = end;
        this.mark = mark;
        this.courseDay = courseDay;
        this.courseSection = courseSection;
    }

    public CourseSelected() {}

    @Override
    public String toString() {
        return "CourseSelected{" +
                "sid=" + sid +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", credit=" + credit +
                ", start=" + start +
                ", end=" + end +
                ", mark=" + mark +
                ", courseDay=" + courseDay +
                ", courseSection=" + courseSection +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
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

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
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
}