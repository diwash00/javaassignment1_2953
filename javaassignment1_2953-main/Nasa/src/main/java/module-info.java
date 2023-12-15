module com.example.nasa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.nasa to javafx.fxml;
    exports com.example.nasa;
    exports com.example.nasa.Utilities;
    opens com.example.nasa.Utilities to javafx.fxml;
    exports com.example.nasa.Model;
    opens com.example.nasa.Model to javafx.fxml;
    exports com.example.nasa.Controller;
    opens com.example.nasa.Controller to javafx.fxml;
}