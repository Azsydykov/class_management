package groups;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Course;
import model.Group;
import model.Student;
import model.Teacher;
import services.AdministratorSirvices;
import services.DbService;
import services.impl.AdministratorSirvicesImpl;
import services.impl.DbServiceImpl;

public class AddGroup {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Course> cmbCourses;

    @FXML
    private ComboBox<Teacher> cmbTeachers;

    @FXML
    private DatePicker btnDate;
    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    void onBtnClicked(ActionEvent event) {
        if (event.getSource().equals(btnSave)){
            Course course = cmbCourses.getSelectionModel().getSelectedItem();
            Teacher teacher = cmbTeachers.getSelectionModel().getSelectedItem();
            LocalDate localDate = LocalDate.from(btnDate.getValue());

            Group group = new Group(course.getId(),teacher.getId(),localDate);
            DbService dbService = new DbServiceImpl();
            dbService.createGroup(group);
            Stage stage = (Stage)(btnSave.getScene().getWindow());
            stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));


        }

    }

    @FXML
    void initialize() {
        DbService dbService = new DbServiceImpl();
        List<Course> list = dbService.getCourseList();
        for (Course item:list ) {
            System.out.println(item.getName());

        }
        ObservableList<Course> observableList = FXCollections.observableArrayList(list);
        cmbCourses.setItems(observableList);

        List<Teacher> list1 = dbService.getTeacherList();
        for (Teacher item1:list1) {
            System.out.println(item1.getName());
        }
        ObservableList<Teacher> observableList1 = FXCollections.observableList(list1);
        cmbTeachers.setItems(observableList1);


    }
}
