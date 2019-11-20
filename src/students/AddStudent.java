package students;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Student;
import model.Teacher;
import services.AdministratorSirvices;
import services.DbService;
import services.impl.AdministratorSirvicesImpl;
import services.impl.DbServiceImpl;

public class AddStudent {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtPhone;

    @FXML
    private Button btnSave;

    private Student student;



    @FXML
    private Button btnCancel;



    public void initData (Student student){
        this.student = student;
        txtName.setText(student.getName());
        txtAddress.setText(student.getAddress());
        txtPhone.setText(student.getPhone());
    }


    @FXML
    void onBtnClicked(ActionEvent event) {
        if(student == null){
            student = new Student();
        }

        AdministratorSirvices sirvices = new AdministratorSirvicesImpl();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();

        student.setName(name);
        student.setAddress(address);
        student.setPhone(phone);

        if (student.getId() == 0){
            sirvices.createStudent(student);
        }else {
            sirvices.updateStudent(student);
        }
        Stage stage = (Stage)(btnSave.getScene().getWindow());
        stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

    }

    @FXML
    void initialize() {
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'AddStudent.fxml'.";
        assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'AddStudent.fxml'.";
        assert txtPhone != null : "fx:id=\"txtPhone\" was not injected: check your FXML file 'AddStudent.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'AddStudent.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'AddStudent.fxml'.";

    }
}
