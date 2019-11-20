package services.impl;

import model.*;
import services.AdministratorSirvices;
import services.DbService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministratorSirvicesImpl implements AdministratorSirvices {

    @Override
    public void createStudent(Student student) {
        DbService dbService = new DbServiceImpl();
        if (dbService.appendStudent(student)){
            System.out.println("Успешно");
        }else {
            System.out.println("Ошибка при создании!");
        }


    }

    @Override
    public void unRegisterStudent(Student student, Group group) {

    }

    @Override
    public void getPayment(Student student, Group group) {

    }

    @Override
    public void paySalary(Teacher teacher) {

    }

    @Override
    public void createGroup(Group group) {
        DbService dbService = new DbServiceImpl();
        if (dbService.createGroup(group)){
            System.out.println("Успешно");
        }else {
            System.out.println("Ошибка при создании Группы!");
        }

    }

    @Override
    public void createTeacher(Teacher teacher) {
        DbService dbService = new DbServiceImpl();
        if (dbService.appendTeacher(teacher)){
            System.out.println("Успешно");
        }else {
            System.out.println("Ошибка при создании!");
        }

    }

    @Override
    public void createCours(Course course) {
        DbService dbService = new DbServiceImpl();
        if (dbService.createCours(course)){
            System.out.println("Успешно");
        }else{
            System.out.println("Ошибка создания курса");
        }


    }
    @Override
    public void registerStudentToGroup(StudentGroup studentGroup) {
        DbService dbService = new DbServiceImpl();
        if (dbService.registerStudentToGroup(studentGroup)){
            System.out.println("Успешно");
        }else {
            System.out.println("Ошибка при добавлении!");
        }

    }

    @Override
    public void coursesList(Course course) throws SQLException {
        DbService dbService = new DbServiceImpl();
        if (dbService.courseList(course)){
            System.out.println("Успешно");
        }else {
            System.out.println("Ошибка вывода списка курсов");

        }

    }

    @Override
    public void updateStudent(Student student) {
        DbService dbService = new DbServiceImpl();
        if (dbService.updateStudent(student)) {
            System.out.println("Успешно");
        } else {
            System.out.println("Ошибка при редактировании");

        }
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        DbService dbService = new DbServiceImpl();
        if (dbService.updateTeacher(teacher)) {
            System.out.println("Успешно");
        } else {
            System.out.println("Ошибка при редактировании");

        }

    }

    @Override
    public void updateCourse(Course course) {
        DbService dbService = new DbServiceImpl();
        if (dbService.updateCourse(course)) {
            System.out.println("Успешно");
        } else {
            System.out.println("Ошибка при редактировании");

        }

    }

    @Override
        public void deleteCourse ( int course_id){
            DbService dbService = new DbServiceImpl();
            if (dbService.deleteCourse(course_id)) {
                System.out.println("Успешно");
            } else {
                System.out.println("Ошибка при удалении курса");

            }
        }

    @Override
    public boolean checkCredentials(String login, String password) {
        return true;
    }

    @Override
    public void deleteGroup(int group_id) {
        DbService dbService = new DbServiceImpl();
        if (dbService.deleteGroup(group_id)){
            System.out.println("Успешно");
        }else {
            System.out.println("Ошибка при удалении группы");
        }
    }


    @Override
    public void deleteStudent(int id) {DbService dbService = new DbServiceImpl();
        if (dbService.deleteStudent(id)){
            System.out.println("Успешно");
        }else {
            System.out.println("Ошибка при удалении курса");

        }
        }


    @Override
    public void deleteTeacher(int id) {
        {
            DbService dbService = new DbServiceImpl();
            if (dbService.deleteTeacher(id)) {
                System.out.println("Успешно");
            } else {
                System.out.println("Ошибка при удалении курса");

            }
        }

    }

    @Override
    public List<GroupView> getGroupList() {

        DbService dbService = new DbServiceImpl();

        return dbService.getGroupList();
    }
}



