module co.edu.usbbog.datanetworkoverlock {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens co.edu.usbbog.datanetworkoverlock to javafx.fxml;
    exports co.edu.usbbog.datanetworkoverlock;
    exports co.edu.usbbog.datanetworkoverlock.programa;
    opens co.edu.usbbog.datanetworkoverlock.programa to javafx.fxml;
}