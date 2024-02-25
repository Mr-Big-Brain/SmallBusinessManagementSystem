package com.example.smallbusinessmanagementsystem.controller.Statistika.Finansai;

import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.service.ZymeService;
import com.example.smallbusinessmanagementsystem.statistika.StatistikaFinansaiService;
import com.example.smallbusinessmanagementsystem.statistika.StatistikosElementas;
import com.example.smallbusinessmanagementsystem.utilities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class StatistikaFinansaiTabController implements Initializable {
    WindowLoader windowLoader;
    WindowManager windowManager;
    List<Zyme> zymeList;
    LocalDate nuo;
    LocalDate iki;
    FinansoTipas finansoTipas;
    StatistikaFinansaiService statistikaFinansaiService;
    ZymeService zymeService;

    public StatistikaFinansaiTabController()
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaFinansai()) {
            windowManager = new WindowManager();
            windowLoader = WindowLoader.getInstance();
            zymeService = new ZymeService();
            statistikaFinansaiService = new StatistikaFinansaiService();
        }
    }

    public StatistikaFinansaiTabController(List<Zyme> zymeList, LocalDate nuo, LocalDate iki, FinansoTipas finansoTipas)
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaFinansai()) {
            windowManager = new WindowManager();
            windowLoader = WindowLoader.getInstance();
            this.zymeList = zymeList;
            this.nuo = nuo;
            this.iki = iki;
            this.finansoTipas = finansoTipas;
            statistikaFinansaiService = new StatistikaFinansaiService();
            zymeService = new ZymeService();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(windowLoader.isTabStatistikaFinansai()) {
            datePickerIki.setValue(iki);
            datePickerNuo.setValue(nuo);
            fillChoiceBox(finansoTipas);
            fillTableView();
        }
    }
    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private ChoiceBox<FinansoTipas> choiceBoxTipas;

    @FXML
    private Button buttonVisos;

    @FXML
    private TableView<Zyme> tableViewZymes;

    @FXML
    private TableColumn<Zyme, String> columnZyme;

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
    private Button buttonRodyti;

    @FXML
    void pasalinti(ActionEvent event) {
        zymeList = zymeList.stream()
                .filter(zyme -> zyme.getId() != tableViewZymes.getSelectionModel().getSelectedItem().getId())
                .collect(Collectors.toList());
        fillTableView();
    }

    @FXML
    void prideti(ActionEvent event) {
        windowManager.showFindZyme(event, ControllerOperation.FIND_FOR_STATISTIKA_FINANSAI, tableViewZymes.getItems(), datePickerNuo.getValue(), datePickerIki.getValue(), choiceBoxTipas.getValue());

    }

    @FXML
    void rodyti(ActionEvent event) {
        barChart.getData().clear();

        XYChart.Series series = new XYChart.Series();
        series = contstructDataSeries(constructStatistikosElementasList(tableViewZymes.getItems()));

        barChart.getData().addAll(series);
        barChart.setLegendVisible(false);
    }

    @FXML
    void visos(ActionEvent event) {
        zymeList = zymeService.getAllFinansaiZyme();
        fillTableView();
    }

    private void fillChoiceBox(FinansoTipas finansoTipas)
    {
        choiceBoxTipas.getItems().clear();
        choiceBoxTipas.getItems().addAll(FinansoTipas.values());
        choiceBoxTipas.getItems().remove(FinansoTipas.VISI);
        choiceBoxTipas.setValue(finansoTipas);
        if(finansoTipas == null)
        {
            choiceBoxTipas.setValue(FinansoTipas.PAJAMOS);
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

    private List<StatistikosElementas> constructStatistikosElementasList(List<Zyme> zymeList) {
        List<StatistikosElementas> statistikosElementasList = new ArrayList<>();
        for(Zyme zyme : zymeList)
        {
            statistikosElementasList.add(statistikaFinansaiService.getFinansoZymesStatistika(zyme, datePickerNuo.getValue(), datePickerIki.getValue(), choiceBoxTipas.getValue()));
        }

        return statistikosElementasList;
    }

    private XYChart.Series<String, Number> contstructDataSeries(List<StatistikosElementas> statistikosElementasList)
    {
        XYChart.Series<String, Number> tempDataSeries = new XYChart.Series<>();

        for(StatistikosElementas statistikosElementas : statistikosElementasList)
        {
            tempDataSeries.getData().add(new XYChart.Data(statistikosElementas.getPavadinimas(), statistikosElementas.getKiekis()));
        }

        return tempDataSeries;
    }
}
