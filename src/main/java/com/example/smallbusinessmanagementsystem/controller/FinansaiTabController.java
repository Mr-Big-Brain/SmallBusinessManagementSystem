package com.example.smallbusinessmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FinansaiTabController {
    @FXML
    private Button buttonNaujasFinansas;

    @FXML
    private Button buttonRedaguotiFinansa;

    @FXML
    private Button buttonIstrintiFinansa;

    @FXML
    private CheckBox checkBoxSuPardavimais;

    @FXML
    private Button buttonRastiFinansa;

    @FXML
    private TableView<?> tableViewFinansai;

    @FXML
    private TableColumn<?, ?> columnID;

    @FXML
    private TableColumn<?, ?> columnTipas;

    @FXML
    private TableColumn<?, ?> columnKiekis;

    @FXML
    private TableColumn<?, ?> columnPavadinimas;

    @FXML
    private TableColumn<?, ?> columnApibudinimas;

    @FXML
    private TableColumn<?, ?> columnData;

    @FXML
    private TableColumn<?, ?> columnZymes;

    @FXML
    private TableColumn<?, ?> columnDarbuotojas;

    @FXML
    private ChoiceBox<?> choiceBoxTipas;

    @FXML
    void istrintiFinansa(ActionEvent event) {

    }

    @FXML
    void naujasFinansas(ActionEvent event) {

    }

    @FXML
    void rastiFinansa(ActionEvent event) {

    }

    @FXML
    void redaguotiFinansa(ActionEvent event) {

    }
}
