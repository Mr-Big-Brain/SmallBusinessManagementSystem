package com.example.smallbusinessmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 365, 401);
        stage.setScene(scene);
        stage.setTitle("Prisijungimas");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}