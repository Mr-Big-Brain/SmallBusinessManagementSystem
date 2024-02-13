package com.example.smallbusinessmanagementsystem.controller.Statistika.Produktai;

import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.service.ZymeService;
import com.example.smallbusinessmanagementsystem.statistika.StatistikaProduktaiService;
import com.example.smallbusinessmanagementsystem.statistika.StatistikosManager;
import com.example.smallbusinessmanagementsystem.statistika.StatistikosVienetas;
import com.example.smallbusinessmanagementsystem.utilities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class StatistikaProduktaiTabController implements Initializable {
    WindowLoader windowLoader;
    WindowManager windowManager;
    StatistikaProduktaiService statistikaProduktaiService;
    List<Produktas> produktaiList;
    LocalDate nuo;
    LocalDate iki;
    public StatistikaProduktaiTabController()
    {

    }
    public StatistikaProduktaiTabController(List<Produktas> produktasList, LocalDate nuo, LocalDate iki)
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaProduktai()) {
            produktaiList = produktasList;
            statistikaProduktaiService = new StatistikaProduktaiService();
            windowManager = new WindowManager();
            windowLoader = WindowLoader.getInstance();

            this.nuo = nuo;
            this.iki = iki;
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(windowLoader.isTabStatistikaProduktai()) {
            datePickerNuo.setValue(nuo);
            datePickerIki.setValue(iki);
            fillTable();
            fillChoiceBox(StatistikaProduktaiChoice.PARDAVIMŲ_KIEKIS);
        }
    }
    @FXML
    private TableView<Produktas> tableViewProduktai;

    @FXML
    private TableColumn<Produktas, String> columnProduktas;

    @FXML
    private Button buttonPridetiProdukta;

    @FXML
    private Button buttonPasalintiProdukta;

    @FXML
    private DatePicker datePickerNuo;

    @FXML
    private DatePicker datePickerIki;

    @FXML
    private LineChart<String, Number> lineChartProduktai;

    @FXML
    private Button buttonRodyti;

    @FXML
    private ChoiceBox<StatistikaProduktaiChoice> choiceBoxTipas;

    @FXML
    void pasalintiProdukta(ActionEvent event) {
        produktaiList = produktaiList.stream()
                .filter(produktas -> produktas.getId() != tableViewProduktai.getSelectionModel().getSelectedItem().getId())
                .collect(Collectors.toList());
        fillTable();
    }

    @FXML
    void pridetiProdukta(ActionEvent event) {
        windowManager.showFindProduktas(event, tableViewProduktai.getItems(),datePickerNuo.getValue(), datePickerIki.getValue(), ControllerOperation.FIND_FOR_STATISTIKA_PRODUKTAI);
    }

    private void fillTable()
    {
        tableViewProduktai.getItems().clear();
        if(produktaiList!=null && !produktaiList.isEmpty()){
            ObservableList<Produktas> produktai = FXCollections.observableList(produktaiList);
            columnProduktas.setCellValueFactory(new PropertyValueFactory<Produktas,String>("pavadinimas"));
            tableViewProduktai.setItems(produktai);
        }
    }

    @FXML
    void rodyti(ActionEvent event) {
        if(choiceBoxTipas.getValue()==StatistikaProduktaiChoice.PARDAVIMŲ_KIEKIS)
        {

        }
        else if(choiceBoxTipas.getValue()==StatistikaProduktaiChoice.PARDAVIMŲ_SUMA)
        {
            List<StatistikosVienetas> statistikosVienetasList = new ArrayList<>();

            for(int i=0;i<produktaiList.size();i++) {
                statistikosVienetasList.add(new StatistikosVienetas(
                        statistikaProduktaiService.getProduktoPardavimuSumos(produktaiList.get(i), datePickerNuo.getValue(), datePickerIki.getValue()), produktaiList.get(i).getPavadinimas()
                ));
            }
            StatistikosManager statistikosManager = new StatistikosManager();
            constructLineChart(statistikosManager.fillMissingDates(statistikosVienetasList),"Pardavimų sumos");
        }
        else if(choiceBoxTipas.getValue()==StatistikaProduktaiChoice.PELNAS)
        {

        }
    }

    private void fillChoiceBox(StatistikaProduktaiChoice  statistikaProduktaiChoice)
    {
        choiceBoxTipas.getItems().clear();
        choiceBoxTipas.getItems().addAll(StatistikaProduktaiChoice.values());
        choiceBoxTipas.setValue(statistikaProduktaiChoice);
    }

    private void constructLineChart(List<StatistikosVienetas> statistikosVienetasList, String linechartTitle) {
        clearLineChart();

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        CategoryAxis xxAxis = (CategoryAxis) lineChartProduktai.getXAxis();

        xxAxis.setTickLabelRotation(90);

        lineChartProduktai.setTitle(linechartTitle);
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
            lineChartProduktai.getData().add(tempDataSeries);
        }
    }

    private void clearLineChart()
    {
        lineChartProduktai.getData().clear();
    }

}
