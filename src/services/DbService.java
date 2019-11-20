package services;

import model.*;

import java.sql.SQLException;
import java.util.List;

public interface DbService {



    boolean createCours(Course course);
    boolean createGroup (Group group);
    boolean appendTeacher(Teacher teacher);
    boolean appendStudent(Student student);
    boolean registerStudentToGroup(StudentGroup studentGroup);
    boolean courseList (Course course) throws SQLException;

    boolean deleteCourse(int course_id);
    boolean deleteStudent(int student_id);
    boolean deleteTeacher(int teacher_id);
    boolean deleteGroup(int group_id);
    boolean compareLoginPassword (String login, int password);
    boolean updateStudent (Student student);
    boolean updateTeacher (Teacher teacher);
    boolean updateCourse (Course course);
    List<Course> getCourseList();
    List<Student> getStudentList();
    List<Teacher> getTeacherList();
    List<Administrator> getAdministrator();
    List<GroupView> getGroupList();





}
