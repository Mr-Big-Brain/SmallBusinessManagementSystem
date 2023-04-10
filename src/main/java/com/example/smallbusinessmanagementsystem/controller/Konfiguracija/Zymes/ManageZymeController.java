package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Zymes;

import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.service.ZymeService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ManageZymeController {
    ZymeService zymeService;
    Zyme zymeModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManageZymeController(ControllerOperation controllerOperationn, Zyme zyme)
    {
        windowManager = new WindowManager();
        zymeService = new ZymeService();
        zymeModifikacijai = zyme;
        controllerOperation = controllerOperationn;
    }
    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private ChoiceBox<?> choiceBoxTipas;

    @FXML
    private Button buttonAtgal;

    @FXML
    private Button buttonAction;

    @FXML
    void action(ActionEvent event) {

    }

    @FXML
    void atgal(ActionEvent event) {

    }

}