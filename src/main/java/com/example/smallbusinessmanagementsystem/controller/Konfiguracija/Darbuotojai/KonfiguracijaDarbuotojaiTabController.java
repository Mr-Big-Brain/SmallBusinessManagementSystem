package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.service.VartotojoTipasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class KonfiguracijaDarbuotojaiTabController implements Initializable {

    VartotojoTipasService vartotojoTipasService;
    VartotojasService vartotojasService;
    WindowManager windowManager;
    WindowLoader windowLoader;
    public KonfiguracijaDarbuotojaiTabController()
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabKonfiguracijaDarbuotojai()) {
            vartotojoTipasService = new VartotojoTipasService();
            vartotojasService = new VartotojasService();
            windowManager = new WindowManager();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(windowLoader.isTabKonfiguracijaDarbuotojai())
        {
            fillRolesTable();
            fillDarbuotojaiTable();
        }
    }
    @FXML
    private TableView<Vartotojas> tableViewDarbuotojai;

    @FXML
    private TableView<VartotojoTipas> tableViewRoles;

    @FXML
    private TableColumn<Vartotojas, Integer> columnDarbuotojaiID;

    @FXML
    private TableColumn<Vartotojas, String> columnDarbuotojaiVardas;

    @FXML
    private TableColumn<Vartotojas, String> columnDarbuotojaiPavarde;

    @FXML
    private TableColumn<Vartotojas, String> columnDarbuotojaiTelefonas;

    @FXML
    private TableColumn<Vartotojas, String> columnDarbuotojaiRole;

    @FXML
    private TableColumn<Vartotojas, String> columnDarbuotojaiApibrezimas;

    @FXML
    private TableColumn<Vartotojas, String> columnDarbuotojaiPrisijungimas;

    @FXML
    private Button buttonDarbuotojaiPrideti;

    @FXML
    private Button buttonDarbuotojaiRedaguoti;

    @FXML
    private Button buttonDarbuotojaiIstrinti;

    @FXML
    private TableColumn<VartotojoTipas, Integer> columnRolesID;

    @FXML
    private TableColumn<VartotojoTipas, String> columnRolesPavadinimas;

    @FXML
    private TableColumn<VartotojoTipas, Boolean> columnRolesPardavimai;

    @FXML
    private TableColumn<VartotojoTipas, Boolean> columnRolesFinansai;

    @FXML
    private TableColumn<VartotojoTipas, Boolean> columnRolesSandelis;

    @FXML
    private TableColumn<VartotojoTipas, Boolean> columnRolesKlientai;

    @FXML
    private TableColumn<VartotojoTipas, Boolean> columnRolesStatistika;

    @FXML
    private TableColumn<VartotojoTipas, Boolean> columnRolesKonguracija;

    @FXML
    private Button buttonRolesPrideti;

    @FXML
    private Button buttonRolesRedaguoti;

    @FXML
    private Button buttonRolesIstrinti;

    @FXML
    void darbuotojaiIstrinti(ActionEvent event) {
        if(vartotojasService.tryDeleteVartotojas(tableViewDarbuotojai.getSelectionModel().getSelectedItem().getId()))
        {
            AllertBox.display("Pavyko", "Vartotojas ištrintas");
            fillDarbuotojaiTable();
        }
    }

    @FXML
    void darbuotojaiPrideti(ActionEvent event) {
        windowManager.showManageVartotojas(event,ControllerOperation.CREATE,null);
    }

    @FXML
    void darbuotojaiRedaguoti(ActionEvent event) {
        windowManager.showManageVartotojas(event,ControllerOperation.UPDATE,tableViewDarbuotojai.getSelectionModel().getSelectedItem());
    }

    @FXML
    void rolesIstrinti(ActionEvent event) {
        int id = tableViewRoles.getSelectionModel().getSelectedItem().getId();
        if(vartotojoTipasService.tryDeleteVartotojoTipa(id))
        {
            AllertBox.display("Pavyko", "Rolė ištrinta");
            fillRolesTable();
        }
    }

    @FXML
    void rolesPrideti(ActionEvent event) throws IOException {
        windowManager.showManageRole(event, ControllerOperation.CREATE,null);
    }

    @FXML
    void rolesRedaguoti(ActionEvent event) throws IOException {
        windowManager.showManageRole(event, ControllerOperation.UPDATE,tableViewRoles.getSelectionModel().getSelectedItem());
    }

    public void fillRolesTable()
    {
        ObservableList<VartotojoTipas> vartotojoTipai = FXCollections.observableList(vartotojoTipasService.getAllVartotojoTipas());
        columnRolesID.setCellValueFactory(new PropertyValueFactory<VartotojoTipas,Integer>("id"));
        columnRolesFinansai.setCellValueFactory(new PropertyValueFactory<VartotojoTipas,Boolean>("finansai"));
        columnRolesKlientai.setCellValueFactory(new PropertyValueFactory<VartotojoTipas,Boolean>("klientai"));
        columnRolesKonguracija.setCellValueFactory(new PropertyValueFactory<VartotojoTipas,Boolean>("konfiguracija"));
        columnRolesPavadinimas.setCellValueFactory(new PropertyValueFactory<VartotojoTipas,String>("pavadinimas"));
        columnRolesStatistika.setCellValueFactory(new PropertyValueFactory<VartotojoTipas,Boolean>("statistika"));
        columnRolesSandelis.setCellValueFactory(new PropertyValueFactory<VartotojoTipas,Boolean>("sandelis"));
        columnRolesPardavimai.setCellValueFactory(new PropertyValueFactory<VartotojoTipas,Boolean>("pardavimai"));
        tableViewRoles.setItems(vartotojoTipai);
    }

    public void fillDarbuotojaiTable()
    {
        ObservableList<Vartotojas> vartotojai = FXCollections.observableList(vartotojasService.getAllVartotojas());
        columnDarbuotojaiID.setCellValueFactory(new PropertyValueFactory<Vartotojas,Integer>("id"));
        columnDarbuotojaiApibrezimas.setCellValueFactory(new PropertyValueFactory<Vartotojas,String>("apibrezimas"));
        columnDarbuotojaiPavarde.setCellValueFactory(new PropertyValueFactory<Vartotojas,String>("pavarde"));
        columnDarbuotojaiTelefonas.setCellValueFactory(new PropertyValueFactory<Vartotojas,String>("telefonas"));
        columnDarbuotojaiVardas.setCellValueFactory(new PropertyValueFactory<Vartotojas,String>("vardas"));
        columnDarbuotojaiPrisijungimas.setCellValueFactory(new PropertyValueFactory<Vartotojas,String>("prisijungimoVardas"));
        columnDarbuotojaiRole.setCellValueFactory(new PropertyValueFactory<Vartotojas,String>("vartotojoTipas"));
        columnDarbuotojaiRole.setCellValueFactory(cellData -> {
            int rolesId = cellData.getValue().getVartotojoTipas().getId();
            VartotojoTipas vartotojoTipas = vartotojoTipasService.getVartotojoTipasById(rolesId);
            String vartotojoTipoPavadinimas = (vartotojoTipas != null) ? vartotojoTipas.getPavadinimas() : "";
            return new SimpleStringProperty(vartotojoTipoPavadinimas);
        });
        tableViewDarbuotojai.setItems(vartotojai);
    }
}
