package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai;

import com.example.smallbusinessmanagementsystem.service.VartotojoTipasService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateVartotojoRoleController {

    VartotojoTipasService vartotojoTipasService;

    //FXML
    private Stage stage;
    private Parent root;
    private Scene scene;

    public CreateVartotojoRoleController()
    {
        vartotojoTipasService = new VartotojoTipasService();
    }
    @FXML
    private CheckBox checkBoxPardavimai;

    @FXML
    private CheckBox checkBoxFinansai;

    @FXML
    private CheckBox checkBoxSandelis;

    @FXML
    private CheckBox checkBoxKlientai;

    @FXML
    private CheckBox checkBoxStatistika;

    @FXML
    private CheckBox checkBoxKonfiguracija;

    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private Button buttonSukurti;

    @FXML
    private Button buttonAtgal;

    @FXML
    void atgal(ActionEvent event) {

    }

    @FXML
    void sukurti(ActionEvent event) {
        vartotojoTipasService.sukurtiNaujaVartotojoTipa(
                textFieldPavadinimas.getText(),checkBoxFinansai.isSelected(),
                checkBoxKlientai.isSelected(),checkBoxKonfiguracija.isSelected(),
                checkBoxPardavimai.isSelected(),checkBoxSandelis.isSelected(),checkBoxStatistika.isSelected());
    }
}
