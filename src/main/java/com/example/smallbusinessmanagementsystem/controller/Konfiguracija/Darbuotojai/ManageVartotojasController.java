package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai;

import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ManageVartotojasController {
    VartotojasService vartotojasService;
    Vartotojas vartotojasModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManageVartotojasController(ControllerOperation controllerOperationn, Vartotojas vartotojas)
    {
        windowManager = new WindowManager();
        vartotojasService = new VartotojasService();
        vartotojasModifikacijai = vartotojas;
        controllerOperation = controllerOperationn;
    }

    @FXML
    private TextField textFieldVardas;

    @FXML
    private TextField textFieldPavarde;

    @FXML
    private TextField textFieldTelefonas;

    @FXML
    private TextField textFieldApibrezimas;

    @FXML
    private TableView<?> tableViewRoles;

    @FXML
    private TableColumn<?, ?> columnRole;

    @FXML
    private Button buttonAction;

    @FXML
    private Button buttonAtgal;

    @FXML
    void action(ActionEvent event) {

    }

    @FXML
    void atgal(ActionEvent event) {

    }

}
