package com.example.smallbusinessmanagementsystem.controller;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Finansas;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.service.ProduktasService;
import com.example.smallbusinessmanagementsystem.service.ZymeService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.FinansoTipas;
import com.example.smallbusinessmanagementsystem.utilities.StatistikaProduktaiChoice;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class FindZymeController implements Initializable {
    ProduktasService produktasService;
    ZymeService zymeService;
    ControllerOperation controllerOperation;
    Produktas produktasModifikacijai;
    Finansas finansasModifikacijai;
    WindowManager windowManager;
    List<Zyme> zymeList;
    LocalDate nuo;
    LocalDate iki;
    FinansoTipas finansoTipas;
    StatistikaProduktaiChoice statistikaProduktaiChoice;
    public FindZymeController(ControllerOperation controllerOperationn, Object object) {
        produktasService = new ProduktasService();
        zymeService = new ZymeService();
        controllerOperation = controllerOperationn;
        windowManager = new WindowManager();
        if(object instanceof Produktas)
        {
            produktasModifikacijai = (Produktas) object;
        }
        if(object instanceof Finansas)
        {
            finansasModifikacijai = (Finansas) object;
        }

    }
    public FindZymeController(ControllerOperation controllerOperationn, List<Zyme> zymeList, LocalDate nuo, LocalDate iki, FinansoTipas finansoTipas) {
        produktasService = new ProduktasService();
        zymeService = new ZymeService();
        controllerOperation = controllerOperationn;
        windowManager = new WindowManager();
        this.zymeList = zymeList;
        this.nuo = nuo;
        this.iki = iki;
        this.finansoTipas = finansoTipas;
    }
    public FindZymeController(ControllerOperation controllerOperationn, List<Zyme> zymeList, LocalDate nuo, LocalDate iki, StatistikaProduktaiChoice statistikaProduktaiChoice) {
        produktasService = new ProduktasService();
        zymeService = new ZymeService();
        controllerOperation = controllerOperationn;
        windowManager = new WindowManager();
        this.zymeList = zymeList;
        this.nuo = nuo;
        this.iki = iki;
        this.statistikaProduktaiChoice = statistikaProduktaiChoice;
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

        if(controllerOperation == ControllerOperation.FIND_FOR_STATISTIKA_ZYMES)
        {
            windowManager.showTabStatistikaZymes(event, zymeList, nuo, iki, statistikaProduktaiChoice);
            System.out.println(zymeList + " " + nuo + " " + iki + " " + statistikaProduktaiChoice);
        }
        else if(controllerOperation == ControllerOperation.FIND_FOR_STATISTIKA_FINANSAI)
        {
            windowManager.showTabStatistikaFinansai(event, zymeList, nuo, iki, finansoTipas);
            System.out.println(zymeList + " " + nuo + " " + iki + " " + finansoTipas);
        }
        else
        {
            windowManager.showTabKonfiguracijaProduktai(event);
        }
    }

    @FXML
    void ieskoti(ActionEvent event) {
        filterZymes();
    }

    @FXML
    void pasirinkti(ActionEvent event) {
        if(controllerOperation==ControllerOperation.FIND_FOR_PRODUKTAS)
        {
            if(produktasService.addZyme(produktasModifikacijai,tableViewZymes.getSelectionModel().getSelectedItem().getId()))
            {
                AllertBox.display("Pavyko","Žymė pridėta");
                windowManager.showTabKonfiguracijaProduktai(event);
            }
        }
        if(controllerOperation==ControllerOperation.FIND_FOR_FINANSAS)
        {
            finansasModifikacijai.addZyme(tableViewZymes.getSelectionModel().getSelectedItem());
            if(finansasModifikacijai.getId()==0)
            {

                windowManager.showManageFinansas(event,ControllerOperation.CREATE,finansasModifikacijai);
            }
            else
            {
                windowManager.showManageFinansas(event,ControllerOperation.UPDATE,finansasModifikacijai);
            }
        }
        if(controllerOperation==ControllerOperation.FIND_FOR_STATISTIKA_ZYMES)
        {
            zymeList.add(tableViewZymes.getSelectionModel().getSelectedItem());
            windowManager.showTabStatistikaZymes(event, zymeList, nuo, iki, statistikaProduktaiChoice);
        }
        if(controllerOperation==ControllerOperation.FIND_FOR_STATISTIKA_FINANSAI)
        {
            zymeList.add(tableViewZymes.getSelectionModel().getSelectedItem());
            windowManager.showTabStatistikaFinansai(event,zymeList, nuo, iki, finansoTipas);
        }
    }
    private void fillTableZyme()
    {
        ObservableList<Zyme> zymes = FXCollections.observableArrayList();
        if(controllerOperation==ControllerOperation.FIND_FOR_PRODUKTAS)
        {
            zymes = FXCollections.observableList(zymeService.getAllProduktaiZyme());
            if(!produktasModifikacijai.getZymes().isEmpty()&&!zymes.isEmpty())
            {
                List<Zyme> produktasZymes = produktasModifikacijai.getZymes();
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
        if(controllerOperation==ControllerOperation.FIND_FOR_FINANSAS)
        {
            zymes = FXCollections.observableList(zymeService.getAllFinansaiZyme());
            if(!finansasModifikacijai.getZymes().isEmpty()&&!zymes.isEmpty())
            {
                List<Zyme> finansasZymes = finansasModifikacijai.getZymes();
                for(int i=zymes.size()-1;i>=0;i--)
                {
                    for(int j=finansasZymes.size()-1;j>=0;j--)
                    {
                        if(zymes.get(i).getId()==finansasZymes.get(j).getId())
                        {
                            zymes.remove(i);
                        }
                    }
                }
            }
        }
        if(controllerOperation == ControllerOperation.FIND_FOR_STATISTIKA_FINANSAI)
        {
            zymes = FXCollections.observableList(zymeService.getAllFinansaiZyme());
            if(!zymeList.isEmpty())
            {
                for(int i=zymes.size()-1;i>=0;i--)
                {
                    for(int j=zymeList.size()-1;j>=0;j--)
                    {
                        if(zymes.get(i).getId()==zymeList.get(j).getId())
                        {
                            zymes.remove(i);
                        }
                    }
                }
            }
        }
        if(controllerOperation == ControllerOperation.FIND_FOR_STATISTIKA_ZYMES)
        {
            zymes = FXCollections.observableList(zymeService.getAllProduktaiZyme());
            if(!zymeList.isEmpty())
            {
                for(int i=zymes.size()-1;i>=0;i--)
                {
                    for(int j=zymeList.size()-1;j>=0;j--)
                    {
                        if(zymes.get(i).getId()==zymeList.get(j).getId())
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
