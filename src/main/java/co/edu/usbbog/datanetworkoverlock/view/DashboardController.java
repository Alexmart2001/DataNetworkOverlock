package co.edu.usbbog.datanetworkoverlock.view;

import co.edu.usbbog.datanetworkoverlock.controller.config.HostInfo;
import co.edu.usbbog.datanetworkoverlock.controller.logic.ConexionSSH;
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
import java.net.ServerSocket;
import java.net.Socket;

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
    private ImageView btnAddUser;
    @FXML
    private ImageView btnReport;
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

    static ServerSocket server;
    static Socket client;
    static DataInputStream flujoEntrada;
    static DataOutputStream flujoSalida;
    static String entrada = "";
    static String salida = "";
    static int port = 9000;

    public void readSocket() {
        //Task<String> concurrentTask = new Task<String>() {
        //    @Override
        //    protected String call() {
        //        return new ConexionSSH().ejecutarComando(
        //                HostInfo.USER.getValue(),
        //                HostInfo.PASSWORD.getValue(),
        //                HostInfo.HOST.getValue(),
        //                Integer.parseInt(HostInfo.PORT.getValue()),
        //                command
        //        );
        //    }
        //};
        //concurrentTask.setOnSucceeded(event -> codeArea.appendText(concurrentTask.getValue()));
        //new Thread(concurrentTask).start();


        //try {
        //    server = new ServerSocket(port);
        //    client = server.accept();
        //    flujoEntrada = new DataInputStream(client.getInputStream());
        //    flujoSalida = new DataOutputStream(client.getOutputStream());
        //    int i = 0;
        //    while (true) {
        //        entrada = flujoEntrada.readUTF();
        //        System.out.println("Recibiendo: " + entrada);
        //        codeArea.appendText(entrada);
        //        System.out.println("counter: " + i++);
        //    }
        //} catch (IOException e) {
        //    e.printStackTrace();
        //    System.out.println("Error de sockets");
        //}
    }

    public void writeSocket(String command) {
        //try {
        //    salida = command;
        //    flujoSalida.writeUTF(salida);
        //    System.out.println("Enviando: " + salida);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //    System.out.println("Error de sockets");
        //}
    }

    @FXML
    public void execute(KeyEvent event) {
        String mensaje, command;
        if (event.getCode() == KeyCode.ENTER) {
            //command = codeArea.getText();
            //int index = command.indexOf('$');
            //writeSocket(command.substring(index));
            //System.out.println(command.substring(index));
            mensaje = "Starting Nmap 7.91 ( https://nmap.org ) at 2021-11-08 12:20 -05\n" +
                    "Nmap scan report for 192.168.1.5\n" +
                    "Host is up (0.00038s latency).\n" +
                    "Not shown: 997 filtered ports\n" +
                    "PORT     STATE SERVICE\n" +
                    "3306/tcp open  mysql\n" +
                    "5357/tcp open  wsdapi\n" +
                    "7070/tcp open  realserver\n" +
                    "MAC Address: 28:39:26:2C:FA:5D (CyberTAN Technology)\n" +
                    "\n" +
                    "Nmap done: 1 IP address (1 host up) scanned in 4.29 seconds \n";
            try {
                Thread.sleep(4000);
                codeArea.appendText(mensaje);
                codeArea.appendText("\n");
            } catch (InterruptedException e) {
                System.out.println("Error en el thread: " + e);
            } finally {
                codeArea.appendText("admin@dno-$ ");
            }
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

    @FXML
    public void switchUser(MouseEvent event) {
        switchScenes(event, "registro.fxml");
    }

    @FXML
    public void switchReports(MouseEvent event) {
        switchScenes(event, "reportes.fxml");
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
