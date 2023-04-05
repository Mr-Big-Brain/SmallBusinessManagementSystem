package com.example.smallbusinessmanagementsystem.controller.Statistika.Finansai;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;

public class StatistikaFinansaiTabController {
    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private TableView<?> tableVIewZymes;

    @FXML
    private TableColumn<?, ?> columnZyme;

    @FXML
    private Button buttonTop;

    @FXML
    private Button buttonPridėti;

    @FXML
    private Button buttonPašalinti;

    @FXML
    private DatePicker datePickerNuo;

    @FXML
    private DatePicker datePickerIki;

    @FXML
    private ChoiceBox<?> choiceBoxType;

    @FXML
    private Button buttonRodyti;

    @FXML
    void pasalinti(ActionEvent event) {

    }

    @FXML
    void prideti(ActionEvent event) {

    }

    @FXML
    void rodyti(ActionEvent event) {

    }

    @FXML
    void top(ActionEvent event) {

    }
}
