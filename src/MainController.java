import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.AdministratorSirvices;
import services.impl.AdministratorSirvicesImpl;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem menuItemCourses;

    @FXML
    private MenuItem menuItemGroups;

    @FXML
    private MenuItem menuItemStudents;

    @FXML
    private MenuItem menuItemTeachers;

    @FXML
    void onMenuItemCourses(ActionEvent event) {
        AdministratorSirvices sirvices = new AdministratorSirvicesImpl();
        Stage stage = new Stage();
        Parent parent = null;

        try {
            parent = FXMLLoader.load(getClass().getResource("courses/CourseManager.fxml"));
            stage.initModality(Modality.APPLICATION_MODAL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(parent));
        stage.show();

    }

    @FXML
    void onMenuItemGroups(ActionEvent event) {
        AdministratorSirvices sirvices = new AdministratorSirvicesImpl();
        Stage stage = new Stage();

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("groups/GroupManager.fxml"));
            Scene scene = new Scene(parent);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void onMenuItemStudents(ActionEvent event) {
        AdministratorSirvices sirvices = new AdministratorSirvicesImpl();
        Stage stage = new Stage();
        Parent parent = null;

        try {
            parent = FXMLLoader.load(getClass().getResource("students/StudentManager.fxml"));

            stage.initModality(Modality.APPLICATION_MODAL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(parent));
        stage.show();

    }

    @FXML
    void onMenuItemTeachers(ActionEvent event) {

        AdministratorSirvices sirvices = new AdministratorSirvicesImpl();
        Stage stage = new Stage();
        Parent parent = null;

        try {

            parent = FXMLLoader.load(getClass().getResource("teachers/TeacherManager.fxml"));

            stage.initModality(Modality.APPLICATION_MODAL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(parent));
        stage.show();

    }

    @FXML
    void initialize() {
        assert menuItemCourses != null : "fx:id=\"menuItemCourses\" was not injected: check your FXML file 'mainView.fxml'.";
        assert menuItemGroups != null : "fx:id=\"menuItemGroups\" was not injected: check your FXML file 'mainView.fxml'.";
        assert menuItemStudents != null : "fx:id=\"menuItemStudents\" was not injected: check your FXML file 'mainView.fxml'.";
        assert menuItemTeachers != null : "fx:id=\"menuItemTeachers\" was not injected: check your FXML file 'mainView.fxml'.";

    }
}
