package com.example.smallbusinessmanagementsystem.controller.Login;

import com.example.smallbusinessmanagementsystem.persistenceController.VartotojasPersistenceController;
import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
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
    public VartotojasService vartotojasService;
    public WindowManager windowManager;

    //FXML
    private Stage stage;
    private Parent root;
    private Scene scene;

    public LoginController() {
        vartotojasPersistenceController = new VartotojasPersistenceController();
        vartotojasService = new VartotojasService();
        windowManager = new WindowManager();
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
        vartotojasService.createAdminIfNoUsers();
        windowManager.showTabFinansai(event);
    }
    @FXML
    void redaguotiPaskyra(ActionEvent event) throws IOException {
        vartotojasService.createAdminIfNoUsers();
        windowManager.showLoginEdit(event);
    }

}
