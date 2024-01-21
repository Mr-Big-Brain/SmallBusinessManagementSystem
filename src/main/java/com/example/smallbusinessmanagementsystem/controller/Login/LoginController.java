package com.example.smallbusinessmanagementsystem.controller.Login;

import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.utilities.CurrentVartotojas;
import com.example.smallbusinessmanagementsystem.utilities.Md5Converter;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    public VartotojasService vartotojasService;
    public WindowManager windowManager;
    public Md5Converter md5Converter;
    public LoginController() {
        md5Converter = new Md5Converter();
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
    private PasswordField passwordFieldSlaptazodis;

    @FXML
    void prisijungti(ActionEvent event) throws IOException {
        vartotojasService.createAdminIfNoUsers();

        if(vartotojasService.prisijungimasEgzistuoja(textFieldVardas.getText(), md5Converter.getMD5Hash(passwordFieldSlaptazodis.getText())))
        {
            CurrentVartotojas currentVartotojas = CurrentVartotojas.getInstance();
            currentVartotojas.setVartotojas(vartotojasService.getVartotojasByPrisijungimasSlaptazodis(textFieldVardas.getText(), md5Converter.getMD5Hash(passwordFieldSlaptazodis.getText())));
            windowManager.showTabTvarkarastis(event);
        }
    }
    @FXML
    void redaguotiPaskyra(ActionEvent event) throws IOException {
        vartotojasService.createAdminIfNoUsers();
        windowManager.showLoginEdit(event);
    }

}
