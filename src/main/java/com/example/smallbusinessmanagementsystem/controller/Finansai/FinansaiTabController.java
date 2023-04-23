package com.example.smallbusinessmanagementsystem.controller.Finansai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Finansas;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.service.FinansasService;
import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.service.ZymeService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.CurrentVartotojas;
import com.example.smallbusinessmanagementsystem.utilities.FinansoTipas;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class FinansaiTabController implements Initializable {
    WindowManager windowManager;
    FinansasService finansasService;
    CurrentVartotojas currentVartotojas;
    VartotojasService vartotojasService;
    ZymeService zymeService;
    public FinansaiTabController()
    {
        windowManager = new WindowManager();
        finansasService = new FinansasService();
        currentVartotojas = CurrentVartotojas.getInstance();
        vartotojasService = new VartotojasService();
        zymeService = new ZymeService();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillChoiceBox(FinansoTipas.VISI);
        fillTableViewFinansai(FinansoTipas.VISI);
    }
    @FXML
    private Button buttonNaujasFinansas;

    @FXML
    private Button buttonRedaguotiFinansa;

    @FXML
    private Button buttonIstrintiFinansa;

    @FXML
    private CheckBox checkBoxSuPardavimais;

    @FXML
    private Button buttonRastiFinansa;

    @FXML
    private TableView<Finansas> tableViewFinansai;

    @FXML
    private TableColumn<Finansas, Integer> columnID;

    @FXML
    private TableColumn<Finansas, FinansoTipas> columnTipas;

    @FXML
    private TableColumn<Finansas, Double> columnKiekis;

    @FXML
    private TableColumn<Finansas, String> columnPavadinimas;

    @FXML
    private TableColumn<Finansas, String> columnApibudinimas;

    @FXML
    private TableColumn<Finansas, LocalDate> columnData;

    @FXML
    private TableColumn<Finansas, String> columnZymes;

    @FXML
    private TableColumn<Finansas, String> columnDarbuotojas;

    @FXML
    private ChoiceBox<FinansoTipas> choiceBoxTipas;

    @FXML
    void istrintiFinansa(ActionEvent event) {
        if(finansasService.tryDeleteFinansas(tableViewFinansai.getSelectionModel().getSelectedItem().getId()))
        {
            AllertBox.display("Pavyko", "Finansas ištrintas");
            fillTableViewFinansai(choiceBoxTipas.getValue());
        }
    }

    @FXML
    void naujasFinansas(ActionEvent event) {
        Finansas naujasFinansas = new Finansas();
        naujasFinansas.setVartotojas(currentVartotojas.getVartotojas());
        windowManager.showManageFinansas(event, ControllerOperation.CREATE,naujasFinansas);
    }

    @FXML
    void rastiFinansa(ActionEvent event) {

    }

    @FXML
    void redaguotiFinansa(ActionEvent event) {
        windowManager.showManageFinansas(event, ControllerOperation.UPDATE,tableViewFinansai.getSelectionModel().getSelectedItem());
    }
    @FXML
    void sortFinansai(ActionEvent event) {
        fillTableViewFinansai(choiceBoxTipas.getValue());
    }
    private void fillChoiceBox(FinansoTipas finansoTipas)
    {
        choiceBoxTipas.getItems().clear();
        choiceBoxTipas.getItems().addAll(FinansoTipas.VISI,FinansoTipas.ISLAIDOS,FinansoTipas.PAJAMOS);
        choiceBoxTipas.setValue(finansoTipas);
    }
    private void fillTableViewFinansai(FinansoTipas finansoTipas)
    {
        ObservableList<Finansas> finansai = FXCollections.observableArrayList();
        columnID.setCellValueFactory(new PropertyValueFactory<Finansas, Integer>("id"));
        columnApibudinimas.setCellValueFactory(new PropertyValueFactory<Finansas,String>("apibudinimas"));
        columnPavadinimas.setCellValueFactory(new PropertyValueFactory<Finansas,String>("pavadinimas"));
        columnData.setCellValueFactory(new PropertyValueFactory<Finansas, LocalDate>("data"));
        columnKiekis.setCellValueFactory(new PropertyValueFactory<Finansas, Double>("kiekis"));
        columnTipas.setCellValueFactory(new PropertyValueFactory<Finansas, FinansoTipas>("tipas"));
        columnDarbuotojas.setCellValueFactory(new PropertyValueFactory<Finansas,String>("vartotojas"));
        columnDarbuotojas.setCellValueFactory(cellData -> {
            if(cellData.getValue().getVartotojas()!=null)
            {
                int vartotojoId = cellData.getValue().getVartotojas().getId();
                Vartotojas vartotojasTemp = vartotojasService.getVartotojasById(vartotojoId);
                String vartotojas = (vartotojasTemp != null) ? vartotojasTemp.getVardas() + ", " + vartotojasTemp.getPavarde() : "";
                return new SimpleStringProperty(vartotojas);
            }
            else return new SimpleStringProperty("");
        });
        columnZymes.setCellValueFactory(new PropertyValueFactory<Finansas, String>("tipas"));
        columnZymes.setCellValueFactory(cellData -> {
            if(cellData.getValue().getZymes()!=null)
            {
                int zymesCount = cellData.getValue().getZymes().size();
                String zymesString = "";
                int zymesId;
                for(int i=0;i<zymesCount;i++)
                {
                    zymesId = cellData.getValue().getZymes().get(i).getId();
                    Zyme zymeTemp = zymeService.getZymeById(zymesId);

                    if(i==0)
                    {
                        zymesString+=zymeTemp.getPavadinimas();
                    }
                    else
                    {
                        zymesString+=", " + zymeTemp.getPavadinimas();
                    }
                }
                return new SimpleStringProperty(zymesString);
            }
            else return new SimpleStringProperty("");
        });
        if(finansoTipas == FinansoTipas.VISI)
        {
            finansai = FXCollections.observableList(finansasService.getAllFinanasai());
        }
        if(finansoTipas == FinansoTipas.ISLAIDOS)
        {
            finansai = FXCollections.observableList(finansasService.getAllIslaidos());
        }
        if(finansoTipas == FinansoTipas.PAJAMOS)
        {
            finansai = FXCollections.observableList(finansasService.getAllPajamos());
        }
        tableViewFinansai.setItems(finansai);
    }
}
