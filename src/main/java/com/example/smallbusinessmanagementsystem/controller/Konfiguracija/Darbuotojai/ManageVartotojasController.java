package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.service.VartotojoTipasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.Md5Converter;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageVartotojasController implements Initializable {
    VartotojasService vartotojasService;
    VartotojoTipasService vartotojoTipasService;
    Vartotojas vartotojasModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    Md5Converter md5Converter;

    public ManageVartotojasController(ControllerOperation controllerOperationn, Vartotojas vartotojas)
    {
        windowManager = new WindowManager();
        vartotojasService = new VartotojasService();
        vartotojasModifikacijai = vartotojas;
        controllerOperation = controllerOperationn;
        vartotojoTipasService = new VartotojoTipasService();
        md5Converter = new Md5Converter();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(controllerOperation == ControllerOperation.CREATE)
        {
            buttonAction.setText("Sukurti");

            checkBoxAtnaujintiSlaptazodi.setVisible(false);

            fillRolesTable();
        }
        else if(controllerOperation == ControllerOperation.UPDATE)
        {
            buttonAction.setText("Atnaujinti");

            passwordFieldSlaptazodis.setEditable(false);

            fillRolesTable();
            tableViewRoles.getSelectionModel().select(tableViewRoles.getItems().indexOf(vartotojasModifikacijai.getVartotojoTipas()));
            textAreaApibrezimas.setText(vartotojasModifikacijai.getApibrezimas());
            textFieldPavarde.setText(vartotojasModifikacijai.getPavarde());
            textFieldTelefonas.setText(vartotojasModifikacijai.getTelefonas());
            textFieldVardas.setText(vartotojasModifikacijai.getVardas());
            passwordFieldSlaptazodis.setText(vartotojasModifikacijai.getSlaptazodis());
            textFieldPrisijungimoVardas.setText(vartotojasModifikacijai.getPrisijungimoVardas());
        }
    }

    @FXML
    private CheckBox checkBoxAtnaujintiSlaptazodi;

    @FXML
    private TextField textFieldVardas;

    @FXML
    private TextField textFieldPavarde;

    @FXML
    private TextField textFieldTelefonas;

    @FXML
    private TextArea textAreaApibrezimas;

    @FXML
    private TextField textFieldPrisijungimoVardas;

    @FXML
    private PasswordField passwordFieldSlaptazodis;

    @FXML
    private TableView<VartotojoTipas> tableViewRoles;

    @FXML
    private TableColumn<VartotojoTipas, String> columnRole;

    @FXML
    private Button buttonAction;

    @FXML
    private Button buttonAtgal;

    @FXML
    void action(ActionEvent event) {
        if(controllerOperation == ControllerOperation.CREATE)
        {
            if(vartotojasService.tryCreateVartotojas(
                textFieldVardas.getText(),textFieldPavarde.getText(),
                textFieldTelefonas.getText(),textAreaApibrezimas.getText(),
                textFieldPrisijungimoVardas.getText(), md5Converter.getMD5Hash(passwordFieldSlaptazodis.getText()),
                tableViewRoles.getSelectionModel().getSelectedItem()))
            {
                AllertBox.display("Pavyko","Vartotojas sukurtas");
                windowManager.showTabKonfiguracijaDarbuotojai(event);
            }
        }
        if(controllerOperation == ControllerOperation.UPDATE)
        {
            String password = passwordFieldSlaptazodis.getText();
            if(checkBoxAtnaujintiSlaptazodi.isSelected())
                password = md5Converter.getMD5Hash(passwordFieldSlaptazodis.getText());

            Vartotojas naujasVartotojas = new Vartotojas(textFieldVardas.getText(),textFieldPavarde.getText(),
                    textFieldTelefonas.getText(),textAreaApibrezimas.getText(),
                    textFieldPrisijungimoVardas.getText(),password,
                    tableViewRoles.getSelectionModel().getSelectedItem());
            naujasVartotojas.setId(vartotojasModifikacijai.getId());


            if(vartotojasService.tryUpdateVartotojas(naujasVartotojas, vartotojasModifikacijai))
            {
                AllertBox.display("Pavyko","Vartotojas atnaujintas");
                windowManager.showTabKonfiguracijaDarbuotojai(event);
            }
        }
    }

    @FXML
    void atgal(ActionEvent event) {
        windowManager.showTabKonfiguracijaDarbuotojai(event);
    }

    @FXML
    void atnaujintiSlaptazodi(ActionEvent event) {
        passwordFieldSlaptazodis.setEditable(!passwordFieldSlaptazodis.isEditable());
    }

    public void fillRolesTable()
    {
        ObservableList<VartotojoTipas> vartotojoTipai = FXCollections.observableList(vartotojoTipasService.getAllVartotojoTipas());
        columnRole.setCellValueFactory(new PropertyValueFactory<VartotojoTipas,String>("pavadinimas"));
        tableViewRoles.setItems(vartotojoTipai);
    }

}
