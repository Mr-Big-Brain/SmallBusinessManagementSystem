package com.example.smallbusinessmanagementsystem.controller.Statistika.Zymes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StatistikaZymesTabController {
    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private TableView<?> tableViewZymes;

    @FXML
    private TableColumn<?, ?> columnZyme;

    @FXML
    private Button buttonTop;

    @FXML
    private Button buttonPrideti;

    @FXML
    private DatePicker datePickerNuo;

    @FXML
    private DatePicker datePickerIki;

    @FXML
    private Button buttonIstrinti;

    @FXML
    void istrinti(ActionEvent event) {

    }

    @FXML
    void prideti(ActionEvent event) {

    }

    @FXML
    void top(ActionEvent event) {

    }

}
