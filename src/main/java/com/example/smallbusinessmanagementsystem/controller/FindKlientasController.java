package com.example.smallbusinessmanagementsystem.controller;

import com.example.smallbusinessmanagementsystem.model.*;
import com.example.smallbusinessmanagementsystem.service.KlientasService;
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
import java.util.List;
import java.util.ResourceBundle;

public class FindKlientasController implements Initializable {
    ControllerOperation controllerOperation;
    WindowManager windowManager;
    Pardavimas pardavimasModifikacijai;
    KlientasService klientasService;
    List<PardavimoLinija> pardavimoLinijosModifikacijai;
    public FindKlientasController(ControllerOperation controllerOperationn, Object object, List<PardavimoLinija> pardavimoLinijos)
    {
        windowManager = new WindowManager();
        controllerOperation = controllerOperationn;
        klientasService = new KlientasService();
        if(controllerOperation == ControllerOperation.FIND_FOR_PARDAVIMAS)
        {
            pardavimasModifikacijai = (Pardavimas) object;
            pardavimoLinijosModifikacijai = pardavimoLinijos;
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonAction.setText("Pasirinkti");
        fillKlientasTable();
    }
    @FXML
    private TableView<Klientas> tableViewKlientai;

    @FXML
    private TableColumn<Klientas, Integer> columnId;

    @FXML
    private TableColumn<Klientas, String> columnVardas;

    @FXML
    private TableColumn<Klientas, String> columnPavarde;

    @FXML
    private TableColumn<Klientas, String> columnImone;

    @FXML
    private TableColumn<Klientas, String> columnTelefonas;

    @FXML
    private TableColumn<Klientas, String> columnPastas;

    @FXML
    private Button buttonAtgal;

    @FXML
    private Button buttonAction;

    @FXML
    private Button buttonPaieska;

    @FXML
    private TextField textFieldId;

    @FXML
    private TextField textFieldVardas;

    @FXML
    private TextField textFieldPavarde;

    @FXML
    private TextField textFieldImone;

    @FXML
    private TextField textFieldTelefonas;

    @FXML
    private TextField textFieldPastas;

    @FXML
    void action(ActionEvent event) {
        if(controllerOperation == ControllerOperation.FIND_FOR_PARDAVIMAS)
        {
            pardavimasModifikacijai.setKlientas(tableViewKlientai.getSelectionModel().getSelectedItem());
            if(pardavimasModifikacijai.getId()==0)
            {
                windowManager.showManagePardavimas(event,ControllerOperation.CREATE,pardavimasModifikacijai,pardavimoLinijosModifikacijai);
            }
            else
            {
                windowManager.showManagePardavimas(event,ControllerOperation.UPDATE,pardavimasModifikacijai,pardavimoLinijosModifikacijai);
            }
        }
    }

    @FXML
    void atgal(ActionEvent event) {
        if(controllerOperation == ControllerOperation.FIND_FOR_PARDAVIMAS)
        {
            if(pardavimasModifikacijai.getId()==0)
            {
                windowManager.showManagePardavimas(event,ControllerOperation.CREATE,pardavimasModifikacijai,pardavimoLinijosModifikacijai);
            }
            else
            {
                windowManager.showManagePardavimas(event,ControllerOperation.UPDATE,pardavimasModifikacijai,pardavimoLinijosModifikacijai);
            }
        }
    }

    @FXML
    void ieskoti(ActionEvent event) {

    }

    private void fillKlientasTable()
    {
        ObservableList<Klientas> klientai = FXCollections.observableList(klientasService.getAllKlientai());
        columnId.setCellValueFactory(new PropertyValueFactory<Klientas,Integer>("id"));
        columnImone.setCellValueFactory(new PropertyValueFactory<Klientas,String>("imone"));
        columnPastas.setCellValueFactory(new PropertyValueFactory<Klientas,String>("pastas"));
        columnPavarde.setCellValueFactory(new PropertyValueFactory<Klientas,String>("pavarde"));
        columnVardas.setCellValueFactory(new PropertyValueFactory<Klientas,String>("vardas"));
        columnTelefonas.setCellValueFactory(new PropertyValueFactory<Klientas,String>("telefonas"));
        tableViewKlientai.setItems(klientai);
    }
}
