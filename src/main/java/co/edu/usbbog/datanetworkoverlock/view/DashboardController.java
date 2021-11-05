package co.edu.usbbog.datanetworkoverlock.view;

import co.edu.usbbog.datanetworkoverlock.controller.config.HostInfo;
import co.edu.usbbog.datanetworkoverlock.controller.logic.ConexionSSH;
import com.jcraft.jsch.SocketFactory;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.Key;

public class DashboardController {

    @FXML
    private Parent root;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private ImageView btnOpciones;
    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView btnMinimize;
    @FXML
    public Label btnNmap;
    @FXML
    public Label btnSnort;
    @FXML
    public Label btnKismet;
    @FXML
    public TextArea codeArea;


    SocketFactory socketFactory;
    Socket socket;
    DataInputStream entrada;
    DataOutputStream salida;
    String linea;

    public void readSocket(String command) {
        Task<String> concurrentTask = new Task<String>() {
            @Override
            protected String call() {
                return new ConexionSSH().ejecutarComando(
                        HostInfo.USER.getValue(),
                        HostInfo.PASSWORD.getValue(),
                        HostInfo.HOST.getValue(),
                        Integer.parseInt(HostInfo.PORT.getValue()),
                        command
                );
            }
        };

        concurrentTask.setOnSucceeded(event -> codeArea.appendText(concurrentTask.getValue()));

        new Thread(concurrentTask).start();

        //try {
        //    socket = socketFactory.createSocket(HostInfo.HOST.getValue(), 9000);
        //    entrada = new DataInputStream(socketFactory.getInputStream(socket));
        //    salida = new DataOutputStream(socketFactory.getOutputStream(socket));
        //    while (true) {
        //        linea = entrada.readUTF();
        //        System.out.println("Recibiendo: " + linea);
        //        //codeArea.appendText(linea);
        //    }
        //} catch (IOException e) {
        //    e.printStackTrace();
        //    System.out.println("Error de sockets");
        //}
    }

    public void writeSocket() {
        //try {
//
        //} catch (IOException e) {
        //    e.printStackTrace();
        //    System.out.println("Error de sockets");
        //}
    }

    @FXML
    public void execute(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String command = codeArea.getText();
            int index = command.indexOf('$');
            readSocket(command.substring(index));
            System.out.println(command.substring(index));
        }
    }

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
        MenuItem item4 = new MenuItem("Backup");
        MenuItem item5 = new MenuItem("Restauración");

        item3.setOnAction(e -> switchScenes(event, "reportes.fxml"));

        context.getItems().addAll(item1, item2, item3, item4, item5);

        btnOpciones.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            if (t.getButton() == MouseButton.PRIMARY)
                context.show(btnOpciones, t.getSceneX(), t.getSceneY());
        });
    }

    private void switchScenes(Event event, String target) {
        try {
            root = FXMLLoader.load(getClass().getResource(target));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
