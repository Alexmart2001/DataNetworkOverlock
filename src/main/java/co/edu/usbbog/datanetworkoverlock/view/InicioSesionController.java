package co.edu.usbbog.datanetworkoverlock.view;

import co.edu.usbbog.datanetworkoverlock.controller.logic.PersonaBO;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;

public class InicioSesionController {

    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView btnMinimize;
    @FXML
    public TextField fieldUser;
    @FXML
    public PasswordField fieldPassword;
    @FXML
    public Button btnAcceder;
    @FXML
    public Label btnRegistro;
    @FXML
    public CheckBox check;

    PersonaBO persona = new PersonaBO();

    @FXML
    public void cerrar() {
        stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void minimize() {
        stage = (Stage) btnMinimize.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void login(ActionEvent event) {
        String username = fieldUser.getText();
        String password = fieldPassword.getText();

        if (persona.buscarPersona(username, password) != null) {
            switchScenes(event, "dashboard.fxml");
        } else {
            System.out.println("El usuario o la clave no coinciden");
            fieldUser.setText("");
            fieldPassword.setText("");
        }
    }

    @FXML
    public void switchRegistro(MouseEvent event) {
        switchScenes(event, "registro.fxml");
    }

    private void switchScenes(Event event, String target) {
        try {
            root = FXMLLoader.load(getClass().getResource(target));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene((Parent) root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

}
