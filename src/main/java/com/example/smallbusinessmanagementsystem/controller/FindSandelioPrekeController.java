package com.example.smallbusinessmanagementsystem.controller;

import com.example.smallbusinessmanagementsystem.model.*;
import com.example.smallbusinessmanagementsystem.service.SandelioPrekeService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FindSandelioPrekeController implements Initializable {
    SandelioPrekeService sandelioPrekeService;

    ControllerOperation controllerOperation;
    List<PardavimoLinija> pardavimoLinijaList;
    Pardavimas pardavimas;
    int linijosNum;
    WindowManager windowManager;

    public FindSandelioPrekeController(ControllerOperation controllerOperation, List<PardavimoLinija> pardavimoLinijaList, Pardavimas pardavimas, int linijosNum) {
        this.sandelioPrekeService = new SandelioPrekeService();

        this.controllerOperation = controllerOperation;
        this.pardavimoLinijaList = pardavimoLinijaList;
        this.pardavimas = pardavimas;
        this.linijosNum = linijosNum;
        this.windowManager = new WindowManager();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(controllerOperation == ControllerOperation.CREATE_PARDAVIMAS || controllerOperation == ControllerOperation.UPDATE_PARDAVIMAS)
        {
            fillSandelioPrekesTable();
        }
    }

    @FXML
    private TableView<SandelioPreke> tableViewSandelioPrekes;

    @FXML
    private TableColumn<SandelioPreke, Integer> columnId;

    @FXML
    private TableColumn<SandelioPreke, String> columnProduktas;

    @FXML
    private TableColumn<SandelioPreke, Double> columnPirkimoKaina;

    @FXML
    private TableColumn<SandelioPreke, Integer> columnLikoSandelyje;

    @FXML
    private Button buttonAtgal;

    @FXML
    private Button buttonPasirinkti;

    @FXML
    void atgal(ActionEvent event) {
        if(controllerOperation == ControllerOperation.CREATE_PARDAVIMAS || controllerOperation == ControllerOperation.UPDATE_PARDAVIMAS)
        {
            windowManager.showManagePardavimoLinija(event, controllerOperation, pardavimas, pardavimoLinijaList, linijosNum);
        }

    }

    @FXML
    void pasirinkti(ActionEvent event) {
        if(pardavimoLinijaList==null)
        {
            pardavimoLinijaList = new ArrayList<>();
        }
        if(controllerOperation == ControllerOperation.CREATE_PARDAVIMAS || controllerOperation == ControllerOperation.UPDATE_PARDAVIMAS)
        {
            SandelioPreke tempSelectedItem = tableViewSandelioPrekes.getSelectionModel().getSelectedItem();
            pardavimoLinijaList.get(pardavimoLinijaList.size()-1).setKiekis(0);
            pardavimoLinijaList.get(pardavimoLinijaList.size()-1).setPirkimoKaina(tempSelectedItem.getPirkimoKaina());
            pardavimoLinijaList.get(pardavimoLinijaList.size()-1).setKainaUzViena(tempSelectedItem.getProduktas().getRekomenduojamaKaina());
            pardavimoLinijaList.get(pardavimoLinijaList.size()-1).setProduktas(tempSelectedItem.getProduktas());
            pardavimoLinijaList.get(pardavimoLinijaList.size()-1).setPardavimas(pardavimas);

            windowManager.showManagePardavimoLinija(event, controllerOperation, pardavimas, pardavimoLinijaList, linijosNum);
        }

    }

    void fillSandelioPrekesTable() {
        columnId.setCellValueFactory(new PropertyValueFactory<SandelioPreke,Integer>("id"));
        columnProduktas.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(String.valueOf(cellData.getValue().getProduktas().getId()) + ", " + cellData.getValue().getProduktas().getPavadinimas());
        });
        columnLikoSandelyje.setCellValueFactory(new PropertyValueFactory<SandelioPreke,Integer>("kiekis"));
        columnPirkimoKaina.setCellValueFactory(new PropertyValueFactory<SandelioPreke, Double>("pirkimoKaina"));
        ObservableList<SandelioPreke> sandelioPrekes = FXCollections.observableArrayList();
        if(controllerOperation==ControllerOperation.CREATE_PARDAVIMAS || controllerOperation==ControllerOperation.UPDATE_PARDAVIMAS)
        {
            sandelioPrekes = FXCollections.observableList(sandelioPrekeService.getAllSandelioPrekes());
            tableViewSandelioPrekes.setItems(sandelioPrekes);
        }
    }
}
