package com.example.smallbusinessmanagementsystem.controller.Statistika.Produktai;

import com.example.smallbusinessmanagementsystem.service.ZymeService;
import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class StatistikaProduktaiTabController implements Initializable {
    WindowLoader windowLoader;
    String testStringg;
    public StatistikaProduktaiTabController()
    {
        testStringg = "heheBoy";
        windowLoader = WindowLoader.getInstance();
    }
    public StatistikaProduktaiTabController(String testString)
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaProduktai()) {
            testStringg = testString;
            System.out.println(testString + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(windowLoader.isTabStatistikaProduktai()) {
            buttonPridetiProdukta.setText(testStringg);
        }
    }
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
        System.out.println(testStringg + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

}
