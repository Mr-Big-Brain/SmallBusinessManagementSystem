package com.example.smallbusinessmanagementsystem.controller;

import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.model.Komunikacija;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.service.ProduktasService;
import com.example.smallbusinessmanagementsystem.service.ZymeService;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class FindProduktasController implements Initializable {
    ControllerOperation controllerOperation;
    WindowManager windowManager;
    Komunikacija komunikacijaModifikacijai;
    ProduktasService produktasService;
    ZymeService zymeService;
    public FindProduktasController(ControllerOperation controllerOperationn, Komunikacija newKomunikacija) {
        controllerOperation = controllerOperationn;
        windowManager = new WindowManager();
        komunikacijaModifikacijai = newKomunikacija;
        produktasService = new ProduktasService();
        zymeService = new ZymeService();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(controllerOperation == ControllerOperation.FIND_FOR_KOMUNIKACIJA)
        {
            fillProduktasTable();
        }
    }
    @FXML
    private TableView<Produktas> tableViewProduktai;

    @FXML
    private TableColumn<Produktas, Integer> columnID;

    @FXML
    private TableColumn<Produktas, String> columnPavadinimas;

    @FXML
    private TableView<Zyme> tableViewProduktuZymes;

    @FXML
    private TableColumn<Zyme, String> columnProduktoZyme;

    @FXML
    private Button buttonPrideti;

    @FXML
    private Button buttonIstrinti;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private TableView<Zyme> tableViewZymeFiltras;

    @FXML
    private TableColumn<Zyme, String> columnZymeFiltras;

    @FXML
    private Button buttonFiltruoti;

    @FXML
    private Button buttonPasirinkti;

    @FXML
    private Button buttonAtgal;

    @FXML
    void atgal(ActionEvent event) {

    }

    @FXML
    void filtruoti(ActionEvent event) {

    }

    @FXML
    void istrinti(ActionEvent event) {

    }

    @FXML
    void pasirinkti(ActionEvent event) {
        if(controllerOperation == ControllerOperation.FIND_FOR_KOMUNIKACIJA)
        {
            if(komunikacijaModifikacijai.getId()!=0)
            {
                komunikacijaModifikacijai.setProduktas(tableViewProduktai.getSelectionModel().getSelectedItem());
                windowManager.showManageKomunikacija(event,ControllerOperation.UPDATE, komunikacijaModifikacijai);
            }
            else
            {
                komunikacijaModifikacijai.setProduktas(tableViewProduktai.getSelectionModel().getSelectedItem());
                windowManager.showManageKomunikacija(event,ControllerOperation.CREATE, komunikacijaModifikacijai);
            }

        }
    }

    @FXML
    void prideti(ActionEvent event) {

    }
    private void fillProduktasTable()
    {
        ObservableList<Produktas> produktai = FXCollections.observableList(produktasService.getAllProduktai());
        columnID.setCellValueFactory(new PropertyValueFactory<Produktas,Integer>("id"));
        columnPavadinimas.setCellValueFactory(new PropertyValueFactory<Produktas,String>("pavadinimas"));
        tableViewProduktai.setItems(produktai);
    }
}
