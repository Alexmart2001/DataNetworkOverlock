package co.edu.usbbog.datanetworkoverlock.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private ImageView Btn_close;
    @FXML
    private ImageView Btn_minimize;

    @FXML
    public void cerrar() {
        // get a handle to the stage
        Stage stage = (Stage) Btn_close.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    public void minimize(){
        Stage stage = (Stage) Btn_minimize.getScene().getWindow();
        stage.setIconified(true);
    }

}
