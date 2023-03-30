package com.example.smallbusinessmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PardavimaiTabController {
    @FXML
    private Button buttonNaujasPardavimas;

    @FXML
    private Button buttonRedaguotiPardavima;

    @FXML
    private Button buttonIstrintiPardavima;

    @FXML
    private Button buttonRastiPardavima;

    @FXML
    private TableView<?> tableVIewPardavimai;

    @FXML
    private TableColumn<?, ?> columnPardavimaiID;

    @FXML
    private TableColumn<?, ?> columnPardavimaiData;

    @FXML
    private TableColumn<?, ?> columnPardavimaiSuma;

    @FXML
    private TableColumn<?, ?> columnPardavimaiDarbuotojas;

    @FXML
    private TableColumn<?, ?> columnPardavimaiPirkejas;

    @FXML
    private DatePicker datePickerNuo;

    @FXML
    private DatePicker datePickerIki;

    @FXML
    void istrintiPardavima(ActionEvent event) {

    }

    @FXML
    void naujasPardavimas(ActionEvent event) {

    }

    @FXML
    void rastiPardavima(ActionEvent event) {

    }

    @FXML
    void redaguotiPardavima(ActionEvent event) {

    }

}
