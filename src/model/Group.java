package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Group {
    private int id;
    private Course course;
    private Teacher teacher;
    private LocalDate startDate;

    public Group(int id, Course course, Teacher teacher, LocalDate startDate) {
        this.id = id;
        this.course = course;
        this.teacher = teacher;
        this.startDate = startDate;
    }

    public Group(int id, String name, String startDate) {
    }

    public Group(int id, int id1, LocalDate localDate) {
    }

    public Group(String course_name, String teacher_name, String startDate) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

}

