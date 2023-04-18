package com.example.smallbusinessmanagementsystem.controller.Pardavimai;

import com.example.smallbusinessmanagementsystem.model.Finansas;
import com.example.smallbusinessmanagementsystem.model.Pardavimas;
import com.example.smallbusinessmanagementsystem.service.PardavimasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagePardavimasController implements Initializable {
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(controllerOperation == ControllerOperation.UPDATE)
        {
            buttonAction.setText("Atnaujinti");
            setData(pardavimasModifikacijai);
        }
        else if(controllerOperation == ControllerOperation.CREATE)
        {
            buttonAction.setText("Sukurti");
        }
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
    private Button buttonAction;

    @FXML
    private DatePicker datePickerData;

    @FXML
    private TextField textFieldLaikas;

    @FXML
    void action(ActionEvent event) {
        if(controllerOperation==ControllerOperation.UPDATE)
        {

        }
        else if(controllerOperation==ControllerOperation.CREATE)
        {

        }
    }

    @FXML
    void atgal(ActionEvent event) {
        windowManager.showTabPardavimai(event);
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
    public void setData(Pardavimas pardavimas)
    {

    }
}
