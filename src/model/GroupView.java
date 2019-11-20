package model;

public class GroupView {
    private int groupId;
    private int teacherId;
    private int courseId;
    private String courseName;
    private String teacherName;
    private String startDate;

    public GroupView(int groupId, int teacherId, int courseId, String courseName, String teacherName, String startDate) {
        this.groupId = groupId;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.startDate = startDate;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
