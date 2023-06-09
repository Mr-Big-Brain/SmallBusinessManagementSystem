package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.service.VartotojoTipasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageVartotojasController implements Initializable {
    VartotojasService vartotojasService;
    VartotojoTipasService vartotojoTipasService;
    Vartotojas vartotojasModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManageVartotojasController(ControllerOperation controllerOperationn, Vartotojas vartotojas)
    {
        windowManager = new WindowManager();
        vartotojasService = new VartotojasService();
        vartotojasModifikacijai = vartotojas;
        controllerOperation = controllerOperationn;
        vartotojoTipasService = new VartotojoTipasService();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(controllerOperation == ControllerOperation.CREATE)
        {
            buttonAction.setText("Sukurti");
            fillRolesTable();
        }
        else if(controllerOperation == ControllerOperation.UPDATE)
        {
            buttonAction.setText("Atnaujinti");

            fillRolesTable();
            tableViewRoles.getSelectionModel().select(tableViewRoles.getItems().indexOf(vartotojasModifikacijai.getVartotojoTipas()));
            textFieldApibrezimas.setText(vartotojasModifikacijai.getApibrezimas());
            textFieldPavarde.setText(vartotojasModifikacijai.getPavarde());
            textFieldTelefonas.setText(vartotojasModifikacijai.getTelefonas());
            textFieldVardas.setText(vartotojasModifikacijai.getVardas());
            textFieldSlaptazodis.setText(vartotojasModifikacijai.getSlaptazodis());
            textFieldPrisijungimoVardas.setText(vartotojasModifikacijai.getPrisijungimoVardas());
        }
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
    private TextField textFieldPrisijungimoVardas;

    @FXML
    private TextField textFieldSlaptazodis;

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
                textFieldTelefonas.getText(),textFieldApibrezimas.getText(),
                textFieldPrisijungimoVardas.getText(),textFieldSlaptazodis.getText(),
                tableViewRoles.getSelectionModel().getSelectedItem()))
            {
                AllertBox.display("Pavyko","Vartotojas sukurtas");
                windowManager.showTabKonfiguracijaDarbuotojai(event);
            }
        }
        if(controllerOperation == ControllerOperation.UPDATE)
        {
            Vartotojas naujasVartotojas = new Vartotojas(textFieldVardas.getText(),textFieldPavarde.getText(),
                    textFieldTelefonas.getText(),textFieldApibrezimas.getText(),
                    textFieldPrisijungimoVardas.getText(),textFieldSlaptazodis.getText(),
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
    public void fillRolesTable()
    {
        ObservableList<VartotojoTipas> vartotojoTipai = FXCollections.observableList(vartotojoTipasService.getAllVartotojoTipas());
        columnRole.setCellValueFactory(new PropertyValueFactory<VartotojoTipas,String>("pavadinimas"));
        tableViewRoles.setItems(vartotojoTipai);
    }


}
