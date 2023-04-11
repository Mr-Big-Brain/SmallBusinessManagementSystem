package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.service.VartotojoTipasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageRoleController implements Initializable {
    VartotojoTipasService vartotojoTipasService;
    VartotojoTipas vartotojoTipasModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManageRoleController(ControllerOperation controllerOperationn, VartotojoTipas vartotojoTipas)
    {
        windowManager = new WindowManager();
        vartotojoTipasService = new VartotojoTipasService();
        vartotojoTipasModifikacijai = vartotojoTipas;
        controllerOperation = controllerOperationn;
    }

    public void setData(VartotojoTipas vartotojoTipas)
    {
        vartotojoTipasModifikacijai = vartotojoTipas;

        textFieldPavadinimas.setText(vartotojoTipas.getPavadinimas());
        checkBoxFinansai.setSelected(vartotojoTipas.getFinansai());
        checkBoxKlientai.setSelected(vartotojoTipas.getKlientai());
        checkBoxKonfiguracija.setSelected(vartotojoTipas.getKonfiguracija());
        checkBoxPardavimai.setSelected(vartotojoTipas.getPardavimai());
        checkBoxSandelis.setSelected(vartotojoTipas.getSandelis());
        checkBoxStatistika.setSelected(vartotojoTipas.getStatistika());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(controllerOperation == ControllerOperation.UPDATE)
        {
            setData(vartotojoTipasModifikacijai);
            buttonAction.setText("Atnaujinti");
        }
        else if(controllerOperation == ControllerOperation.CREATE)
        {
            buttonAction.setText("Sukurti");
        }
    }

    @FXML
    private CheckBox checkBoxPardavimai;

    @FXML
    private CheckBox checkBoxFinansai;

    @FXML
    private CheckBox checkBoxSandelis;

    @FXML
    private CheckBox checkBoxKlientai;

    @FXML
    private CheckBox checkBoxStatistika;

    @FXML
    private CheckBox checkBoxKonfiguracija;

    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private Button buttonAction;

    @FXML
    private Button buttonAtgal;

    @FXML
    void action(ActionEvent event) {
        if(controllerOperation==ControllerOperation.UPDATE)
        {
            vartotojoTipasModifikacijai.setPavadinimas(textFieldPavadinimas.getText());
            vartotojoTipasModifikacijai.setFinansai(checkBoxFinansai.isSelected());
            vartotojoTipasModifikacijai.setKlientai(checkBoxKlientai.isSelected());
            vartotojoTipasModifikacijai.setKonfiguracija(checkBoxKonfiguracija.isSelected());
            vartotojoTipasModifikacijai.setPardavimai(checkBoxPardavimai.isSelected());
            vartotojoTipasModifikacijai.setSandelis(checkBoxSandelis.isSelected());
            vartotojoTipasModifikacijai.setStatistika(checkBoxStatistika.isSelected());
            if(vartotojoTipasService.tryUpdateVartotojoTipa(vartotojoTipasModifikacijai))
            {
                AllertBox.display("Pavyko", "Rolė atnaujinta");
                windowManager.showTabKonfiguracijaDarbuotojai(event);
            }
        }
        else if(controllerOperation==ControllerOperation.CREATE)
        {
            if(vartotojoTipasService.tryCreateVartotojoTipa(
                    textFieldPavadinimas.getText(),checkBoxFinansai.isSelected(),
                    checkBoxKlientai.isSelected(),checkBoxKonfiguracija.isSelected(),
                    checkBoxPardavimai.isSelected(),checkBoxSandelis.isSelected(),checkBoxStatistika.isSelected()))
            {
                AllertBox.display("Pavyko", "Rolė sukurta");
                windowManager.showTabKonfiguracijaDarbuotojai(event);
            }
        }
    }

    @FXML
    void atgal(ActionEvent event) {
        windowManager.showTabKonfiguracijaDarbuotojai(event);
    }

}
