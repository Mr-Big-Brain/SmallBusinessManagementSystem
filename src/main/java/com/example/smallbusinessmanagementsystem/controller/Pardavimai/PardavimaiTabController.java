package com.example.smallbusinessmanagementsystem.controller.Pardavimai;

import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PardavimaiTabController {
    WindowManager windowManager;
    public PardavimaiTabController()
    {
        windowManager = new WindowManager();
    }
    @FXML
    private Button buttonNaujasPardavimas;

    @FXML
    private Button buttonRedaguotiPardavima;

    @FXML
    private Button buttonIstrintiPardavima;

    @FXML
    private Button buttonRastiPardavima;

    @FXML
    private TableView<?> tableVIewPardavimai;

    @FXML
    private TableColumn<?, ?> columnPardavimaiID;

    @FXML
    private TableColumn<?, ?> columnPardavimaiData;

    @FXML
    private TableColumn<?, ?> columnPardavimaiSuma;

    @FXML
    private TableColumn<?, ?> columnPardavimaiDarbuotojas;

    @FXML
    private TableColumn<?, ?> columnPardavimaiPirkejas;

    @FXML
    private DatePicker datePickerNuo;

    @FXML
    private DatePicker datePickerIki;

    @FXML
    void istrintiPardavima(ActionEvent event) {

    }

    @FXML
    void naujasPardavimas(ActionEvent event) {
        windowManager.showManagePardavimas(event, ControllerOperation.CREATE,null);
    }

    @FXML
    void rastiPardavima(ActionEvent event) {

    }

    @FXML
    void redaguotiPardavima(ActionEvent event) {

    }

}
