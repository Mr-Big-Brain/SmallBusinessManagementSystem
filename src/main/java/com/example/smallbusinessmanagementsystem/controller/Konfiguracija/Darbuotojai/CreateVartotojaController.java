package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CreateVartotojaController {


    @FXML
    private TextField textFieldVardas;

    @FXML
    private TextField textFieldPavarde;

    @FXML
    private TextField textFieldTelefonas;

    @FXML
    private TextField textFieldApibrezimas;

    @FXML
    private TableView<?> tableViewRoles;

    @FXML
    private TableColumn<?, ?> columnRole;

    @FXML
    private Button buttonSukurti;

    @FXML
    private Button buttonAtgal;

    @FXML
    void atgal(ActionEvent event) {

    }

    @FXML
    void sukurti(ActionEvent event) {

    }
}
