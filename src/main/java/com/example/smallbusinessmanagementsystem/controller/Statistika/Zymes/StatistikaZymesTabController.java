package com.example.smallbusinessmanagementsystem.controller.Statistika.Zymes;

import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.statistika.StatistikaZymesService;
import com.example.smallbusinessmanagementsystem.statistika.StatistikosManager;
import com.example.smallbusinessmanagementsystem.statistika.StatistikosVienetas;
import com.example.smallbusinessmanagementsystem.utilities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StatistikaZymesTabController implements Initializable {
    WindowLoader windowLoader;
    WindowManager windowManager;
    List<Zyme> zymeList;
    LocalDate nuo;
    LocalDate iki;
    StatistikaProduktaiChoice statistikaProduktaiChoice;
    StatistikaZymesService statistikaZymesService;

    public StatistikaZymesTabController() {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaZymes()) {
            windowManager = new WindowManager();
            windowLoader = WindowLoader.getInstance();
            statistikaZymesService = new StatistikaZymesService();
        }
    }

    public StatistikaZymesTabController(List<Zyme> zymeList, LocalDate nuo, LocalDate iki, StatistikaProduktaiChoice statistikaProduktaiChoice) {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaZymes()) {
            windowManager = new WindowManager();
            windowLoader = WindowLoader.getInstance();
            statistikaZymesService = new StatistikaZymesService();

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
        if(choiceBoxTipas.getValue()==StatistikaProduktaiChoice.PARDAVIMŲ_KIEKIS)
        {
            List<StatistikosVienetas> statistikosVienetasList = new ArrayList<>();

            for(int i=0;i<zymeList.size();i++) {
                statistikosVienetasList.add(new StatistikosVienetas(
                        statistikaZymesService.getZymePardavimuKiekiai(zymeList.get(i), datePickerNuo.getValue(), datePickerIki.getValue()), zymeList.get(i).getPavadinimas()
                ));
            }
            StatistikosManager statistikosManager = new StatistikosManager();
            constructLineChart(statistikosManager.fillMissingDates(statistikosVienetasList),"Pardavimų kiekiai per diena");
        }
        else if(choiceBoxTipas.getValue()==StatistikaProduktaiChoice.PARDAVIMŲ_SUMA)
        {
            List<StatistikosVienetas> statistikosVienetasList = new ArrayList<>();

            for(int i=0;i<zymeList.size();i++) {
                statistikosVienetasList.add(new StatistikosVienetas(
                        statistikaZymesService.getZymePardavimuSumos(zymeList.get(i), datePickerNuo.getValue(), datePickerIki.getValue()), zymeList.get(i).getPavadinimas()
                ));
            }
            StatistikosManager statistikosManager = new StatistikosManager();
            constructLineChart(statistikosManager.fillMissingDates(statistikosVienetasList),"Pardavimų sumos per diena");
        }
        else if(choiceBoxTipas.getValue()==StatistikaProduktaiChoice.PELNAS)
        {
            List<StatistikosVienetas> statistikosVienetasList = new ArrayList<>();

            for(int i=0;i<zymeList.size();i++) {
                statistikosVienetasList.add(new StatistikosVienetas(
                        statistikaZymesService.getZymePardavimuPelnai(zymeList.get(i), datePickerNuo.getValue(), datePickerIki.getValue()), zymeList.get(i).getPavadinimas()
                ));
            }
            StatistikosManager statistikosManager = new StatistikosManager();
            constructLineChart(statistikosManager.fillMissingDates(statistikosVienetasList),"Pardavimų pelnas per diena");
        }
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

    private void constructLineChart(List<StatistikosVienetas> statistikosVienetasList, String linechartTitle) {
        clearLineChart();

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        CategoryAxis xxAxis = (CategoryAxis) lineChart.getXAxis();

        xxAxis.setTickLabelRotation(90);

        lineChart.setTitle(linechartTitle);
        xAxis.setLabel("X Axis Label");
        yAxis.setLabel("Y Axis Label");

        XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
        XYChart.Series<String, Number> dataSeries2 = new XYChart.Series<>();

        List<XYChart.Series<String, Number>> dataSeriesList = new ArrayList<>();

        XYChart.Series<String, Number> tempDataSeries = new XYChart.Series<>();

        for(StatistikosVienetas statistikosVienetas : statistikosVienetasList)
        {
            tempDataSeries = new XYChart.Series<>();
            tempDataSeries.setName(statistikosVienetas.getPavadinimas());
            for(int i=0;i<statistikosVienetas.getStatistikosElementasList().size();i++)
            {
                tempDataSeries.getData().add(new XYChart.Data<>(String.valueOf(statistikosVienetas.getStatistikosElementasList().get(i).getData()),
                        statistikosVienetas.getStatistikosElementasList().get(i).getKiekis()));
            }
            tempDataSeries.setName(statistikosVienetas.getPavadinimas());
            lineChart.getData().add(tempDataSeries);
        }
    }
    private void clearLineChart()
    {
        lineChart.getData().clear();
    }
}
