package co.edu.usbbog.datanetworkoverlock.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;

public class InicioSesionController {
    @FXML
    private ImageView Btn_close;
    @FXML
    private  ImageView Btn_minimizar;
    @FXML
    private Stage stage;
    @FXML
    private Object root;
    @FXML
    private Scene scene;

    @FXML
    public void cerrar() {
        // get a handle to the stage
        stage = (Stage) Btn_close.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    @FXML
    public void minimize(){
        stage = (Stage) Btn_minimizar.getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    public void Switch1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();
    }
}
