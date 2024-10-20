module com.example.login_page_exp10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.login_page_exp10 to javafx.fxml;
    exports com.example.login_page_exp10;
}