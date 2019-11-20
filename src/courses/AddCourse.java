package courses;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Course;
import model.Student;
import services.AdministratorSirvices;
import services.DbService;
import services.impl.AdministratorSirvicesImpl;
import services.impl.DbServiceImpl;

public class AddCourse {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtDuration;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;
    private Course cource;


    public void initData (Course course){
        this.cource = course;
        txtName.setText(course.getName());
        txtPrice.setText(course.getPrice());
        txtDuration.setText(course.getDuration());
    }

    @FXML
    void onBtnClicked(ActionEvent event) {
        if(cource == null){
            cource = new Course();
        }
        AdministratorSirvices sirvices = new AdministratorSirvicesImpl();
        String cource_name = txtName.getText();
        String price = txtPrice.getText();
        String duration = txtDuration.getText();

        cource.setName(cource_name);
        cource.setPrice(price);
        cource.setDuration(duration);

        if (cource.getId() == 0){
            sirvices.createCours(cource);
        }else {
            sirvices.updateCourse(cource);
        }
        Stage stage = (Stage)(btnSave.getScene().getWindow());
        stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

    }



    @FXML
    void initialize() {
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'AddCourse.fxml'.";
        assert txtPrice != null : "fx:id=\"txtPrice\" was not injected: check your FXML file 'AddCourse.fxml'.";
        assert txtDuration != null : "fx:id=\"txtDuration\" was not injected: check your FXML file 'AddCourse.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'AddCourse.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'AddCourse.fxml'.";


    }



}
