package com.example.smallbusinessmanagementsystem.controller.Login;

import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.utilities.CurrentVartotojas;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    public VartotojasService vartotojasService;
    public WindowManager windowManager;

    public LoginController() {
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

        if(vartotojasService.prisijungimasEgzistuoja(textFieldVardas.getText(),textFieldSlaptazodis.getText()))
        {
            CurrentVartotojas currentVartotojas = CurrentVartotojas.getInstance();
            currentVartotojas.setVartotojas(vartotojasService.getVartotojasByPrisijungimasSlaptazodis(textFieldVardas.getText(),textFieldSlaptazodis.getText()));
            windowManager.showTabFinansai(event);
        }

    }
    @FXML
    void redaguotiPaskyra(ActionEvent event) throws IOException {
        vartotojasService.createAdminIfNoUsers();
        windowManager.showLoginEdit(event);
    }

}
