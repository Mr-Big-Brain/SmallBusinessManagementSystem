package com.example.smallbusinessmanagementsystem.controller;

import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.persistenceController.VartotojoTipasPersistenceController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class KonfiguracijaDarbuotojaiTabController implements Initializable {

    //FXML
    private Stage stage;
    private Parent root;
    private Scene scene;

    VartotojoTipasPersistenceController vartotojoTipasPersistenceController;

    public KonfiguracijaDarbuotojaiTabController()
    {
        vartotojoTipasPersistenceController = new VartotojoTipasPersistenceController();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillRolesTable();
    }
    @FXML
    private TableView<?> tableViewDarbuotojai;

    @FXML
    private TableView<VartotojoTipas> tableViewRoles;

    @FXML
    private TableColumn<?, ?> columnDarbuotojaiID;

    @FXML
    private TableColumn<?, ?> columnDarbuotojaiVardas;

    @FXML
    private TableColumn<?, ?> columnDarbuotojaiPavarde;

    @FXML
    private TableColumn<?, ?> columnDarbuotojaiTelefonas;

    @FXML
    private TableColumn<?, ?> columnDarbuotojaiRole;

    @FXML
    private TableColumn<?, ?> columnDarbuotojaiApibrezimas;

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

    }

    @FXML
    void darbuotojaiPrideti(ActionEvent event) {

    }

    @FXML
    void darbuotojaiRedaguoti(ActionEvent event) {

    }

    @FXML
    void rolesIstrinti(ActionEvent event) {

    }

    @FXML
    void rolesPrideti(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KonfiguracijaDarbuotojaiTabController.class.getResource("/com/example/smallbusinessmanagementsystem/create-vartotojo-role-view.fxml"));
        root = (Parent)fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void rolesRedaguoti(ActionEvent event) {

    }

    public void fillRolesTable()
    {
        ObservableList<VartotojoTipas> vartotojoTipai = FXCollections.observableList(vartotojoTipasPersistenceController.getVartotojoTipasListFromDatabase());
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
}
