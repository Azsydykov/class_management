import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import services.AdministratorSirvices;
import services.DbService;
import services.impl.AdministratorSirvicesImpl;
import services.impl.DbServiceImpl;

import java.util.Date;
import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

        AdministratorSirvices service = new AdministratorSirvicesImpl();
       // Course course = new Course("French", 1500, 5);
        // service.createCours(course);


       // Teacher teacher = new Teacher("Кубат", "0555905886","Суйунбаева 123",null);
       //service.createTeacher(teacher);

       // Student student = new Student("Айбек", "Московского 21", "0772405886",null);
        //service.createStudent(student);

        //StudentGroup studentGroup = new StudentGroup(1,1000,1,new Date(),"30.09.2019");
       // service.registerStudentToGroup(studentGroup);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loginView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}





