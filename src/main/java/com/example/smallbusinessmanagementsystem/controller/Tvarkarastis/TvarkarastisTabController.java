package com.example.smallbusinessmanagementsystem.controller.Tvarkarastis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TvarkarastisTabController {
    @FXML
    private TableView<?> tableViewManoTvarkarastis;

    @FXML
    private TableColumn<?, ?> columnTvarkarastisManoDataNuo;

    @FXML
    private TableColumn<?, ?> columnTvarkarastisManoDataIki;

    @FXML
    private TableColumn<?, ?> columnTvarkarastisManoPavadinimas;

    @FXML
    private TableColumn<?, ?> columnTvarkarastisManoAprasymas;

    @FXML
    private DatePicker datePickerManoNuo;

    @FXML
    private DatePicker datePickerManoIki;

    @FXML
    private Button buttonManoSukurtiRengini;

    @FXML
    private Button buttonManoIstrintiRengini;

    @FXML
    private Button buttonManoAtnaujintiRengini;

    @FXML
    private TableView<?> tableViewSukurtasTvarkarastis;

    @FXML
    private TableColumn<?, ?> columnSukurtiDataNuo;

    @FXML
    private TableColumn<?, ?> columnTvarkarastisSukurtiDataIki;

    @FXML
    private TableColumn<?, ?> columnTvarkarastisSukurtiPavadinimas;

    @FXML
    private TableColumn<?, ?> columnTvarkarastisSukurtiAprasymas;

    @FXML
    private Button buttonSukurtiSukurtiRengini;

    @FXML
    private Button buttonSukurtiIstrintiRengini;

    @FXML
    private Button buttonSukurtiAtnaujintiRengini;

    @FXML
    void manoAtnaujintiRengini(ActionEvent event) {

    }

    @FXML
    void manoIstrintiRengini(ActionEvent event) {

    }

    @FXML
    void manoSukurtiRengini(ActionEvent event) {

    }

    @FXML
    void sukurtiAtnaujintiRengini(ActionEvent event) {

    }

    @FXML
    void sukurtiIstrintiRengini(ActionEvent event) {

    }

    @FXML
    void sukurtiSukurtiRengini(ActionEvent event) {

    }
}
