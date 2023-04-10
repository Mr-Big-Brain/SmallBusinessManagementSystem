package com.example.smallbusinessmanagementsystem.controller.Klientai;

import com.example.smallbusinessmanagementsystem.model.Finansas;
import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.service.FinansasService;
import com.example.smallbusinessmanagementsystem.service.KlientasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ManageKlientasController {
    KlientasService klientasService;
    Klientas klientasModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManageKlientasController(ControllerOperation controllerOperationn, Klientas klientas)
    {
        windowManager = new WindowManager();
        klientasService = new KlientasService();
        klientasModifikacijai = klientas;
        controllerOperation = controllerOperationn;
    }
    @FXML
    private TextField textFieldVardas;

    @FXML
    private TextField textFieldPavarde;

    @FXML
    private TextField textFieldImone;

    @FXML
    private TextField textFieldTelefonoNumeris;

    @FXML
    private TextField textFieldElektroninisPastas;

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
