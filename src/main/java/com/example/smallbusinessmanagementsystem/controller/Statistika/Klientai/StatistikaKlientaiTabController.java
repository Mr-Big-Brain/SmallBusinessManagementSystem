package com.example.smallbusinessmanagementsystem.controller.Statistika.Klientai;

import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.statistika.StatistikaKlientaiService;
import com.example.smallbusinessmanagementsystem.statistika.StatistikosElementas;
import com.example.smallbusinessmanagementsystem.statistika.StatistikosVienetas;
import com.example.smallbusinessmanagementsystem.utilities.StatistikaKlientaiChoice;
import com.example.smallbusinessmanagementsystem.utilities.StatistikaProduktaiChoice;
import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.smallbusinessmanagementsystem.utilities.ControllerOperation.FIND_FOR_STATISTIKA_KLIENTAI;

public class StatistikaKlientaiTabController implements Initializable {
    WindowLoader windowLoader;
    WindowManager windowManager;
    Klientas klientas;
    LocalDate nuo;
    LocalDate iki;
    StatistikaKlientaiChoice statistikaKlientaiChoice;
    StatistikaKlientaiService statistikaKlientaiService;

    public StatistikaKlientaiTabController()
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaKlientai()) {
            windowManager = new WindowManager();
            windowLoader = WindowLoader.getInstance();
        }
    }
    public StatistikaKlientaiTabController(Klientas klientas, LocalDate nuo, LocalDate iki, StatistikaKlientaiChoice statistikaKlientaiChoice)
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaKlientai()) {
            windowManager = new WindowManager();
            windowLoader = WindowLoader.getInstance();
            this.statistikaKlientaiService = new StatistikaKlientaiService();
            this.klientas = klientas;
            this.nuo = nuo;
            this.iki = iki;
            this.statistikaKlientaiChoice = statistikaKlientaiChoice;
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(windowLoader.isTabStatistikaKlientai()) {
            if(klientas!=null) {
                textFieldKlientas.setText(klientas.getId() + " " + klientas.getVardas());
            }
            if(nuo!=null) {
                datePickerNuo.setValue(nuo);
            }
            if(iki!=null) {
                datePickerIki.setValue(iki);
            }

            if(statistikaKlientaiChoice!=null) {
                fillChoiceBox(statistikaKlientaiChoice);
            }
            else {
                fillChoiceBox(StatistikaKlientaiChoice.PRODUKTAI);
            }

        }
    }
    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private ChoiceBox<StatistikaKlientaiChoice> choiceBoxTipas;

    @FXML
    private TextField textFieldKlientas;

    @FXML
    private Button buttonRodyti;

    @FXML
    private DatePicker datePickerNuo;

    @FXML
    private DatePicker datePickerIki;

    @FXML
    private Button buttonPasirinkti;

    @FXML
    void rodyti(ActionEvent event) {
        barChart.getData().clear();
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();


        XYChart.Series series = new XYChart.Series();
        if(choiceBoxTipas.getValue() == StatistikaKlientaiChoice.PRODUKTAI)
        {
            series = contstructDataSeries(statistikaKlientaiService.getFaivouriteProducts(klientas, datePickerNuo.getValue(), datePickerIki.getValue()));
            barChart.setTitle("Produktų pirkimų kiekiai");
            xAxis.setLabel("Produktas");
            yAxis.setLabel("Kiekis");
        }

        if(choiceBoxTipas.getValue() == StatistikaKlientaiChoice.ŽYMĖS)
        {
            series = contstructDataSeries(statistikaKlientaiService.getFaivouriteZymes(klientas, datePickerNuo.getValue(), datePickerIki.getValue()));
            barChart.setTitle("Kategorijų pirkimų kiekiai");
            xAxis.setLabel("Žymė");
            yAxis.setLabel("Kiekis");
        }

        barChart.getData().addAll(series);
        barChart.setLegendVisible(false);
    }

    @FXML
    void pasirinkti(ActionEvent event) {
        windowManager.showFindKlientas(event, FIND_FOR_STATISTIKA_KLIENTAI, datePickerNuo.getValue(), datePickerIki.getValue(), choiceBoxTipas.getValue());
    }

    private void fillChoiceBox(StatistikaKlientaiChoice statistikaKlientaiChoice)
    {
        choiceBoxTipas.getItems().clear();
        choiceBoxTipas.getItems().addAll(StatistikaKlientaiChoice.values());
        choiceBoxTipas.setValue(statistikaKlientaiChoice);
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
