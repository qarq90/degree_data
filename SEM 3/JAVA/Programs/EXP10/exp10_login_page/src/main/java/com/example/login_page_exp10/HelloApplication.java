package com.example.login_page_exp10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Login Page");

        Label labelUsername = new Label("Username:");
        Label labelPassword = new Label("Password:");
        TextField textFieldUsername = new TextField();
        PasswordField passwordField = new PasswordField();
        Button buttonLogin = new Button("Login");
        Button buttonReset = new Button("Reset");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(labelUsername, 0, 0);
        gridPane.add(textFieldUsername, 1, 0);
        gridPane.add(labelPassword, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(buttonLogin, 0, 2);
        gridPane.add(buttonReset, 1, 2);

        buttonLogin.setOnAction(e -> {
            String username = textFieldUsername.getText();
            String password = passwordField.getText();

            if (username.equals("qarq90") && password.equals("iLoveGymMommies")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Login Successful!");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Username or Password");
                alert.show();
            }
        });

        buttonReset.setOnAction(e -> {
            textFieldUsername.clear();
            passwordField.clear();
        });

        Scene scene = new Scene(gridPane, 300, 150);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
