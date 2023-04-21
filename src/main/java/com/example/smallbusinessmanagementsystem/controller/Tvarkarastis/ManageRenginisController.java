package com.example.smallbusinessmanagementsystem.controller.Tvarkarastis;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Tvarkarastis;
import com.example.smallbusinessmanagementsystem.service.TvarkarastisService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.CurrentVartotojas;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManageRenginisController implements Initializable {
    TvarkarastisService tvarkarastisService;
    Tvarkarastis tvarkarastisModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    CurrentVartotojas currentVartotojas;
    public ManageRenginisController(ControllerOperation controllerOperationn, Tvarkarastis tvarkarastis)
    {
        windowManager = new WindowManager();
        tvarkarastisService = new TvarkarastisService();
        tvarkarastisModifikacijai = tvarkarastis;
        if(tvarkarastisModifikacijai == null)
        {
            tvarkarastisModifikacijai = new Tvarkarastis();
        }
        controllerOperation = controllerOperationn;
        currentVartotojas = CurrentVartotojas.getInstance();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(controllerOperation == ControllerOperation.CREATE)
        {
            buttonAction.setText("Sukurti");
        }
        else if(controllerOperation == ControllerOperation.UPDATE)
        {
            buttonAction.setText("Atnaujinti");
        }
        fillData();
    }
    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private TextField textFieldZmogus;

    @FXML
    private Button buttonRastiZmogu;

    @FXML
    private DatePicker datePickerData;

    @FXML
    private Button buttonAtgal;

    @FXML
    private Button buttonAction;

    @FXML
    private TextArea textAreaAprasymas;

    @FXML
    void action(ActionEvent event) {
        if(controllerOperation == ControllerOperation.CREATE)
        {
            if(tvarkarastisService.tryCreateTvarkarastis(datePickerData.getValue(),textFieldPavadinimas.getText(),
                    textAreaAprasymas.getText(),currentVartotojas.getVartotojas(),
                    tvarkarastisModifikacijai.getKamSukure()))
            {
                AllertBox.display("Pavyko","Renginys sukurtas");
                windowManager.showTabTvarkarastis(event);
            }
        }
        else if(controllerOperation == ControllerOperation.UPDATE)
        {
            tvarkarastisModifikacijai.setData(datePickerData.getValue());
            tvarkarastisModifikacijai.setAprasymas(textAreaAprasymas.getText());
            tvarkarastisModifikacijai.setPavadinimas(textFieldPavadinimas.getText());
            if(tvarkarastisService.tryUpdateTvarkarastis(tvarkarastisModifikacijai))
            {
                AllertBox.display("Pavyko","Renginys atnaujintas");
                windowManager.showTabTvarkarastis(event);
            }
        }
    }

    @FXML
    void atgal(ActionEvent event) {
        windowManager.showTabTvarkarastis(event);
    }

    @FXML
    void rastiZmogu(ActionEvent event) {
        if(controllerOperation == ControllerOperation.CREATE)
        {
            tvarkarastisModifikacijai.setData(datePickerData.getValue());
            tvarkarastisModifikacijai.setAprasymas(textAreaAprasymas.getText());
            tvarkarastisModifikacijai.setPavadinimas(textFieldPavadinimas.getText());
            windowManager.showFindVartotojas(event,ControllerOperation.FIND_FOR_TVARKARASTIS,tvarkarastisModifikacijai);
        }
        else if(controllerOperation == ControllerOperation.UPDATE)
        {
            tvarkarastisModifikacijai.setData(datePickerData.getValue());
            tvarkarastisModifikacijai.setAprasymas(textAreaAprasymas.getText());
            tvarkarastisModifikacijai.setPavadinimas(textFieldPavadinimas.getText());
            windowManager.showFindVartotojas(event,ControllerOperation.FIND_FOR_TVARKARASTIS,tvarkarastisModifikacijai);
        }

    }

    private void fillData()
    {
        if(tvarkarastisModifikacijai!=null)
        {
            if(tvarkarastisModifikacijai.getAprasymas() != null && !Objects.equals(tvarkarastisModifikacijai.getAprasymas(), ""))
            {
                textAreaAprasymas.setText(tvarkarastisModifikacijai.getAprasymas());
            }
            if(tvarkarastisModifikacijai.getPavadinimas() != null && tvarkarastisModifikacijai.getPavadinimas()!="")
            {
                textFieldPavadinimas.setText(tvarkarastisModifikacijai.getPavadinimas());
            }
            if(tvarkarastisModifikacijai.getKamSukure()!=null)
            {
                textFieldZmogus.setText(tvarkarastisModifikacijai.getKamSukure().getVardas() + " " + tvarkarastisModifikacijai.getKamSukure().getPavarde());
            }
            if(tvarkarastisModifikacijai.getData()!=null)
            {
                datePickerData.setValue(tvarkarastisModifikacijai.getData());
            }
        }

    }


}
