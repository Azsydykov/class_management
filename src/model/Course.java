package model;

import java.util.List;

public class Course {

    private int id;
    private String name;
    private String price;
    private String duration;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course() {

    }

    public Course(String name, double price, int duration) {
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Course(String name, String price, String duration) {
        this.name = name;
        this.price = price;
        this.duration = duration;
    }

    public Course(int id, String name, String price, String duration) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return String.valueOf(price);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuration() {
        return String.valueOf(duration);
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    List<Course> courses;

    @Override
    public String toString() {
        return getName();
    }
}
