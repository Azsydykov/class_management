import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.AdministratorSirvices;
import services.impl.AdministratorSirvicesImpl;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnEnter;

    @FXML
    private Button btnCancel;


    @FXML
    void onBtnClicked(ActionEvent event) {
        if(event.getSource().equals(btnEnter)){
            login();

        }else if (event.getSource().equals(btnCancel)){
            btnCancel.getScene().getWindow().hide();

        }

    }
    private void login() {
        String login = txtLogin.getText().trim();
        String password = txtPassword.getText().trim();

        System.out.println(login.isEmpty());
        System.out.println(password.isEmpty());



        if (login.isEmpty() || password.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Заполните все поля",ButtonType.OK);
            alert.show();
            return;
        }

        // по логину получаем весь объект Администратор
        // сравниваем пароли, если совпадают то заходим

        AdministratorSirvices sirvices = new AdministratorSirvicesImpl();

        if (sirvices.checkCredentials(login, password)) {

            // тут мы должны перейти в основное окно

            Stage stage = new Stage();

            try {
                Parent parent = FXMLLoader.load(getClass().getResource("mainView.fxml"));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(parent));
                stage.show();

                btnCancel.getScene().getWindow().hide();

            } catch (IOException e) {
                e.printStackTrace();


            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Неверный логин или пароль", ButtonType.OK);
            alert.show();
        }

    }}
