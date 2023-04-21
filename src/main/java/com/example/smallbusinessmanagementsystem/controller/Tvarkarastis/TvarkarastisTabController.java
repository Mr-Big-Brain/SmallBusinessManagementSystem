package com.example.smallbusinessmanagementsystem.controller.Tvarkarastis;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.model.SandelioPreke;
import com.example.smallbusinessmanagementsystem.model.Tvarkarastis;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.service.TvarkarastisService;
import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.CurrentVartotojas;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class TvarkarastisTabController implements Initializable {
    WindowManager windowManager;
    TvarkarastisService tvarkarastisService;
    VartotojasService vartotojasService;
    CurrentVartotojas currentVartotojas;
    public TvarkarastisTabController()
    {
        windowManager = new WindowManager();
        tvarkarastisService = new TvarkarastisService();
        vartotojasService = new VartotojasService();
        currentVartotojas = CurrentVartotojas.getInstance();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillTableManoRenginiai(datePickerManoNuo.getValue(),datePickerManoIki.getValue());
        fillTableSukurtiRenginiai(datePickerSukurtiNuo.getValue(),datePickerSukurtiIki.getValue());
    }
    @FXML
    private TableView<Tvarkarastis> tableViewManoTvarkarastis;

    @FXML
    private TableColumn<Tvarkarastis, LocalDate> columnManoData;

    @FXML
    private TableColumn<Tvarkarastis, String> columnManoPavadinimas;

    @FXML
    private TableColumn<Tvarkarastis, String> columnManoKasSukure;

    @FXML
    private DatePicker datePickerManoNuo;

    @FXML
    private DatePicker datePickerManoIki;

    @FXML
    private TextArea textAreaManoAprasymas;

    @FXML
    private TableView<Tvarkarastis> tableViewSukurtasTvarkarastis;

    @FXML
    private TableColumn<Tvarkarastis, LocalDate> columnSukurtiData;

    @FXML
    private TableColumn<Tvarkarastis, String> columnSukurtiPavadinimas;

    @FXML
    private TableColumn<Tvarkarastis, String> columnSukurtiKamSukurtas;

    @FXML
    private DatePicker datePickerSukurtiNuo;

    @FXML
    private DatePicker datePickerSukurtiIki;

    @FXML
    private Button buttonSukurtiRengini;

    @FXML
    private Button buttonIstrintiRengini;

    @FXML
    private Button buttonAtnaujintiRengini;

    @FXML
    private TextArea textAreaSukurtiAprasymas;

    @FXML
    void atnaujintiRengini(ActionEvent event) {
        windowManager.showManageRenginis(event,ControllerOperation.UPDATE,tableViewSukurtasTvarkarastis.getSelectionModel().getSelectedItem());
    }

    @FXML
    void istrintiRengini(ActionEvent event) {
        if(tvarkarastisService.tryDeleteTvarkarastis(tableViewSukurtasTvarkarastis.getSelectionModel().getSelectedItem().getId()))
        {
            AllertBox.display("Pavyko","Renginys ištrintas");
            textAreaSukurtiAprasymas.setText("");
            fillTableSukurtiRenginiai(datePickerSukurtiNuo.getValue(),datePickerSukurtiIki.getValue());
            fillTableManoRenginiai(datePickerManoNuo.getValue(),datePickerManoIki.getValue());
        }

    }

    @FXML
    void sukurtiRengini(ActionEvent event) {
        windowManager.showManageRenginis(event,ControllerOperation.CREATE,null);
    }
    private void fillTableManoRenginiai(LocalDate dateFrom, LocalDate dateUntil)
    {
        List<Tvarkarastis> tvarkarastisList = tvarkarastisService.getTvarkarastisByKamSukure(currentVartotojas.getVartotojas());
        ObservableList<Tvarkarastis> tvarkarastisObservableList = FXCollections.observableList(filterByDates(tvarkarastisList,dateFrom,dateUntil));
        columnManoData.setCellValueFactory(new PropertyValueFactory<Tvarkarastis,LocalDate>("data"));
        columnManoPavadinimas.setCellValueFactory(new PropertyValueFactory<Tvarkarastis,String>("pavadinimas"));
        columnManoKasSukure.setCellValueFactory(new PropertyValueFactory<Tvarkarastis,String>("kasSukure"));
        columnManoKasSukure.setCellValueFactory(cellData -> {
            if(cellData.getValue().getKasSukure()!=null)
            {
                int vartotojoId = cellData.getValue().getKasSukure().getId();
                Vartotojas vartotojasTemp = vartotojasService.getVartotojasById(vartotojoId);
                String vartotojas = (vartotojasTemp != null) ? vartotojasTemp.getVardas() + ", " + vartotojasTemp.getPavarde() : "";
                return new SimpleStringProperty(vartotojas);
            }
            else return new SimpleStringProperty("");
        });
        tableViewManoTvarkarastis.setItems(tvarkarastisObservableList);
    }
    @FXML
    void atnaujintiManoTvarkarasti(ActionEvent event) {
        fillTableManoRenginiai(datePickerManoNuo.getValue(),datePickerManoIki.getValue());
    }

    @FXML
    void atnaujintiSukurtusTvarkarascius(ActionEvent event) {
        fillTableSukurtiRenginiai(datePickerSukurtiNuo.getValue(),datePickerSukurtiIki.getValue());
    }
    @FXML
    void openManoAprasymas(MouseEvent event) {
        textAreaManoAprasymas.setText(tableViewManoTvarkarastis.getSelectionModel().getSelectedItem().getAprasymas());
    }
    @FXML
    void openSukurtasAprasymas(MouseEvent event) {
        textAreaSukurtiAprasymas.setText(tableViewSukurtasTvarkarastis.getSelectionModel().getSelectedItem().getAprasymas());
    }
    private void fillTableSukurtiRenginiai(LocalDate dateFrom, LocalDate dateUntil)
    {
        List<Tvarkarastis> tvarkarastisList = tvarkarastisService.getTvarkarastisByKasSukure(currentVartotojas.getVartotojas());
        ObservableList<Tvarkarastis> tvarkarastisObservableList = FXCollections.observableList(filterByDates(tvarkarastisList,dateFrom,dateUntil));
        columnSukurtiData.setCellValueFactory(new PropertyValueFactory<Tvarkarastis,LocalDate>("data"));
        columnSukurtiPavadinimas.setCellValueFactory(new PropertyValueFactory<Tvarkarastis,String>("pavadinimas"));
        columnSukurtiKamSukurtas.setCellValueFactory(new PropertyValueFactory<Tvarkarastis,String>("kamSukure"));
        columnSukurtiKamSukurtas.setCellValueFactory(cellData -> {
            if(cellData.getValue().getKamSukure()!=null)
            {
                int vartotojoId = cellData.getValue().getKamSukure().getId();
                Vartotojas vartotojasTemp = vartotojasService.getVartotojasById(vartotojoId);
                String vartotojas = (vartotojasTemp != null) ? vartotojasTemp.getVardas() + ", " + vartotojasTemp.getPavarde() : "";
                return new SimpleStringProperty(vartotojas);
            }
            else return new SimpleStringProperty("");
        });
        tableViewSukurtasTvarkarastis.setItems(tvarkarastisObservableList);
    }
    private List<Tvarkarastis> filterByDates(List<Tvarkarastis> tvarkarasciai, LocalDate dateFrom, LocalDate dateUntil)
    {
        if(!tvarkarasciai.isEmpty())
        {
            if(dateFrom!=null)
            {
                for(int i=tvarkarasciai.size()-1;i>=0;i--)
                {
                    if(tvarkarasciai.get(i).getData().isBefore(dateFrom))
                    {
                        tvarkarasciai.remove(i);
                    }
                }
            }
            if(dateUntil!=null)
            {
                for(int i=tvarkarasciai.size()-1;i>=0;i--)
                {
                    if(tvarkarasciai.get(i).getData().isAfter(dateUntil))
                    {
                        tvarkarasciai.remove(i);
                    }
                }
            }
        }
        return tvarkarasciai;
    }
}
