package com.example.smallbusinessmanagementsystem.controller.Finansai;

import com.example.smallbusinessmanagementsystem.model.Finansas;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.service.FinansasService;
import com.example.smallbusinessmanagementsystem.service.VartotojoTipasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ManageFinansasController {
    FinansasService finansasService;
    Finansas finansasModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManageFinansasController(ControllerOperation controllerOperationn, Finansas finansas)
    {
        windowManager = new WindowManager();
        finansasService = new FinansasService();
        finansasModifikacijai = finansas;
        controllerOperation = controllerOperationn;
    }
    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private DatePicker datePickerData;

    @FXML
    private TextField textFieldKiekis;

    @FXML
    private ListView<?> listViewZymes;

    @FXML
    private TextField textFieldDarbuotojas;

    @FXML
    private ChoiceBox<?> choiceBoxTipas;

    @FXML
    private TextField textFieldApibudinimas;

    @FXML
    private Button buttonAtgal;

    @FXML
    private Button buttonAction;

    @FXML
    private Button buttonPridetiZyme;

    @FXML
    private Button buttonIstrintiZyme;

    @FXML
    void action(ActionEvent event) {

    }

    @FXML
    void atgal(ActionEvent event) {

    }

    @FXML
    void istrinti(ActionEvent event) {

    }

    @FXML
    void prideti(ActionEvent event) {

    }

}

