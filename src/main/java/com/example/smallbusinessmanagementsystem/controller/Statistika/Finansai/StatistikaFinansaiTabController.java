package com.example.smallbusinessmanagementsystem.controller.Statistika.Finansai;

import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class StatistikaFinansaiTabController implements Initializable {
    WindowLoader windowLoader;
    WindowManager windowManager;
    public StatistikaFinansaiTabController()
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaFinansai()) {
            windowManager = new WindowManager();
            windowLoader = WindowLoader.getInstance();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(windowLoader.isTabStatistikaFinansai()) {

        }
    }
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
