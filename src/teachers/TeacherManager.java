package teachers;

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
import model.Teacher;
import services.AdministratorSirvices;
import services.DbService;
import services.impl.AdministratorSirvicesImpl;
import services.impl.DbServiceImpl;

public class TeacherManager {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Menu onMenuTeacherManager;

    @FXML
    private MenuItem addTeacher;

    @FXML
    private MenuItem editTeacher;

    @FXML
    private MenuItem menuItemDel;

    @FXML
    private TableView<Teacher> tableTeacher;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    void onMenuAddTeacher(ActionEvent event) {
        AdministratorSirvices sirvices = new AdministratorSirvicesImpl();
        Stage stage = new Stage();
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("AddTeacher.fxml"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOnCloseRequest(event1 -> refreshTable());
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onMenuEditTeacher(ActionEvent event) {
        if (event.getSource().equals(editTeacher)){
            updateTeacher();
        }

    }

    private void updateTeacher(){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTeacher.fxml"));

        try {
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            Teacher teacher = tableTeacher.getSelectionModel().getSelectedItem();
            stage.setOnCloseRequest(event -> refreshTable());

            AddTeacher addTeacher = loader.getController();
            addTeacher.initData(teacher);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onMenuItemDelete(ActionEvent event) {
        if (event.getSource().equals(menuItemDel)){
            DbService dbService = new DbServiceImpl();
            Teacher teacher = tableTeacher.getSelectionModel().getSelectedItem();
            dbService.deleteTeacher(teacher.getId());
            refreshTable();
        }else if (event.getSource().equals(addTeacher)){

    }}

    @FXML
    void initialize() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        refreshTable();
    }

    private void refreshTable() {
        DbService dbService = new DbServiceImpl();
        List<Teacher> list  = dbService.getTeacherList();

        ObservableList<Teacher> observableList = FXCollections.observableArrayList(list);
        tableTeacher.setItems(observableList);


    }
}
