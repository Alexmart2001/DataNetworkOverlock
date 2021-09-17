package co.edu.usbbog.datanetworkoverlock.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private ImageView btnOpciones;
    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView btnMinimize;

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
    public void desplegarMenu(ActionEvent event) {
        ContextMenu context = new ContextMenu();

        Menu item1 = new Menu("Usuario");
        MenuItem subItem11 = new MenuItem("Registrar");
        MenuItem subItem12 = new MenuItem("Eliminar");
        MenuItem subItem13 = new MenuItem("Consultar");
        item1.getItems().addAll(subItem11, subItem12, subItem13);


        MenuItem item2 = new MenuItem("Análisis");
        MenuItem item3 = new MenuItem("Reportes");
        item3.setOnAction(e -> {
            try {
                root = FXMLLoader.load(getClass().getResource("reportes.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        MenuItem item4 = new MenuItem("Backup");
        MenuItem item5 = new MenuItem("Restauración");

        context.getItems().addAll(item1, item2, item3, item4, item5);

        btnOpciones.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            if (t.getButton() == MouseButton.PRIMARY) context.show(btnOpciones, t.getSceneX(), t.getSceneY());
        });
    }

}
