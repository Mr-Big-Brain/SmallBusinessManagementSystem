package com.example.smallbusinessmanagementsystem.controller;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.*;
import com.example.smallbusinessmanagementsystem.service.ProduktasService;
import com.example.smallbusinessmanagementsystem.service.SandelioPrekeService;
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
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FindProduktasController implements Initializable {
    ControllerOperation controllerOperation;
    WindowManager windowManager;
    Komunikacija komunikacijaModifikacijai;
    SandelioPreke sandelioPrekeModifikacijai;
    Pardavimas pardavimasModifikacijai;
    List<PardavimoLinija> pardavimoLinijosModifikacijai;
    Integer linijosNum;
    ProduktasService produktasService;
    SandelioPrekeService sandelioPrekeService;
    ZymeService zymeService;
    public FindProduktasController(ControllerOperation controllerOperationn, Object object) {
        controllerOperation = controllerOperationn;
        windowManager = new WindowManager();
        produktasService = new ProduktasService();
        zymeService = new ZymeService();
        sandelioPrekeService = new SandelioPrekeService();
        if(object instanceof Komunikacija)
        {
            komunikacijaModifikacijai = (Komunikacija) object;
        }
        else if(object instanceof SandelioPreke)
        {
            sandelioPrekeModifikacijai = (SandelioPreke) object;
        }
    }
    public FindProduktasController(ControllerOperation controllerOperationn, Pardavimas pardavimas, List<PardavimoLinija> pardavimoLinijos, Integer linijosNumm)
    {
        controllerOperation = controllerOperationn;
        windowManager = new WindowManager();
        produktasService = new ProduktasService();
        zymeService = new ZymeService();
        pardavimasModifikacijai = pardavimas;
        pardavimoLinijosModifikacijai = pardavimoLinijos;
        linijosNum = linijosNumm;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            fillProduktasTable();
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
    private TextField textFieldID;

    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private Button buttonPasirinkti;

    @FXML
    private Button buttonAtgal;

    @FXML
    void atgal(ActionEvent event) {
        if(controllerOperation == ControllerOperation.INCREASE || controllerOperation == ControllerOperation.DECREASE)
            windowManager.showManageSandelioPreke(event,controllerOperation,null);
    }

    @FXML
    void ieskoti(ActionEvent event) {
        fillProduktasTable();
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
        else if(controllerOperation == ControllerOperation.INCREASE || controllerOperation == ControllerOperation.DECREASE)
        {
            if(sandelioPrekeModifikacijai == null)
            {
                sandelioPrekeModifikacijai = new SandelioPreke();
            }
            sandelioPrekeModifikacijai.setProduktas(tableViewProduktai.getSelectionModel().getSelectedItem());
            windowManager.showManageSandelioPreke(event,controllerOperation,sandelioPrekeModifikacijai);
        }
        else if(controllerOperation == ControllerOperation.FIND_FOR_SANDELIS)
        {
            Produktas produktas = tableViewProduktai.getSelectionModel().getSelectedItem();
            SandelioPreke sandelioPreke = sandelioPrekeService.getSandelioPrekeByProduktas(produktas.getId());
            if(sandelioPreke == null || sandelioPreke.getKiekis()==0)
            {
                AllertBox.display("Informacija", produktas.getPavadinimas() + " produkto sandėlyje nėra");
            }
            else
            {
                AllertBox.display("Informacija","Liko " + sandelioPreke.getKiekis() + " " + produktas.getPavadinimas() + " vienetų");
            }
            windowManager.showTabSandelis(event);
        }
        else if(controllerOperation == ControllerOperation.FIND_FOR_PARDAVIMAS)
        {
            pardavimoLinijosModifikacijai.get(linijosNum).setProduktas(tableViewProduktai.getSelectionModel().getSelectedItem());
            pardavimoLinijosModifikacijai.get(linijosNum).setKainaUzViena(tableViewProduktai.getSelectionModel().getSelectedItem().getRekomenduojamaKaina());
            windowManager.showManagePardavimoLinija(event,ControllerOperation.CREATE,pardavimasModifikacijai,pardavimoLinijosModifikacijai,linijosNum);
        }
    }

    @FXML
    void prideti(ActionEvent event) {

    }

    @FXML
    void showZymes(MouseEvent event) {
        fillZymesTableView(tableViewProduktai.getSelectionModel().getSelectedItem());
    }

    private void fillProduktasTable()
    {
        ObservableList<Produktas> produktai = FXCollections.observableList(produktasService.getAllProduktai(textFieldID.getText(), textFieldPavadinimas.getText()));
        columnID.setCellValueFactory(new PropertyValueFactory<Produktas,Integer>("id"));
        columnPavadinimas.setCellValueFactory(new PropertyValueFactory<Produktas,String>("pavadinimas"));
        tableViewProduktai.setItems(produktai);
    }

    private void fillZymesTableView(Produktas produktas)
    {
        ObservableList<Zyme> zymes = FXCollections.observableList(produktas.getZymes());
        columnProduktoZyme.setCellValueFactory(new PropertyValueFactory<Zyme,String>("pavadinimas"));
        tableViewProduktuZymes.setItems(zymes);
    }
}
