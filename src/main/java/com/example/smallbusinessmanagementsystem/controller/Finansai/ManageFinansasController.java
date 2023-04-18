package com.example.smallbusinessmanagementsystem.controller.Finansai;

import com.example.smallbusinessmanagementsystem.model.Finansas;
import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.service.FinansasService;
import com.example.smallbusinessmanagementsystem.service.VartotojoTipasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageFinansasController implements Initializable{
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(controllerOperation == ControllerOperation.UPDATE)
        {
            buttonAction.setText("Atnaujinti");
            setData(finansasModifikacijai);
        }
        else if(controllerOperation == ControllerOperation.CREATE)
        {
            buttonAction.setText("Sukurti");
        }
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
        if(controllerOperation==ControllerOperation.UPDATE)
        {

        }
        else if(controllerOperation==ControllerOperation.CREATE)
        {

        }
    }

    @FXML
    void atgal(ActionEvent event) {
        windowManager.showTabFinansai(event);
    }

    @FXML
    void istrinti(ActionEvent event) {

    }

    @FXML
    void prideti(ActionEvent event) {

    }
    public void setData(Finansas finansas)
    {

    }
}

