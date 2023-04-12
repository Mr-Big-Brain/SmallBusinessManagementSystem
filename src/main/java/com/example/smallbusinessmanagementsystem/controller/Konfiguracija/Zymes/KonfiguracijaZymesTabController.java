package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Zymes;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.service.ZymeService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import com.example.smallbusinessmanagementsystem.utilities.ZymesTipas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class KonfiguracijaZymesTabController implements Initializable {
    WindowManager windowManager;
    ZymeService zymeService;
    public KonfiguracijaZymesTabController()
    {
        windowManager = new WindowManager();
        zymeService = new ZymeService();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setData("Visos");
    }
    @FXML
    private TableView<Zyme> tableViewZymes;

    @FXML
    private TableColumn<Zyme, Integer> columnZymesID;

    @FXML
    private TableColumn<Zyme, String> columnZymesPavadinimas;

    @FXML
    private TableColumn<Zyme, String> columnZymesTipas;

    @FXML
    private ChoiceBox<String> choiceBoxZymiuTipai;

    @FXML
    private Button buttonZymesPrideti;

    @FXML
    private Button buttonZymesPervadinti;

    @FXML
    private Button buttonZymesIstrinti;

    @FXML
    void istrintiZyme(ActionEvent event) {
        if(zymeService.tryDeleteZyme(tableViewZymes.getSelectionModel().getSelectedItem().getId()))
        {
            AllertBox.display("Pavyko","Žymė ištrinta");
            setData("Visos");
        }
    }

    @FXML
    void pervadintiZyme(ActionEvent event) {
        windowManager.showManageZyme(event,ControllerOperation.UPDATE, tableViewZymes.getSelectionModel().getSelectedItem());
    }

    @FXML
    void pridetiZyme(ActionEvent event) {
        windowManager.showManageZyme(event, ControllerOperation.CREATE,null);
    }
    @FXML
    void sortZymes(ActionEvent event) {
        fillTableView(choiceBoxZymiuTipai.getValue());
    }
    public void setData(String zymeType)
    {
        setChoiceBox(zymeType);
        fillTableView(choiceBoxZymiuTipai.getValue());
    }
    private void fillTableView(String filter)
    {
        ObservableList<Zyme> zymes = FXCollections.observableArrayList();
        columnZymesID.setCellValueFactory(new PropertyValueFactory<Zyme,Integer>("id"));
        columnZymesPavadinimas.setCellValueFactory(new PropertyValueFactory<Zyme,String>("pavadinimas"));
        columnZymesTipas.setCellValueFactory(new PropertyValueFactory<Zyme, String>("tipas"));

        if(Objects.equals(filter, "Visos"))
        {
            zymes = FXCollections.observableList(zymeService.getAllZyme());
        }
        if(Objects.equals(filter, "Finansai"))
        {
            zymes = FXCollections.observableList(zymeService.getAllFinansaiZyme());
        }
        if(Objects.equals(filter, "Produktai"))
        {
            zymes = FXCollections.observableList(zymeService.getAllProduktaiZyme());
        }
        tableViewZymes.setItems(zymes);
    }
    private void setChoiceBox(String pasirinkimas)
    {
        choiceBoxZymiuTipai.getItems().addAll("Visos","Finansai","Produktai");
        if(Objects.equals(pasirinkimas, "Visos"))
        {
            choiceBoxZymiuTipai.setValue("Visos");
        }
        if(Objects.equals(pasirinkimas, "Finansai"))
        {
            choiceBoxZymiuTipai.setValue("Finansai");
        }
        if(Objects.equals(pasirinkimas, "Produktai"))
        {
            choiceBoxZymiuTipai.setValue("Produktai");
        }
    }
}
