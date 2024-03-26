package com.example.smallbusinessmanagementsystem.controller.Pardavimai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.model.Pardavimas;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.service.KlientasService;
import com.example.smallbusinessmanagementsystem.service.PardavimasService;
import com.example.smallbusinessmanagementsystem.service.PardavimoLinijaService;
import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class PardavimaiTabController implements Initializable {
    WindowManager windowManager;
    WindowLoader windowLoader;
    PardavimasService pardavimasService;
    VartotojasService vartotojasService;
    KlientasService klientasService;
    PardavimoLinijaService pardavimoLinijaService;

    public PardavimaiTabController()
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabPardavimai())
        {
            windowManager = new WindowManager();
            pardavimasService = new PardavimasService();
            pardavimoLinijaService = new PardavimoLinijaService();
            vartotojasService = new VartotojasService();
            klientasService = new KlientasService();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(windowLoader.isTabPardavimai())
        {
            fillTable();
        }
    }
    @FXML
    private Button buttonNaujasPardavimas;

    @FXML
    private Button buttonRedaguotiPardavima;

    @FXML
    private Button buttonIstrintiPardavima;

    @FXML
    private Button buttonRastiPardavima;

    @FXML
    private TableView<Pardavimas> tableVIewPardavimai;

    @FXML
    private TableColumn<Pardavimas, Integer> columnPardavimaiID;

    @FXML
    private TableColumn<Pardavimas, String> columnPardavimaiData;

    @FXML
    private TableColumn<Pardavimas, String> columnPardavimaiSuma;

    @FXML
    private TableColumn<Pardavimas, String> columnPardavimaiDarbuotojas;

    @FXML
    private TableColumn<Pardavimas, String> columnPardavimaiPirkejas;

    @FXML
    private DatePicker datePickerNuo;

    @FXML
    private DatePicker datePickerIki;

    @FXML
    void istrintiPardavima(ActionEvent event) {
        if(pardavimasService.tryDeletePardavimas(tableVIewPardavimai.getSelectionModel().getSelectedItem().getId()))
        {
            AllertBox.display("Pavyko","Pardavimas ir jo pardavimo linijos ištrinti");
            fillTable();
        }
    }

    @FXML
    void naujasPardavimas(ActionEvent event) {
        windowManager.showManagePardavimas(event, ControllerOperation.CREATE_PARDAVIMAS,null,null);
    }

    @FXML
    void rastiPardavima(ActionEvent event) {

    }

    @FXML
    void redaguotiPardavima(ActionEvent event) {
        windowManager.showManagePardavimas(event, ControllerOperation.UPDATE_PARDAVIMAS,tableVIewPardavimai.getSelectionModel().getSelectedItem(),pardavimoLinijaService.getPardavimoLinijosByPardavimas(tableVIewPardavimai.getSelectionModel().getSelectedItem().getId()));
    }

    @FXML
    void atnaujintiPardavimus(ActionEvent event) {
        fillTable();
    }

    private Double roundDouble(Double number)
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.US));
        String roundedString = decimalFormat.format(number);
        return Double.parseDouble(roundedString);
    }
    private void fillTable()
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        ObservableList<Pardavimas> pardavimai = FXCollections.observableList(pardavimasService.getAllPardavimai(datePickerNuo.getValue(),datePickerIki.getValue()));
        columnPardavimaiID.setCellValueFactory(new PropertyValueFactory<Pardavimas,Integer>("id"));
        columnPardavimaiData.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(dateTimeFormatter.format(cellData.getValue().getData()));
        });
        columnPardavimaiDarbuotojas.setCellValueFactory(new PropertyValueFactory<Pardavimas,String>("pardavejas"));
        columnPardavimaiDarbuotojas.setCellValueFactory(cellData -> {
            if(cellData.getValue().getPardavejas()!=null)
            {
                String vartotojas = cellData.getValue().getPardavejas().getVardas() + " " + cellData.getValue().getPardavejas().getPavarde();
                return new SimpleStringProperty(vartotojas);
            }
            else return new SimpleStringProperty("");
        });
        columnPardavimaiPirkejas.setCellValueFactory(new PropertyValueFactory<Pardavimas,String>("klientas"));
        columnPardavimaiPirkejas.setCellValueFactory(cellData -> {
            if(cellData.getValue().getKlientas()!=null)
            {
                String klientas = cellData.getValue().getKlientas().getId() + ", " + cellData.getValue().getKlientas().getPavarde();
                return new SimpleStringProperty(klientas);
            }
            else return new SimpleStringProperty("");
        });
        columnPardavimaiSuma.setCellValueFactory(new PropertyValueFactory<Pardavimas,String>("id"));
        columnPardavimaiSuma.setCellValueFactory(cellData -> {
                int pardavimoId = cellData.getValue().getId();
                double suma = roundDouble(pardavimoLinijaService.getPardavimoSuma(pardavimoId));
                return new SimpleStringProperty(String.valueOf(suma));
        });
        tableVIewPardavimai.setItems(pardavimai);
    }
}
