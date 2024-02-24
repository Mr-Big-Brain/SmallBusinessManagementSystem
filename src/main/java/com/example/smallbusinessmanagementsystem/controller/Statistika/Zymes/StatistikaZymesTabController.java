package com.example.smallbusinessmanagementsystem.controller.Statistika.Zymes;

import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.utilities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class StatistikaZymesTabController implements Initializable {
    WindowLoader windowLoader;
    WindowManager windowManager;
    List<Zyme> zymeList;
    LocalDate nuo;
    LocalDate iki;
    StatistikaProduktaiChoice statistikaProduktaiChoice;

    public StatistikaZymesTabController() {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaZymes()) {
            windowManager = new WindowManager();
            windowLoader = WindowLoader.getInstance();
        }
    }

    public StatistikaZymesTabController(List<Zyme> zymeList, LocalDate nuo, LocalDate iki, StatistikaProduktaiChoice statistikaProduktaiChoice) {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaZymes()) {
            windowManager = new WindowManager();
            windowLoader = WindowLoader.getInstance();
            this.zymeList = zymeList;
            this.nuo = nuo;
            this.iki = iki;
            this.statistikaProduktaiChoice = statistikaProduktaiChoice;
        }
    }

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private TableView<Zyme> tableViewZymes;

    @FXML
    private TableColumn<Zyme, String> columnZyme;

    @FXML
    private Button buttonPrideti;

    @FXML
    private DatePicker datePickerNuo;

    @FXML
    private DatePicker datePickerIki;

    @FXML
    private ChoiceBox<StatistikaProduktaiChoice> choiceBoxTipas;

    @FXML
    private Button buttonRodyti;

    @FXML
    private Button buttonIstrinti;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(windowLoader.isTabStatistikaZymes()) {

            datePickerIki.setValue(iki);
            datePickerNuo.setValue(nuo);
            fillChoiceBox(statistikaProduktaiChoice);
            fillTableView();

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
        windowManager.showFindZyme(event, ControllerOperation.FIND_FOR_STATISTIKA_ZYMES, tableViewZymes.getItems(), datePickerNuo.getValue(), datePickerIki.getValue(), choiceBoxTipas.getValue());
    }

    @FXML
    void rodyti(ActionEvent event) {

    }
    private void fillChoiceBox(StatistikaProduktaiChoice statistikaProduktaiChoice)
    {
        choiceBoxTipas.getItems().clear();
        choiceBoxTipas.getItems().addAll(StatistikaProduktaiChoice.values());
        choiceBoxTipas.setValue(statistikaProduktaiChoice);
        if(statistikaProduktaiChoice == null)
        {
            choiceBoxTipas.setValue(StatistikaProduktaiChoice.PARDAVIMŲ_KIEKIS);
        }
    }

    private void fillTableView()
    {
        tableViewZymes.getItems().clear();
        if(zymeList!=null && !zymeList.isEmpty())
        {
            ObservableList<Zyme> produktai = FXCollections.observableList(zymeList);
            columnZyme.setCellValueFactory(new PropertyValueFactory<Zyme, String>("pavadinimas"));
            tableViewZymes.setItems(produktai);
        }
    }
}
