package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai;

import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.service.VartotojoTipasService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class UpdateVartotojoRoleController {
    VartotojoTipasService vartotojoTipasService;
    VartotojoTipas vartotojoTipasModifikacijai;
    public UpdateVartotojoRoleController()
    {
        vartotojoTipasService = new VartotojoTipasService();
    }

    public void setData(VartotojoTipas vartotojoTipas)
    {
        VartotojoTipasService vartotojoTipasService;

        vartotojoTipasModifikacijai = vartotojoTipas;

        textFieldPavadinimas.setText(vartotojoTipas.getPavadinimas());
        checkBoxFinansai.setSelected(vartotojoTipas.getFinansai());
        checkBoxKlientai.setSelected(vartotojoTipas.getKlientai());
        checkBoxKonfiguracija.setSelected(vartotojoTipas.getKonfiguracija());
        checkBoxPardavimai.setSelected(vartotojoTipas.getPardavimai());
        checkBoxSandelis.setSelected(vartotojoTipas.getSandelis());
        checkBoxStatistika.setSelected(vartotojoTipas.getStatistika());
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
    private Button buttonAtnaujinti;

    @FXML
    private Button buttonAtgal;

    @FXML
    void atgal(ActionEvent event) {

    }

    @FXML
    void atnaujinti(ActionEvent event) {
        vartotojoTipasModifikacijai.setPavadinimas(textFieldPavadinimas.getText());
        vartotojoTipasModifikacijai.setFinansai(checkBoxFinansai.isSelected());
        vartotojoTipasModifikacijai.setKlientai(checkBoxKlientai.isSelected());
        vartotojoTipasModifikacijai.setKonfiguracija(checkBoxKonfiguracija.isSelected());
        vartotojoTipasModifikacijai.setPardavimai(checkBoxPardavimai.isSelected());
        vartotojoTipasModifikacijai.setSandelis(checkBoxSandelis.isSelected());
        vartotojoTipasModifikacijai.setStatistika(checkBoxStatistika.isSelected());

        vartotojoTipasService.atnaujintiVartotojoTipa(vartotojoTipasModifikacijai);
    }
}
