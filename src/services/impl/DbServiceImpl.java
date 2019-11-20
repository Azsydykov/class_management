package services.impl;

import model.*;
import services.DbService;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DbServiceImpl implements DbService {

    private Connection getConnection () throws SQLException {
        String sql = "jdbc:sqlite:db/calssdb.db";
        Connection connection = DriverManager.getConnection(sql);
        return connection;
    }

    @Override
    public boolean createCours(Course course) {
        try {
            Connection connection = getConnection();
            String sql = "Insert into courses (name, price, duration) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,course.getName());
            ps.setString(2,course.getPrice());
            ps.setString(3,course.getDuration());

            ps.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public boolean createGroup(Group group) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            Connection conn = getConnection();
            String sql = "insert into groups (course_id, teacher_id, start_date) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, group.getCourse().getId());
            ps.setInt(2, group.getTeacher().getId());
            ps.setString(3, group.getStartDate().toString());

            ps.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean appendTeacher(Teacher teacher) {
        try {
            Connection conn = getConnection();
            String sql = "insert into teachers (name, address, phone) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getAddress());
            ps.setString(3, teacher.getPhone());

            ps.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean appendStudent(Student student) {
        try {
            Connection conn = getConnection();
            String sql = "insert into students (name, address, phone) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getAddress());
            ps.setString(3, student.getPhone());

            ps.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean registerStudentToGroup(StudentGroup studentGroup) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            Connection conn = getConnection();
            String sql = "insert into student_groups (group_id, is_paid, student_id, pay_date, end_date ) values (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentGroup.getGroup_id());
            ps.setInt(2, studentGroup.getIs_paid());
            ps.setInt(3, studentGroup.getStudent_id());
            ps.setString(4, sdf.format(studentGroup.getPay_date()));
            ps.setString(5, studentGroup.getEnd_date().toString());


            ps.executeUpdate();

            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public boolean courseList(Course course) throws SQLException {

        return false;
    }

    @Override
    public List<Course> getCourseList() {
        List<Course> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("select course_id, name, price, duration from courses");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Course course = new Course(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3),resultSet.getString(4));
                list.add(course);
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    @Override
    public boolean deleteCourse(int course_id) {
        try {
            Connection connection = getConnection();
            String sql = "DELETE from courses where course_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,course_id);
            ps.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



    @Override
    public List<Student> getStudentList() {
        List<Student> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("select student_id, name, address, phone from students");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Student student = new Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public List<Teacher> getTeacherList() {
        List<Teacher> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("select teacher_id, name, address, phone from teachers");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Teacher teacher = new Teacher(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                list.add(teacher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Administrator> getAdministrator() {
        List<Administrator> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("select login, password from administrator");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Administrator administrator = new Administrator(resultSet.getString(1),resultSet.getString(2));
                list.add(administrator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public List<GroupView> getGroupList() {
        List<GroupView> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT g.group_id, t.teacher_id, c.course_id, c.name course_name, t.name teacher_name, g.start_date FROM groups g\n" +
                    "INNER JOIN teachers t on t.teacher_id = g.teacher_id\n" +
                    "INNER JOIN courses c on c.course_id = g.course_id;");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                int groupId = resultSet.getInt("group_id");
                int teacherId = resultSet.getInt("teacher_id");
                int courseId = resultSet.getInt("course_id");
                String courseName = resultSet.getString("course_name");
                String teacherName = resultSet.getString("teacher_name");
                String srartDate = resultSet.getString("start_date");

                GroupView groupView = new GroupView(groupId,teacherId,courseId,courseName,teacherName,srartDate);
                list.add(groupView);

            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public boolean deleteStudent(int id) {
        try {
            Connection connection = getConnection();
            String sql = "DELETE from students where student_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        public boolean updateStudent(Student student) {
            try {
                Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement("UPDATE students set name = ?, address = ?, phone = ? WHERE student_id = ? ");
                ps.setString(1, student.getName());
                ps.setString(2, student.getAddress());
                ps.setString(3, student.getPhone());
                ps.setInt(4, student.getId());

                ps.executeUpdate();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
                return false;

            }return true;
        }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE teachers set name = ?, address = ?, phone = ? WHERE teacher_id = ? ");
            ps.setString(1,teacher.getName());
            ps.setString(2,teacher.getAddress());
            ps.setString(3,teacher.getPhone());
            ps.setInt(4,teacher.getId());

            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCourse(Course course) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE courses set name = ?, price = ?, duration = ? WHERE course_id = ? ");
            ps.setString(1,course.getName());
            ps.setString(2,course.getPrice());
            ps.setString(3,course.getDuration());
            ps.setInt(4,course.getId());

            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteTeacher(int id) {
        try {
            Connection connection = getConnection();
            String sql = "DELETE from teachers where teacher_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteGroup(int group_id) {
        try {
            Connection connection = getConnection();
            String sql = "DELETE from groups where group_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,group_id);
            ps.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean compareLoginPassword(String login, int password) {
        return false;
    }

    // Login & Password
   /* @Override
    public boolean compareLoginPassword(String login, int password) {
        if(getAdministrator())

        }
        return true;
    }*/



}