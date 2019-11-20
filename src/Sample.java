import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Course;
import services.AdministratorSirvices;
import services.impl.AdministratorSirvicesImpl;

public class Sample {

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
    void btnSave(ActionEvent event) {
        AdministratorSirvices service = new AdministratorSirvicesImpl();
        String name = txtName.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int duration = Integer.parseInt(txtDuration.getText());
        Course course = new Course(name, price, duration);
        service.createCours(course);
    }



    @FXML
    void initialize() {
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtPrice != null : "fx:id=\"txtPrice\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtDuration != null : "fx:id=\"txtDuration\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'Sample.fxml'.";

    }
}
