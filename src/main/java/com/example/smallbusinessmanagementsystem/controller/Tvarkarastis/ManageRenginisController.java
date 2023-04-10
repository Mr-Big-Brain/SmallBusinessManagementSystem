package com.example.smallbusinessmanagementsystem.controller.Tvarkarastis;

import com.example.smallbusinessmanagementsystem.model.Tvarkarastis;
import com.example.smallbusinessmanagementsystem.service.TvarkarastisService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ManageRenginisController {
    TvarkarastisService tvarkarastisService;
    Tvarkarastis tvarkarastisModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManageRenginisController(ControllerOperation controllerOperationn, Tvarkarastis tvarkarastis)
    {
        windowManager = new WindowManager();
        tvarkarastisService = new TvarkarastisService();
        tvarkarastisModifikacijai = tvarkarastis;
        controllerOperation = controllerOperationn;
    }
    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private TextField textFieldAprasymas;

    @FXML
    private Label labelZmogus;

    @FXML
    private TextField textFieldZmogus;

    @FXML
    private Button buttonRastiZmogu;

    @FXML
    private DatePicker datePickerDataNuo;

    @FXML
    private TextField textFieldLaikasNuo;

    @FXML
    private DatePicker datePickerDataIki;

    @FXML
    private TextField textFieldLaikasIki;

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

    @FXML
    void rastiZmogu(ActionEvent event) {

    }

}
