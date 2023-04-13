package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Produktai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.persistenceController.ProduktasPersistenceController;
import com.example.smallbusinessmanagementsystem.service.ProduktasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
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
import java.util.ResourceBundle;

public class KonfiguracijaProduktaiTabController implements Initializable {
    WindowManager windowManager;
    ProduktasPersistenceController produktasPersistenceController;
    ProduktasService produktasService;
    public KonfiguracijaProduktaiTabController()
    {
        windowManager = new WindowManager();
        produktasPersistenceController = new ProduktasPersistenceController();
        produktasService = new ProduktasService();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillProduktaiTableView();
    }

    @FXML
    private TableView<Produktas> tableViewProduktai;

    @FXML
    private TableColumn<Produktas, Integer> columnProduktaiID;

    @FXML
    private TableColumn<Produktas, String> columnProduktaiPavadinimas;

    @FXML
    private TableColumn<Produktas, Double> columnProduktaiPirkimoKaina;

    @FXML
    private TableColumn<Produktas, Double> columnProduktaiRekomenduojamaKaina;

    @FXML
    private TableColumn<Produktas, String> columnProduktaiApibrezimas;

    @FXML
    private TableView<Zyme> tableViewZymes;

    @FXML
    private TableColumn<Zyme, String> columnZyme;

    @FXML
    private Button buttonProduktaiPrideti;

    @FXML
    private Button buttonProduktaiRedaguoti;

    @FXML
    private Button buttonProduktaiIštrinti;

    @FXML
    private Button buttonZymePrideti;

    @FXML
    private Button buttonZymeIstrinti;

    @FXML
    void istrintiProdukta(ActionEvent event) {
        if(produktasService.tryDeleteProduktas(tableViewProduktai.getSelectionModel().getSelectedItem().getId()))
        {
            AllertBox.display("Pavyko", "Produktas ištrintas");
            fillProduktaiTableView();
        }
    }

    @FXML
    void istrintiZyme(ActionEvent event) {
        if(produktasService.removeZyme(tableViewProduktai.getSelectionModel().getSelectedItem(),tableViewZymes.getSelectionModel().getSelectedItem().getId()))
        {
            AllertBox.display("Pavyko", "Žymė ištrinta");
            fillZymesTableView(tableViewProduktai.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void pridetiProdukta(ActionEvent event) {
        windowManager.showManageProduktas(event, ControllerOperation.CREATE,null);
    }

    @FXML
    void pridetiZyme(ActionEvent event) {
        windowManager.showFindZyme(event,ControllerOperation.FIND_FOR_PRODUKTAS,tableViewProduktai.getSelectionModel().getSelectedItem());
    }

    @FXML
    void redaguotiProdukta(ActionEvent event) {
        windowManager.showManageProduktas(event, ControllerOperation.UPDATE,tableViewProduktai.getSelectionModel().getSelectedItem());
    }

    @FXML
    void openZymes(MouseEvent event) {
        fillZymesTableView(tableViewProduktai.getSelectionModel().getSelectedItem());
    }

    private void fillProduktaiTableView()
    {
        ObservableList<Produktas> produktai = FXCollections.observableList(produktasPersistenceController.getProduktasListFromDatabase());
        columnProduktaiID.setCellValueFactory(new PropertyValueFactory<Produktas,Integer>("id"));
        columnProduktaiPavadinimas.setCellValueFactory(new PropertyValueFactory<Produktas,String>("pavadinimas"));
        columnProduktaiApibrezimas.setCellValueFactory(new PropertyValueFactory<Produktas,String>("apibrezimas"));
        columnProduktaiPirkimoKaina.setCellValueFactory(new PropertyValueFactory<Produktas,Double>("pirkimoKaina"));
        columnProduktaiRekomenduojamaKaina.setCellValueFactory(new PropertyValueFactory<Produktas,Double>("rekomenduojamaKaina"));
        tableViewProduktai.setItems(produktai);
    }
    private void fillZymesTableView(Produktas produktas)
    {
        ObservableList<Zyme> zymes = FXCollections.observableList(produktas.getZymes());
        columnZyme.setCellValueFactory(new PropertyValueFactory<Zyme,String>("pavadinimas"));
        tableViewZymes.setItems(zymes);
    }
}
