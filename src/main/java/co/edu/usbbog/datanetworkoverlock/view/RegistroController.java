package co.edu.usbbog.datanetworkoverlock.view;

import co.edu.usbbog.datanetworkoverlock.controller.logic.PersonaBO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private TextField Tf_Nombre;
    @FXML
    private TextField Tf_Apellido;
    @FXML
    private TextField Tf_correo;
    @FXML
    private TextField Tf_usuario;
    @FXML
    private PasswordField PF_Password;
    @FXML
    private PasswordField PR_Password_2;

        PersonaBO registro;

    @FXML
    public void cerrar() {
        // get a handle to the stage
        stage = (Stage) btnClose.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    public void minimize(){
        stage = (Stage) btnMinimize.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void Switch1(ActionEvent event) throws IOException {

        String name = Tf_Nombre.getText();
        String ape = Tf_Apellido.getText();
        String cor = Tf_correo.getText();
        String usu = Tf_usuario.getText();
        String pas = PF_Password.getText();
        String contra = PR_Password_2.getText();

        if (pas.equals(contra)){
            System.out.println(registrar(name, ape, cor, usu, pas));

        }else {
            System.out.println("Las contraseñas no coinciden");
        }

        root = FXMLLoader.load(getClass().getResource("inicioSesion.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    public String registrar (String Tf_Nombre, String Tf_Apellido, String Tf_correo, String Tf_usuario, String PF_Password  ){
        return registro.crearPersona(Tf_usuario, Tf_Nombre, Tf_Apellido, PF_Password,Tf_correo);
    }

}
