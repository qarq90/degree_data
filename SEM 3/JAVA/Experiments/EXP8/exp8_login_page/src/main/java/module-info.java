module com.example.exp8_login_page {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.exp8_login_page to javafx.fxml;
    exports com.example.exp8_login_page;
}
