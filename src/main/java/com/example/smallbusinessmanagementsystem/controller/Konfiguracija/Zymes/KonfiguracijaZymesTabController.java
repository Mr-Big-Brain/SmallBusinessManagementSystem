package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Zymes;

import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class KonfiguracijaZymesTabController {
    WindowManager windowManager;
    public KonfiguracijaZymesTabController()
    {
        windowManager = new WindowManager();
    }
    @FXML
    private TableView<?> tableViewZymes;

    @FXML
    private TableColumn<?, ?> columnZymesID;

    @FXML
    private TableColumn<?, ?> columnZymesPavadinimas;

    @FXML
    private TableColumn<?, ?> columnZymesTipas;

    @FXML
    private ChoiceBox<?> choiceBoxZymiuTipai;

    @FXML
    private Button buttonZymesPrideti;

    @FXML
    private Button buttonZymesPervadinti;

    @FXML
    private Button buttonZymesIstrinti;

    @FXML
    void istrintiZyme(ActionEvent event) {

    }

    @FXML
    void pervadintiZyme(ActionEvent event) {

    }

    @FXML
    void pridetiZyme(ActionEvent event) {
        windowManager.showManageZyme(event, ControllerOperation.CREATE,null);
    }

}
