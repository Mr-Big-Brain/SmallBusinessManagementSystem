package com.example.smallbusinessmanagementsystem.controller.Statistika.Produktai;

import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.service.ZymeService;
import com.example.smallbusinessmanagementsystem.statistika.StatistikaProduktaiService;
import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class StatistikaProduktaiTabController implements Initializable {
    WindowLoader windowLoader;
    WindowManager windowManager;
    StatistikaProduktaiService statistikaProduktaiService;
    List<Produktas> produktaiList;
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
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(windowLoader.isTabStatistikaProduktai()) {

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
    private BarChart<String, Double> barChartProduktai;

    @FXML
    void pasalintiProdukta(ActionEvent event) {

    }

    @FXML
    void pridetiProdukta(ActionEvent event) {
        //windowManager.showFindProduktas();
    }


    private void fillChart()
    {

    }
    private void fillTable()
    {
        ObservableList<Produktas> produktai = FXCollections.observableList(produktaiList);
        columnProduktas.setCellValueFactory(new PropertyValueFactory<Produktas,String>("pavadinimas"));
        tableViewProduktai.setItems(produktai);
    }
}
