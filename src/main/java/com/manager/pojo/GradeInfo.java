package com.manager.pojo;

public class GradeInfo {

    private Integer sid;
    private Integer cid;
    private Integer tid;
    private String studentName;
    private Integer mark;
    private String cname;
    private String teacherName;
    private String credit;
    private Integer clazz;


    public GradeInfo(Integer sid, Integer cid, Integer tid, String studentName, Integer mark, String cname,
                     String teacherName, String credit, Integer clazz) {
        this.sid = sid;
        this.cid = cid;
        this.tid = tid;
        this.studentName = studentName;
        this.mark = mark;
        this.cname = cname;
        this.teacherName = teacherName;
        this.credit = credit;
        this.clazz = clazz;
    }

    public GradeInfo(){}

    @Override
    public String toString() {
        return "GradeInfo{" +
                "sid=" + sid +
                ", cid=" + cid +
                ", tid=" + tid +
                ", studentName='" + studentName + '\'' +
                ", mark=" + mark +
                ", cname='" + cname + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", credit='" + credit + '\'' +
                ", clazz=" + clazz +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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


}
