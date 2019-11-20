package students;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Course;
import model.Student;
import services.AdministratorSirvices;
import services.DbService;
import services.impl.AdministratorSirvicesImpl;
import services.impl.DbServiceImpl;

public class StudentManager {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Menu onMenuStudentManager;

    @FXML
    private MenuItem addStudent;

    @FXML
    private MenuItem editStudent;

    @FXML
    private MenuItem deleteStudent;

    @FXML
    private TableView<Student> tableStudents;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colID;



    @FXML
    void onMenuAddStudent(ActionEvent event) {
        AdministratorSirvices sirvices = new AdministratorSirvicesImpl();
        Stage stage = new Stage();
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOnCloseRequest(event1 -> refreshTable());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(parent));
        stage.show();
    }



    @FXML
    void onMenuItemDelete(ActionEvent event) {
        if (event.getSource().equals(deleteStudent)) {
            DbService dbService = new DbServiceImpl();
            Student student = tableStudents.getSelectionModel().getSelectedItem();
            dbService.deleteStudent(student.getId());
            refreshTable();
        }else if (event.getSource().equals(addStudent)){

    }
    }

    @FXML
    void onMenuEditStudent(ActionEvent event){
    if (event.getSource().equals(editStudent)){
        updateStudent();
    }

    }
    private void updateStudent() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddStudent.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            Student student = tableStudents.getSelectionModel().getSelectedItem();
            stage.setOnCloseRequest(event1 -> refreshTable());

            AddStudent addStudent = loader.getController();
            addStudent.initData(student);


            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        refreshTable();


    }

    private void refreshTable() {
        tableStudents.setItems(null);
        DbService dbService = new DbServiceImpl();
        List<Student> list  = dbService.getStudentList();

        ObservableList<Student> observableList = FXCollections.observableArrayList(list);
        tableStudents.setItems(observableList);


    }
}
