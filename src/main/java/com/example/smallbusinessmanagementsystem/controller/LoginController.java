package com.example.smallbusinessmanagementsystem.controller;

import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.persistenceController.VartotojasPersistenceController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    public VartotojasPersistenceController vartotojasPersistenceController;

    //FXML
    private Stage stage;
    private Parent root;
    private Scene scene;

    public LoginController() {
        vartotojasPersistenceController = new VartotojasPersistenceController();
    }

    @FXML
    private Button buttonPrisijungti;

    @FXML
    private Button buttonRedaguoti;

    @FXML
    private TextField textFieldVardas;

    @FXML
    private TextField textFieldSlaptazodis;

    @FXML
    void prisijungti(ActionEvent event) throws IOException {
        if(vartotojasPersistenceController.getVartotojasListFromDatabase().isEmpty())
        {
            Vartotojas vartotojas = new Vartotojas("admin","admin");
            vartotojasPersistenceController.create(vartotojas);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/smallbusinessmanagementsystem/hello-view.fxml"));
        root = (Parent)fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();
    }

}
