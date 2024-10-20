module com.example.exp10_bank_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.exp10_bank_app to javafx.fxml;
    exports com.example.exp10_bank_app;
}
