package com.example.smallbusinessmanagementsystem.controller.Statistika.Finansai;

import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.utilities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class StatistikaFinansaiTabController implements Initializable {
    WindowLoader windowLoader;
    WindowManager windowManager;
    List<Zyme> zymeList;
    LocalDate nuo;
    LocalDate iki;
    FinansoTipas finansoTipas;

    public StatistikaFinansaiTabController()
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabStatistikaFinansai()) {
            windowManager = new WindowManager();
            windowLoader = WindowLoader.getInstance();
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

    }

    @FXML
    void prideti(ActionEvent event) {
        windowManager.showFindZyme(event, ControllerOperation.FIND_FOR_STATISTIKA_FINANSAI, tableViewZymes.getItems(), datePickerNuo.getValue(), datePickerIki.getValue(), choiceBoxTipas.getValue());

    }

    @FXML
    void rodyti(ActionEvent event) {

    }

    private void fillChoiceBox(FinansoTipas finansoTipas)
    {
        choiceBoxTipas.getItems().clear();
        choiceBoxTipas.getItems().addAll(FinansoTipas.values());
        choiceBoxTipas.setValue(finansoTipas);
        if(finansoTipas == null)
        {
            choiceBoxTipas.setValue(FinansoTipas.VISI);
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
