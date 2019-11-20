package services;

import model.*;

import java.sql.SQLException;
import java.util.List;

public interface AdministratorSirvices {

    void createStudent (Student student);
    void unRegisterStudent (Student student, Group group);
    void getPayment(Student student,Group group);
    void paySalary(Teacher teacher);
    void createGroup(Group group);
    void createTeacher(Teacher teacher);
    void createCours (Course course);
    void registerStudentToGroup (StudentGroup studentGroup);
    void coursesList (Course course) throws SQLException;
    void updateStudent (Student student);
    void updateTeacher (Teacher teacher);
    void updateCourse (Course course);

    void deleteCourse(int course_id);

    boolean checkCredentials(String login, String password);

    void deleteGroup(int group_id);
    void deleteStudent(int student_id);
    void deleteTeacher(int teacher_id);
    List<GroupView> getGroupList();
}
