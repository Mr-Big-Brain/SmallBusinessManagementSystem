package com.example.smallbusinessmanagementsystem.controller.Statistika.Produktai;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StatistikaProduktaiTabController {
    @FXML
    private LineChart<?, ?> lineChartProduktai;

    @FXML
    private TableView<?> tableViewProduktai;

    @FXML
    private TableColumn<?, ?> columnProduktas;

    @FXML
    private Button buttonPridetiProdukta;

    @FXML
    private Button buttonPašalintiProdukta;

    @FXML
    private DatePicker datePickerNuo;

    @FXML
    private DatePicker datePickerIki;

    @FXML
    void pasalintiProdukta(ActionEvent event) {

    }

    @FXML
    void pridetiProdukta(ActionEvent event) {

    }

}
