package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Produktai;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class KonfiguracijaProduktaiTabController {
    @FXML
    private TableView<?> tableViewProduktai;

    @FXML
    private TableColumn<?, ?> columnProduktaiID;

    @FXML
    private TableColumn<?, ?> columnProduktaiPavadinimas;

    @FXML
    private TableColumn<?, ?> columnProduktaiPirkimoKaina;

    @FXML
    private TableColumn<?, ?> columnProduktaiRekomenduojamaKaina;

    @FXML
    private TableView<?> tableViewZymes;

    @FXML
    private TableColumn<?, ?> columnZyme;

    @FXML
    private Button buttonProduktaiPrideti;

    @FXML
    private Button buttonProduktaiRedaguoti;

    @FXML
    private Button buttonProduktaiIštrinti;

    @FXML
    private Button buttonZymePrideti;

    @FXML
    private Button buttonZymeIstrinti;

    @FXML
    void istrintiProdukta(ActionEvent event) {

    }

    @FXML
    void istrintiZyme(ActionEvent event) {

    }

    @FXML
    void pridetiProdukta(ActionEvent event) {

    }

    @FXML
    void pridetiZyme(ActionEvent event) {

    }

    @FXML
    void redaguotiProdukta(ActionEvent event) {

    }
}