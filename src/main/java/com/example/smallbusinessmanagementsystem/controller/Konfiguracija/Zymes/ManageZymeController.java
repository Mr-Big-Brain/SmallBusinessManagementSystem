package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Zymes;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.service.ZymeService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import com.example.smallbusinessmanagementsystem.utilities.ZymesTipas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageZymeController implements Initializable {
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxTipas.getItems().addAll(ZymesTipas.values());
        if(controllerOperation == ControllerOperation.CREATE)
        {
            buttonAction.setText("Sukurti");
        }
        else if(controllerOperation == ControllerOperation.UPDATE)
        {
            textFieldPavadinimas.setText(zymeModifikacijai.getPavadinimas());
            choiceBoxTipas.setValue(zymeModifikacijai.getTipas());
            buttonAction.setText("Atnaujinti");
        }
    }
    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private ChoiceBox<ZymesTipas> choiceBoxTipas;

    @FXML
    private Button buttonAtgal;

    @FXML
    private Button buttonAction;

    @FXML
    void action(ActionEvent event) {
        if(controllerOperation == ControllerOperation.CREATE)
        {
            if(zymeService.tryCreateZyme(textFieldPavadinimas.getText(),choiceBoxTipas.getValue()))
            {
                AllertBox.display("Pavyko", "Žymė sukurta");
                windowManager.showTabKonfiguracijaZymes(event);
            }

        }
        else if(controllerOperation == ControllerOperation.UPDATE)
        {
            Zyme naujaZyme = new Zyme(textFieldPavadinimas.getText(),choiceBoxTipas.getValue());
            naujaZyme.setId(zymeModifikacijai.getId());
            if(zymeService.tryUpdateZyme(zymeModifikacijai,naujaZyme))
            {
                AllertBox.display("Pavyko","Žymė atnaujinta");
                windowManager.showTabKonfiguracijaZymes(event);
            }
        }
    }

    @FXML
    void atgal(ActionEvent event) {
        windowManager.showTabKonfiguracijaZymes(event);
    }

}