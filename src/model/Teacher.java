package model;

import java.util.List;

public class Teacher extends Person {

    private List<Integer> course_list;


    public Teacher(int id, String name, String address, String phone,List<Integer> course_list) {
        super(id, name, address, phone);
        this.course_list = course_list;
    }

    public Teacher(String name, String address, String phone, List<Integer> course_list) {
        super(name, address, phone);
        this.course_list = course_list;
    }

    public Teacher(String name, String address, String phone) {
        super(name,address,phone);
    }

    public Teacher(int id, String name) {
        super(id,name);
    }

    public Teacher(int id, String name, String address, String phone) {
        super(id, name, address, phone);
    }

    public Teacher() {

    }

    public List<Integer> getCourse_list() {
        return course_list;
    }

    public void setCourse_list(List<Integer> course_list) {
        this.course_list = course_list;
    }
}
