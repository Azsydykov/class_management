package groups;

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
import model.Group;
import model.GroupView;
import services.AdministratorSirvices;
import services.DbService;
import services.impl.AdministratorSirvicesImpl;
import services.impl.DbServiceImpl;

public class GroupManager {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Menu onMenuGroupsManager;

    @FXML
    private MenuItem addGroup;

    @FXML
    private MenuItem editGroup;

    @FXML
    private MenuItem deleteGroup;

    @FXML
    private TableView<GroupView> tableGroup;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTeacherName;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colCourseId;

    @FXML
    private TableColumn<?, ?> colTeacherId;

    @FXML
    void onMenuAddGroup(ActionEvent event) {
        AdministratorSirvices sirvices = new AdministratorSirvicesImpl();
        Stage stage = new Stage();
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("AddGroup.fxml"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOnCloseRequest(event1 -> refreshTable());
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    @FXML
    void onMenuDeleteGroup(ActionEvent event) {

    }

    @FXML
    void onMenuEditGroup(ActionEvent event) {

    }

    @FXML
    void initialize() {
        colID.setCellValueFactory(new PropertyValueFactory<>("groupId"));
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        colTeacherId.setCellValueFactory(new PropertyValueFactory<>("teacherId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        colTeacherName.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        refreshTable();
    }

    private void refreshTable() {
        AdministratorSirvices sirvices = new AdministratorSirvicesImpl();

        List<GroupView> list  = sirvices.getGroupList();

        ObservableList<GroupView> observableList = FXCollections.observableArrayList(list);
        tableGroup.setItems(observableList);

    }
}
