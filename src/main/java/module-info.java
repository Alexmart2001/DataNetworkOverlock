module co.edu.usbbog.datanetworkoverlock {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens co.edu.usbbog.datanetworkoverlock to javafx.fxml;
    //exports co.edu.usbbog.datanetworkoverlock;
    exports co.edu.usbbog.datanetworkoverlock.main;
    opens co.edu.usbbog.datanetworkoverlock.main to javafx.fxml;
    exports co.edu.usbbog.datanetworkoverlock.controller;
    opens co.edu.usbbog.datanetworkoverlock.controller to javafx.fxml;
    exports co.edu.usbbog.datanetworkoverlock.model;
    opens co.edu.usbbog.datanetworkoverlock.model to javafx.fxml;
}