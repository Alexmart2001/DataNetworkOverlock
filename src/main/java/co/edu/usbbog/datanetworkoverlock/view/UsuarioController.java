package co.edu.usbbog.datanetworkoverlock.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class UsuarioController {
    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView btnMinimize;
    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private ImageView Btn_Dash;

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
        root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void SwitchR(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("reportes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();
    }
}
