package courses;

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
import services.AdministratorSirvices;
import services.DbService;
import services.impl.AdministratorSirvicesImpl;
import services.impl.DbServiceImpl;

public class CourseManager {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Menu onMenuCourseManager;

    @FXML
    private MenuItem addCourse;

    @FXML
    private MenuItem editCourse;

    @FXML
    private MenuItem deleteCourse;

    @FXML
    private TableView<Course> tableCousres;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private MenuItem menuItemDel;



    @FXML
    void onMenuItemDelete(ActionEvent event) {
        if (event.getSource().equals(menuItemDel)){
            DbService dbService = new DbServiceImpl();
            Course course = tableCousres.getSelectionModel().getSelectedItem();
            System.out.println("id = " + course.getId());
            dbService.deleteCourse(course.getId());
            refreshTable();
        }else if (event.getSource().equals(addCourse)){

        }

    }


    @FXML
    void onMenuAddCourse(ActionEvent event) {
        AdministratorSirvices sirvices = new AdministratorSirvicesImpl();
        Stage stage = new Stage();
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("AddCourse.fxml"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOnCloseRequest(event1 -> refreshTable());
            stage.setScene(new Scene(parent));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onMenuDeleteCourse(ActionEvent event) {

    }

    @FXML
    void onMenuEditCourse(ActionEvent event) {
        if (event.getSource().equals(editCourse)){
            updateCourse();
        }

    }

    private void updateCourse() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCourse.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            Course course = tableCousres.getSelectionModel().getSelectedItem();
            stage.setOnCloseRequest(event -> refreshTable());
            AddCourse addCourse = loader.getController();
            addCourse.initData(course);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void initialize() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));

        refreshTable();
    }

    private void refreshTable() {
        DbService dbService = new DbServiceImpl();
        List<Course> list  = dbService.getCourseList();

        ObservableList<Course> observableList = FXCollections.observableArrayList(list);
        tableCousres.setItems(observableList);
    }
}
