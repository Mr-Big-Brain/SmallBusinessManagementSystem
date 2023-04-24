package com.example.smallbusinessmanagementsystem.controller.Pardavimai;

import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class PardavimaiTabController implements Initializable {
    WindowManager windowManager;
    WindowLoader windowLoader;
    public PardavimaiTabController()
    {
        windowLoader = WindowLoader.getInstance();
        if(windowLoader.isTabPardavimai())
        {
            windowManager = new WindowManager();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(windowLoader.isTabPardavimai())
        {

        }
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
