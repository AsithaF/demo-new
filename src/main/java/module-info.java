module com.hardwareproject.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.hardwareproject.demo to javafx.fxml;
    exports com.hardwareproject.demo;
}