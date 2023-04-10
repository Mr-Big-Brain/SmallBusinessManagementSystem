package com.example.smallbusinessmanagementsystem.controller.Pardavimai;

import com.example.smallbusinessmanagementsystem.model.PardavimoLinija;
import com.example.smallbusinessmanagementsystem.service.PardavimoLinijaService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ManagePardavimoLinijaController {
    PardavimoLinijaService pardavimoLinijaService;
    PardavimoLinija pardavimoLinijaModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManagePardavimoLinijaController(ControllerOperation controllerOperationn, PardavimoLinija pardavimoLinija)
    {
        windowManager = new WindowManager();
        pardavimoLinijaService = new PardavimoLinijaService();
        pardavimoLinijaModifikacijai = pardavimoLinija;
        controllerOperation = controllerOperationn;
    }
    @FXML
    private TextField textFieldProduktas;

    @FXML
    private TextField textFieldKainaVieneto;

    @FXML
    private TextField textFieldKiekis;

    @FXML
    private Button buttonAtgal;

    @FXML
    private Button buttonAction;

    @FXML
    private Button buttonPridetiProdukta;

    @FXML
    void action(ActionEvent event) {

    }

    @FXML
    void atgal(ActionEvent event) {

    }

    @FXML
    void pridetiProdukta(ActionEvent event) {

    }

}
