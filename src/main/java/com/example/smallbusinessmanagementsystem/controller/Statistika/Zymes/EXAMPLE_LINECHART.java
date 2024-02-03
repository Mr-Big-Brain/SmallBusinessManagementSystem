package com.example.smallbusinessmanagementsystem.controller.Statistika.Zymes;

import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class EXAMPLE_LINECHART implements Initializable {
    WindowLoader windowLoader;
    WindowManager windowManager;

    public EXAMPLE_LINECHART() {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaZymes()) {
            windowManager = new WindowManager();
            windowLoader = WindowLoader.getInstance();
        }
    }

    @FXML
    private LineChart<String, Number> lineChart;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(windowLoader.isTabStatistikaZymes()) {
            NumberAxis xAxis = new NumberAxis();
            NumberAxis yAxis = new NumberAxis();


            lineChart.setTitle("Line Chart Example");
            xAxis.setLabel("X Axis Label");
            yAxis.setLabel("Y Axis Label");

            XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
            XYChart.Series<String, Number> dataSeries2 = new XYChart.Series<>();
            dataSeries.setName("Data Series");
            dataSeries2.setName("Data Series 2");

            // Add data points to the series
            dataSeries.getData().add(new XYChart.Data<>("1", 10));
            dataSeries.getData().add(new XYChart.Data<>("2", 20));
            dataSeries.getData().add(new XYChart.Data<>("3", 15));
            dataSeries.getData().add(new XYChart.Data<>("4", 25));

            dataSeries2.getData().add(new XYChart.Data<>("1", 13));
            dataSeries2.getData().add(new XYChart.Data<>("2", 23));
            dataSeries2.getData().add(new XYChart.Data<>("3", 12));
            dataSeries2.getData().add(new XYChart.Data<>("4", 20));

            lineChart.getData().add(dataSeries);
            lineChart.getData().add(dataSeries2);
        }
    }
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
