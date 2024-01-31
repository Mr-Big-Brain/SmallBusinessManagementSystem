package com.example.smallbusinessmanagementsystem.controller.Statistika.Klientai;

import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class StatistikaKlientaiTabController implements Initializable {
    WindowLoader windowLoader;
    WindowManager windowManager;
    public StatistikaKlientaiTabController()
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaKlientai()) {
            windowManager = new WindowManager();
            windowLoader = WindowLoader.getInstance();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(windowLoader.isTabStatistikaKlientai()) {

        }
    }
    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private TableView<?> tableViewKlientai;

    @FXML
    private TableColumn<?, ?> columnKlientas;

    @FXML
    private TableView<?> tableViewZymes;

    @FXML
    private TableColumn<?, ?> columnZyme;

    @FXML
    private Button buttonTop;

    @FXML
    private Button buttonPrideti;

    @FXML
    private Button buttonIstrinti;

    @FXML
    private Button buttonRodyti;

    @FXML
    private DatePicker datePickerNuo;

    @FXML
    private DatePicker datePickerIki;

    @FXML
    void Istrinti(ActionEvent event) {

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
