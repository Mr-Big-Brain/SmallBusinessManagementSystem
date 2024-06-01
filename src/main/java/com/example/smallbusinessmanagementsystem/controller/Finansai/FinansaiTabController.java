package com.example.smallbusinessmanagementsystem.controller.Finansai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Finansas;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.service.FinansasService;
import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.service.ZymeService;
import com.example.smallbusinessmanagementsystem.utilities.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
    WindowLoader windowLoader;
    public FinansaiTabController()
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabFinansai()) {
            windowManager = new WindowManager();
            finansasService = new FinansasService();
            currentVartotojas = CurrentVartotojas.getInstance();
            vartotojasService = new VartotojasService();
            zymeService = new ZymeService();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(windowLoader.isTabFinansai())
        {
            fillChoiceBoxes(FinansoTipas.VISI, FinansoStatusas.UŽBAIGTA);
            fillTableViewFinansai(FinansoTipas.VISI, FinansoStatusas.UŽBAIGTA, null, null, "");
        }
    }
    @FXML
    private Button buttonNaujasFinansas;

    @FXML
    private Button buttonRedaguotiFinansa;

    @FXML
    private Button buttonIstrintiFinansa;

    @FXML
    private Button buttonPerziuretiFinansa;

    @FXML
    private DatePicker datePickerNuo;

    @FXML
    private DatePicker datePickerIki;

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
    private TableColumn<Finansas, LocalDate> columnData;

    @FXML
    private TableColumn<Finansas, String> columnZymes;

    @FXML
    private TableColumn<Finansas, String> columnDarbuotojas;

    @FXML
    private ChoiceBox<FinansoTipas> choiceBoxTipas;

    @FXML
    private ChoiceBox<FinansoStatusas> choiceBoxStatusas;

    @FXML
    private TextField textFieldPaieska;

    @FXML
    void istrintiFinansa(ActionEvent event) {
        if(finansasService.tryDeleteFinansas(tableViewFinansai.getSelectionModel().getSelectedItem().getId()))
        {
            AllertBox.display("Pavyko", "Finansas ištrintas");
            fillTableViewFinansai(choiceBoxTipas.getValue(), choiceBoxStatusas.getValue(), datePickerNuo.getValue(), datePickerIki.getValue(), textFieldPaieska.getText());
        }
    }

    @FXML
    void naujasFinansas(ActionEvent event) {
        Finansas naujasFinansas = new Finansas();
        naujasFinansas.setVartotojas(currentVartotojas.getVartotojas());
        windowManager.showManageFinansas(event, ControllerOperation.CREATE,naujasFinansas);
    }

    @FXML
    void filterFinansai(ActionEvent event) {
        fillTableViewFinansai(choiceBoxTipas.getValue(), choiceBoxStatusas.getValue(), datePickerNuo.getValue(), datePickerIki.getValue(), textFieldPaieska.getText());
    }

    @FXML
    void ieskoti(ActionEvent event) {
        fillTableViewFinansai(choiceBoxTipas.getValue(), choiceBoxStatusas.getValue(), datePickerNuo.getValue(), datePickerIki.getValue(), textFieldPaieska.getText());
    }
    @FXML
    void perziuretiFinansa(ActionEvent event) {
        windowManager.showManageFinansas(event, ControllerOperation.REVIEW,tableViewFinansai.getSelectionModel().getSelectedItem());
    }

    @FXML
    void redaguotiFinansa(ActionEvent event) {
        windowManager.showManageFinansas(event, ControllerOperation.UPDATE,tableViewFinansai.getSelectionModel().getSelectedItem());
    }
    @FXML
    void sortFinansai(ActionEvent event) {

        FinansoStatusas chosenFinansoStatusas = choiceBoxStatusas.getValue();

        if (chosenFinansoStatusas != null) {
            switch (chosenFinansoStatusas) {
                case UŽBAIGTA -> buttonRedaguotiFinansa.setVisible(false);
                case LAUKIAMA -> buttonRedaguotiFinansa.setVisible(true);
                case ATŠAUKTA -> buttonRedaguotiFinansa.setVisible(false);
                default -> buttonRedaguotiFinansa.setVisible(true);
            }
        } else {
            buttonRedaguotiFinansa.setVisible(true);
        }

        fillTableViewFinansai(choiceBoxTipas.getValue(), choiceBoxStatusas.getValue(), datePickerNuo.getValue(), datePickerIki.getValue(), textFieldPaieska.getText());
    }
    private void fillChoiceBoxes(FinansoTipas finansoTipas, FinansoStatusas finansoStatusas)
    {
        choiceBoxTipas.getItems().clear();
        choiceBoxTipas.getItems().addAll(FinansoTipas.VISI,FinansoTipas.IŠLAIDOS,FinansoTipas.PAJAMOS);
        choiceBoxTipas.setValue(finansoTipas);

        choiceBoxStatusas.getItems().clear();
        choiceBoxStatusas.getItems().addAll(FinansoStatusas.UŽBAIGTA, FinansoStatusas.LAUKIAMA, FinansoStatusas.ATŠAUKTA);
        choiceBoxStatusas.setValue(finansoStatusas);
    }
    private void fillTableViewFinansai(FinansoTipas finansoTipas, FinansoStatusas finansoStatusas, LocalDate nuo, LocalDate iki, String searchString)
    {
        columnID.setCellValueFactory(new PropertyValueFactory<Finansas, Integer>("id"));
        columnPavadinimas.setCellValueFactory(new PropertyValueFactory<Finansas,String>("pavadinimas"));
        columnData.setCellValueFactory(new PropertyValueFactory<Finansas, LocalDate>("data"));
        columnKiekis.setCellValueFactory(new PropertyValueFactory<Finansas, Double>("kiekis"));
        columnTipas.setCellValueFactory(new PropertyValueFactory<Finansas, FinansoTipas>("tipas"));
        columnDarbuotojas.setCellValueFactory(new PropertyValueFactory<Finansas,String>("vartotojas"));
        columnDarbuotojas.setCellValueFactory(cellData -> {
            if(cellData.getValue().getVartotojas()!=null)
            {
                String vartotojas = (cellData.getValue().getVartotojas() != null) ? cellData.getValue().getVartotojas().getVardas() + " " + cellData.getValue().getVartotojas().getPavarde() : "";
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
                Zyme zymeTemp;
                for(int i=0;i<zymesCount;i++)
                {
                     zymeTemp = cellData.getValue().getZymes().get(i);

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

        tableViewFinansai.setItems(FXCollections.observableList(finansasService.getAllFinansaiForTable(finansoTipas, finansoStatusas, nuo, iki, searchString)));
    }
}
