module com.example.maketstock {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.maketstock to javafx.fxml;
    exports com.example.maketstock;
}