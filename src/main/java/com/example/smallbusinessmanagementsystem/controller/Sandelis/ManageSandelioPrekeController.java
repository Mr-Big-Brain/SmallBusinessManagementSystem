package com.example.smallbusinessmanagementsystem.controller.Sandelis;

import com.example.smallbusinessmanagementsystem.model.SandelioPreke;
import com.example.smallbusinessmanagementsystem.service.SandelioPrekeService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ManageSandelioPrekeController {
    SandelioPrekeService sandelioPrekeService;
    SandelioPreke sandelioPrekeModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManageSandelioPrekeController(ControllerOperation controllerOperationn, SandelioPreke sandelioPreke)
    {
        windowManager = new WindowManager();
        sandelioPrekeService = new SandelioPrekeService();
        sandelioPrekeModifikacijai = sandelioPreke;
        controllerOperation = controllerOperationn;
    }
    @FXML
    private TextField textFieldProduktas;

    @FXML
    private Button buttonPasirinktiProdukta;

    @FXML
    private TextField textFieldKiekis;

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
    void pasirinktiProdukta(ActionEvent event) {

    }

}
