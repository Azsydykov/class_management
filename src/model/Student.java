package model;

import java.util.List;

public class Student extends Person {

    List<Integer> course_id;


    public Student(int id, String name, String phone, String address, List<Integer> course_id) {
        super(id, name, phone, address);
        this.course_id = course_id;
    }

    public Student(String name, String address, String phone, List<Integer> course_id) {
        super(name, address, phone);
        this.course_id = course_id;
    }

    public Student(int id, String name, String address, String phone) {
        super(id, name, address, phone);
    }

    public Student(int id, String name) {
        super(id, name);
    }

    public Student(String name, String address, String phone) {
        super(name,address,phone);
    }

    public Student() {
        super();
    }

    public List<Integer> getCourse_id() {
        return course_id;
    }

    public void setCourse_id(List<Integer> course_id) {
        this.course_id = course_id;
    }

    public Student(int id, String name, List<Integer> course_id) {
        super(id, name);
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return getName();
    }
}
