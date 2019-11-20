package model;

import java.util.Date;

public class StudentGroup {
    private int id;
    private int group_id;
    private int is_paid;
    private int student_id;
    private Date pay_date;
    private String end_date;

    public StudentGroup(int id, int group_id, int is_paid, int student_id, Date pay_date, String end_date) {
        this.id = id;
        this.group_id = group_id;
        this.is_paid = is_paid;
        this.student_id = student_id;
        this.pay_date = pay_date;
        this.end_date = end_date;
    }

    public StudentGroup(int group_id, int is_paid, int student_id, Date pay_date, String end_date) {
        this.group_id = group_id;
        this.is_paid = is_paid;
        this.student_id = student_id;
        this.pay_date = pay_date;
        this.end_date = end_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getIs_paid() {
        return is_paid;
    }

    public void setIs_paid(int is_paid) {
        this.is_paid = is_paid;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
