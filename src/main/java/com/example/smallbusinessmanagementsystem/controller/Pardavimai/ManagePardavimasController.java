package com.example.smallbusinessmanagementsystem.controller.Pardavimai;

import com.example.smallbusinessmanagementsystem.model.Pardavimas;
import com.example.smallbusinessmanagementsystem.service.PardavimasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ManagePardavimasController {
    PardavimasService pardavimasService;
    Pardavimas pardavimasModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManagePardavimasController(ControllerOperation controllerOperationn, Pardavimas pardavimas)
    {
        windowManager = new WindowManager();
        pardavimasService = new PardavimasService();
        pardavimasModifikacijai = pardavimas;
        controllerOperation = controllerOperationn;
    }
    @FXML
    private TableView<?> tableViewPardavimoLinijos;

    @FXML
    private TableColumn<?, ?> columnProduktas;

    @FXML
    private TableColumn<?, ?> columnKiekis;

    @FXML
    private TableColumn<?, ?> columnKainaVieneto;

    @FXML
    private TextField textFieldPirkejas;

    @FXML
    private Button buttonPridetiPirkeja;

    @FXML
    private TextField textFieldDarbuotojas;

    @FXML
    private Button buttonPridetiDarbuotoja;

    @FXML
    private Button buttonPridetiPardavimoLinija;

    @FXML
    private Button buttonPakeistiPardavimoLinija;

    @FXML
    private Button buttonIstrintiPardavimoLinija;

    @FXML
    private Button buttonAtgal;

    @FXML
    void atgal(ActionEvent event) {

    }

    @FXML
    void istrintiPardavimoLinija(ActionEvent event) {

    }

    @FXML
    void pakeistiPardavimoLinija(ActionEvent event) {

    }

    @FXML
    void pridetiDarbuotoja(ActionEvent event) {

    }

    @FXML
    void pridetiPardavimoLinija(ActionEvent event) {

    }

    @FXML
    void pridetiPirkeja(ActionEvent event) {

    }

}
