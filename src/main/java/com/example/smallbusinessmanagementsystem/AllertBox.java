package com.example.smallbusinessmanagementsystem;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AllertBox {
    public static void display(String title, String message)
    {
        Stage window = new Stage();

        Label label = new Label();
        label.setText(message);
        label.setStyle("-fx-text-fill: white;");

        Button button = new Button("OK");
        button.setOnAction(e -> window.close());
        button.setStyle("-fx-background-color: #666666; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 1px;");
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #235a96; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 1px;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #666666; -fx-text-fill: white; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 1px;"));


        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        VBox layout = new VBox();
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #404040; -fx-padding: 10px;");

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
