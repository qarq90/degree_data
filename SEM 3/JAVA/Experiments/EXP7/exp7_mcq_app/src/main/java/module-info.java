module com.example.exp7_mcq_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.exp7_mcq_app to javafx.fxml;
    exports com.example.exp7_mcq_app;
}
