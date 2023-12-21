package com.example.smallbusinessmanagementsystem.controller.Klientai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.model.Komunikacija;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.service.KlientasService;
import com.example.smallbusinessmanagementsystem.service.KomunikacijaService;
import com.example.smallbusinessmanagementsystem.service.ProduktasService;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class KlientaiTabController implements Initializable {
    WindowManager windowManager;
    KlientasService klientasService;
    ProduktasService produktasService;
    KomunikacijaService komunikacijaService;
    WindowLoader windowLoader;
    public KlientaiTabController()
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabKlientai())
        {
            klientasService = new KlientasService();
            windowManager = new WindowManager();
            produktasService = new ProduktasService();
            komunikacijaService = new KomunikacijaService();
            windowLoader = WindowLoader.getInstance();
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(windowLoader.isTabKlientai())
        {
            fillKlientaiTable();
        }
    }
    @FXML
    private TableView<Klientas> tableViewKlientai;

    @FXML
    private TableColumn<Klientas, Integer> columnKlientaiID;

    @FXML
    private TableColumn<Klientas, String> columnKlientaiVardas;

    @FXML
    private TableColumn<Klientas, String> columnKlientaiPavarde;

    @FXML
    private TableColumn<Klientas, String> columnKlientaiImone;

    @FXML
    private TableColumn<Klientas, String> columnKlientaiTelefonas;

    @FXML
    private TableColumn<Klientas, String> columnKlientaiPastas;

    @FXML
    private Button buttonKlientaiPrideti;

    @FXML
    private Button buttonKlientaiRedaguoti;

    @FXML
    private Button buttonKlientaiIstrinti;

    @FXML
    private TableView<Komunikacija> tableViewKomunikacijos;

    @FXML
    private TableColumn<Komunikacija, Integer> columnKomunikacijosID;

    @FXML
    private TableColumn<Komunikacija, String> columnKomunikacijosPavadinimas;

    @FXML
    private TableColumn<Komunikacija, String> columnKomunikacijosApibrezimas;

    @FXML
    private TableColumn<Komunikacija, String> columnKomunikacijosProduktas;

    @FXML
    private TableColumn<Komunikacija, LocalDate> columnKomunikacijosData;

    @FXML
    private Button buttonKomunikacijosPrideti;

    @FXML
    private Button buttonKomunikacijosRedaguoti;

    @FXML
    private Button buttonKomunikacijosIstrinti;

    @FXML
    void istrintiKlienta(ActionEvent event) {
        if (klientasService.tryDeleteKlientas(tableViewKlientai.getSelectionModel().getSelectedItem().getId()))
        {
            AllertBox.display("Pavyko", "Klientas ir jo komunikacijų istorija ištrinti");
            fillKlientaiTable();
        }
    }

    @FXML
    void istrintiKomunikacija(ActionEvent event) {
        if(komunikacijaService.tryDeleteKomunikacija(tableViewKomunikacijos.getSelectionModel().getSelectedItem().getId()))
        {
            AllertBox.display("Pavyko","Komunikacija ištrinta");
            fillKomunikacijosTable(tableViewKlientai.getSelectionModel().getSelectedItem());
        }

    }

    @FXML
    void pridetiKlienta(ActionEvent event) {
        windowManager.showManageKlientas(event, ControllerOperation.CREATE,null);
    }

    @FXML
    void pridetiKomunikacija(ActionEvent event) {
        Komunikacija komunikacija = new Komunikacija();
        komunikacija.setKlientas(tableViewKlientai.getSelectionModel().getSelectedItem());
        windowManager.showManageKomunikacija(event,ControllerOperation.CREATE,komunikacija);
    }

    @FXML
    void redaguotiKlienta(ActionEvent event) {
        windowManager.showManageKlientas(event, ControllerOperation.UPDATE,tableViewKlientai.getSelectionModel().getSelectedItem());
    }

    @FXML
    void redaguotiKomunikacija(ActionEvent event) {
        windowManager.showManageKomunikacija(event,ControllerOperation.UPDATE,tableViewKomunikacijos.getSelectionModel().getSelectedItem());
    }
    @FXML
    void openKomunikacijos(MouseEvent event) {
        fillKomunikacijosTable(tableViewKlientai.getSelectionModel().getSelectedItem());
    }
    public void fillKlientaiTable()
    {
        ObservableList<Klientas> klientai = FXCollections.observableList(klientasService.getAllKlientai());
        columnKlientaiID.setCellValueFactory(new PropertyValueFactory<Klientas,Integer>("id"));
        columnKlientaiImone.setCellValueFactory(new PropertyValueFactory<Klientas,String>("imone"));
        columnKlientaiPastas.setCellValueFactory(new PropertyValueFactory<Klientas,String>("pastas"));
        columnKlientaiPavarde.setCellValueFactory(new PropertyValueFactory<Klientas,String>("pavarde"));
        columnKlientaiVardas.setCellValueFactory(new PropertyValueFactory<Klientas,String>("vardas"));
        columnKlientaiTelefonas.setCellValueFactory(new PropertyValueFactory<Klientas,String>("telefonas"));
        tableViewKlientai.setItems(klientai);
    }
    public void fillKomunikacijosTable(Klientas klientas)
    {
        ObservableList<Komunikacija> komunikacijos = FXCollections.observableList(komunikacijaService.getKomunikacijosByKlientas(klientas));
        columnKomunikacijosID.setCellValueFactory(new PropertyValueFactory<Komunikacija,Integer>("id"));
        columnKomunikacijosApibrezimas.setCellValueFactory(new PropertyValueFactory<Komunikacija,String>("apibrezimas"));
        columnKomunikacijosData.setCellValueFactory(new PropertyValueFactory<Komunikacija,LocalDate>("data"));
        columnKomunikacijosPavadinimas.setCellValueFactory(new PropertyValueFactory<Komunikacija,String>("pavadinimas"));
        columnKomunikacijosProduktas.setCellValueFactory(new PropertyValueFactory<Komunikacija,String>("produktas"));
        columnKomunikacijosProduktas.setCellValueFactory(cellData -> {
            if(cellData.getValue().getProduktas()!=null)
            {
                int produktoId = cellData.getValue().getProduktas().getId();
                Produktas produktas = produktasService.getProduktasById(produktoId);
                String produktoPavadinimas = (produktas != null) ? produktas.getId() + ", " + produktas.getPavadinimas() : "";
                return new SimpleStringProperty(produktoPavadinimas);
            }
            else return new SimpleStringProperty("");
        });
        tableViewKomunikacijos.setItems(komunikacijos);
    }
}
