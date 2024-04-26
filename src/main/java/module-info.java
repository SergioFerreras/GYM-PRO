module org.example.gympro {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens org.example.gympro to javafx.fxml;
    exports org.example.gympro;
    exports org.example.gympro.Clases;
    opens org.example.gympro.Clases to javafx.fxml;
    exports org.example.gympro.Controller;
    opens org.example.gympro.Controller to javafx.fxml;
    exports org.example.gympro.Exceptions;
    opens org.example.gympro.Exceptions to javafx.fxml;
}