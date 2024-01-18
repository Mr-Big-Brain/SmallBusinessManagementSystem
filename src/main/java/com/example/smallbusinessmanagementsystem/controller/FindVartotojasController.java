package com.example.smallbusinessmanagementsystem.controller;

import com.example.smallbusinessmanagementsystem.model.*;
import com.example.smallbusinessmanagementsystem.service.ProduktasService;
import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.service.VartotojoTipasService;
import com.example.smallbusinessmanagementsystem.service.ZymeService;
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
import java.util.List;
import java.util.ResourceBundle;

public class FindVartotojasController implements Initializable {
    WindowManager windowManager;
    VartotojasService vartotojasService;
    VartotojoTipasService vartotojoTipasService;
    ControllerOperation controllerOperation;
    Tvarkarastis tvarkarastisModifikacijai;
    public FindVartotojasController(ControllerOperation controllerOperationn, Object object)
    {
        windowManager = new WindowManager();
        vartotojasService = new VartotojasService();
        vartotojoTipasService = new VartotojoTipasService();
        controllerOperation = controllerOperationn;
        if(object instanceof Tvarkarastis)
        {
            tvarkarastisModifikacijai = (Tvarkarastis) object;
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillVartotojaiTable();
    }
    @FXML
    private TableView<Vartotojas> tableViewVartotojai;

    @FXML
    private TableColumn<Vartotojas, String> columnPrisijungimas;

    @FXML
    private TableColumn<Vartotojas, String> columnVardas;

    @FXML
    private TableColumn<Vartotojas, String> columnPavarde;

    @FXML
    private TableColumn<Vartotojas, String> columnRole;

    @FXML
    private Button buttonAtgal;

    @FXML
    private Button buttonPasirinkti;

    @FXML
    void atgal(ActionEvent event) {
        if(controllerOperation == ControllerOperation.FIND_FOR_TVARKARASTIS)
        {
            windowManager.showManageRenginis(event,controllerOperation,tvarkarastisModifikacijai);
        }
    }

    @FXML
    void pasirinkti(ActionEvent event) {
        if(controllerOperation == ControllerOperation.FIND_FOR_TVARKARASTIS)
        {
            tvarkarastisModifikacijai.setKamSukure(tableViewVartotojai.getSelectionModel().getSelectedItem());
            if(tvarkarastisModifikacijai.getId()==0)
            {
                windowManager.showManageRenginis(event,ControllerOperation.CREATE,tvarkarastisModifikacijai);
            }
            else
            {
                windowManager.showManageRenginis(event,ControllerOperation.UPDATE,tvarkarastisModifikacijai);
            }


        }
    }
    private void fillVartotojaiTable()
    {
        {
            ObservableList<Vartotojas> vartotojai = FXCollections.observableArrayList(vartotojasService.getAllVartotojas());
            columnPavarde.setCellValueFactory(new PropertyValueFactory<Vartotojas,String>("pavarde"));
            columnPrisijungimas.setCellValueFactory(new PropertyValueFactory<Vartotojas,String>("prisijungimoVardas"));
            columnVardas.setCellValueFactory(new PropertyValueFactory<Vartotojas,String>("vardas"));
            columnRole.setCellValueFactory(new PropertyValueFactory<Vartotojas,String>("vartotojoTipas"));
            columnRole.setCellValueFactory(cellData -> {
                VartotojoTipas vartotojoTipas = cellData.getValue().getVartotojoTipas();
                String vartotojoTipoPavadinimas = (vartotojoTipas != null) ? vartotojoTipas.getPavadinimas() : "";
                return new SimpleStringProperty(vartotojoTipoPavadinimas);
            });
            tableViewVartotojai.setItems(vartotojai);
        }
    }
}
