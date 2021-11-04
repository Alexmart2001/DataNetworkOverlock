module co.edu.usbbog.datanetworkoverlock {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires mysql.connector.java;
    requires jsch;

    exports co.edu.usbbog.datanetworkoverlock.view;
    opens co.edu.usbbog.datanetworkoverlock.view to javafx.fxml;
    //exports co.edu.usbbog.datanetworkoverlock.controller;
    //opens co.edu.usbbog.datanetworkoverlock.controller to javafx.fxml;
    //exports co.edu.usbbog.datanetworkoverlock.model;
    //opens co.edu.usbbog.datanetworkoverlock.model to javafx.fxml;
}