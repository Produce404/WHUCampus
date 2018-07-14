package com.example.hp.mycampus.model;

public class Score {
    private String id;// 课头号
    private String name;// 课程名称
    private String lessonType;// 课程类型
    private String credit;// 学分
    private String teacher;// 教师
    private String place;// 授课学院
    private String type;// 学习类型
    private String year;// 学年
    private String semester;// 学期
    private String score;// 成绩

    public Score(String id, String name, String lessonType, String credit, String teacher, String place, String type,
                 String year, String semester, String score) {
        super();
        this.id = id;
        this.name = name;
        this.lessonType = lessonType;
        this.credit = credit;
        this.teacher = teacher;
        this.place = place;
        this.type = type;
        this.year = year;
        this.semester = semester;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score [id=" + id + ", name=" + name + ", lessonType=" + lessonType + ", credit=" + credit + ", teacher="
                + teacher + ", place=" + place + ", type=" + type + ", year=" + year + ", semester=" + semester
                + ", score=" + score + "]";
    }
}
