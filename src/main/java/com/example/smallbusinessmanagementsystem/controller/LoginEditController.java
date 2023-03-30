package com.example.smallbusinessmanagementsystem.controller;

import com.example.smallbusinessmanagementsystem.persistenceController.VartotojasPersistenceController;
import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginEditController {

    public VartotojasPersistenceController vartotojasPersistenceController;
    public VartotojasService vartotojasService;

    //FXML
    private Stage stage;
    private Parent root;
    private Scene scene;

    public LoginEditController() {
        vartotojasPersistenceController = new VartotojasPersistenceController();
        vartotojasService = new VartotojasService();
    }

    @FXML
    private TextField TextFieldVardasSenas;

    @FXML
    private TextField TextFieldSlaptazodisSenas;

    @FXML
    private TextField TextFieldVardasNaujas;

    @FXML
    private TextField TextFieldSlaptazodisNaujas;

    @FXML
    private Button buttonKeistiDuomenis;

    @FXML
    private Button buttonAtgal;

    @FXML
    void griztiAtgal(ActionEvent event) {

    }

    @FXML
    void keistiDuomenis(ActionEvent event) {
        if(vartotojasService.vartotojasEgzistuoja(TextFieldVardasSenas.getText(), TextFieldSlaptazodisSenas.getText()))
        {
            vartotojasService.keistiVartotojoPrisijungima(TextFieldVardasSenas.getText(), TextFieldSlaptazodisSenas.getText(), TextFieldVardasNaujas.getText(), TextFieldSlaptazodisNaujas.getText());
        }
    }
}
