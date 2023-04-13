package com.example.smallbusinessmanagementsystem.controller;

import com.example.smallbusinessmanagementsystem.AllertBox;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class FindZymeController implements Initializable {
    ProduktasService produktasService;
    ZymeService zymeService;
    ControllerOperation controllerOperation;
    Produktas produktas;
    WindowManager windowManager;
    public FindZymeController(ControllerOperation controllerOperationn, Produktas produktass) {
        produktasService = new ProduktasService();
        zymeService = new ZymeService();
        controllerOperation = controllerOperationn;
        windowManager = new WindowManager();
        produktas = produktass;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            fillTableZyme();
    }
    @FXML
    private TableView<Zyme> tableViewZymes;

    @FXML
    private TableColumn<Zyme, Integer> columnID;

    @FXML
    private TableColumn<Zyme, String> columnPavadinimas;

    @FXML
    private Button buttonIeskoti;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private Button buttonPasirinkti;

    @FXML
    private Button buttonAtgal;

    @FXML
    void atgal(ActionEvent event) {
        windowManager.showTabKonfiguracijaProduktai(event);
    }

    @FXML
    void ieskoti(ActionEvent event) {
        filterZymes();
    }

    @FXML
    void pasirinkti(ActionEvent event) {
        if(controllerOperation==ControllerOperation.FIND_FOR_PRODUKTAS)
        {
            if(produktasService.addZyme(produktas,tableViewZymes.getSelectionModel().getSelectedItem().getId()))
            {
                AllertBox.display("Pavyko","Žymė pridėta");
                windowManager.showTabKonfiguracijaProduktai(event);
            }
        }
    }
    private void fillTableZyme()
    {
        ObservableList<Zyme> zymes = FXCollections.observableArrayList();
        if(controllerOperation==ControllerOperation.FIND_FOR_PRODUKTAS)
        {
            zymes = FXCollections.observableList(zymeService.getAllProduktaiZyme());
            if(!produktas.getZymes().isEmpty()&&!zymes.isEmpty())
            {
                List<Zyme> produktasZymes = produktas.getZymes();
                for(int i=zymes.size()-1;i>=0;i--)
                {
                    for(int j=produktasZymes.size()-1;j>=0;j--)
                    {
                        if(zymes.get(i).getId()==produktasZymes.get(j).getId())
                        {
                            zymes.remove(i);
                        }
                    }
                }
            }

        }
        columnID.setCellValueFactory(new PropertyValueFactory<Zyme,Integer>("id"));
        columnPavadinimas.setCellValueFactory(new PropertyValueFactory<Zyme,String>("pavadinimas"));
        tableViewZymes.setItems(zymes);
    }
    private void filterZymes()
    {
        fillTableZyme();
        ObservableList<Zyme> zymesObservable = tableViewZymes.getItems();
        List<Zyme> zymes = new ArrayList<>(zymesObservable);
        if(!zymes.isEmpty())
        {
            for(int i = zymes.size()-1;i>=0;i--)
            {
                if(!Objects.equals(textFieldPavadinimas.getText(), "") && !zymes.get(i).getPavadinimas().toLowerCase().contains(textFieldPavadinimas.getText().toLowerCase()))
                {
                    zymes.remove(i);
                }
                if(!Objects.equals(textFieldID.getText(), "") && !String.valueOf(zymes.get(i).getId()).contains(textFieldID.getText()))
                {
                    zymes.remove(i);
                }
            }
        }
        zymesObservable = FXCollections.observableList(zymes);
        tableViewZymes.setItems(zymesObservable);
    }
}
