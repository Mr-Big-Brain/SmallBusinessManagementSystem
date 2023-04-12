package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Produktai;

import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.service.ProduktasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ManageProduktasController {
    ProduktasService produktasService;
    Produktas produktasModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManageProduktasController(ControllerOperation controllerOperationn, Produktas produktas)
    {
        windowManager = new WindowManager();
        produktasService = new ProduktasService();
        produktasModifikacijai = produktas;
        controllerOperation = controllerOperationn;
    }
    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private TextField textFieldPirkimoKaina;

    @FXML
    private TextField textFieldRekomenduojamaKaina;

    @FXML
    private TextArea textAreaApibrezimas;

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