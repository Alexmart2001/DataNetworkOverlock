package co.edu.usbbog.datanetworkoverlock.view;

import co.edu.usbbog.datanetworkoverlock.controller.logic.PersonaBO;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroController {

    private Stage stage;
    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView btnMinimize;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private TextField fieldNombre;
    @FXML
    private TextField fieldApellido;
    @FXML
    private TextField fieldCorreo;
    @FXML
    private TextField fieldUsuario;
    @FXML
    private PasswordField fieldPassword;
    @FXML
    private PasswordField fieldConfirmPassword;
    @FXML
    public Button btnRegistrarse;

    PersonaBO registro = new PersonaBO();

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
    public void registrar(ActionEvent event) {

        String name = fieldNombre.getText();
        String ape = fieldApellido.getText();
        String cor = fieldCorreo.getText();
        String usu = fieldUsuario.getText();
        String pas = fieldPassword.getText();
        String contra = fieldConfirmPassword.getText();

        if (pas.equals(contra)) {
            System.out.println(registrar(name, ape, cor, usu, pas));
            switchScenes(event);
        } else {
            System.out.println("Las contraseñas no coinciden");
        }
    }

    @FXML
    public void login(MouseEvent event) {
        switchScenes(event);
    }

    private void switchScenes(Event event) {
        try {
            root = FXMLLoader.load(getClass().getResource("inicioSesion.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene((Parent) root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public String registrar(String nombre, String apellido, String correo, String usuario, String password) {
        return registro.crearPersona(usuario, nombre, apellido, password, correo);
    }

}
