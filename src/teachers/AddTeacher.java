package teachers;

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
import services.impl.AdministratorSirvicesImpl;

public class AddTeacher {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtAddress;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;
    private Teacher teacher;

    public void initData (Teacher teacher){
        this.teacher = teacher;
        txtName.setText(teacher.getName());
        txtAddress.setText(teacher.getAddress());
        txtPhone.setText(teacher.getPhone());


    }

    @FXML
    void onBtnClicked(ActionEvent event) {
        if(teacher == null){
            teacher = new Teacher();
        }
        AdministratorSirvices sirvices = new AdministratorSirvicesImpl();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();

        teacher.setName(name);
        teacher.setAddress(address);
        teacher.setPhone(phone);

        if (teacher.getId() == 0){
            sirvices.createTeacher(teacher);
        }else {
            sirvices.updateTeacher(teacher);
        }
        Stage stage = (Stage)(btnSave.getScene().getWindow());
        stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

    }

    @FXML
    void initialize() {
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'AddTeacher.fxml'.";
        assert txtPhone != null : "fx:id=\"txtPhone\" was not injected: check your FXML file 'AddTeacher.fxml'.";
        assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'AddTeacher.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'AddTeacher.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'AddTeacher.fxml'.";

    }
}
