package com.example.smallbusinessmanagementsystem.controller.Statistika.Klientai;

import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.utilities.StatistikaKlientaiChoice;
import com.example.smallbusinessmanagementsystem.utilities.StatistikaProduktaiChoice;
import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.example.smallbusinessmanagementsystem.utilities.ControllerOperation.FIND_FOR_STATISTIKA_KLIENTAI;

public class StatistikaKlientaiTabController implements Initializable {
    WindowLoader windowLoader;
    WindowManager windowManager;
    Klientas klientas;
    LocalDate nuo;
    LocalDate iki;
    StatistikaKlientaiChoice statistikaKlientaiChoice;

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
}
