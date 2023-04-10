package com.example.smallbusinessmanagementsystem.controller.Klientai;

import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class KlientaiTabController {
    WindowManager windowManager;
    KlientaiTabController()
    {
        windowManager = new WindowManager();
    }
    @FXML
    private TableView<?> tableViewKlientai;

    @FXML
    private TableColumn<?, ?> columnKlientaiID;

    @FXML
    private TableColumn<?, ?> columnKlientaiVardas;

    @FXML
    private TableColumn<?, ?> columnKlientaiPavarde;

    @FXML
    private TableColumn<?, ?> columnKlientaiImone;

    @FXML
    private TableColumn<?, ?> columnKlientaiTelefonas;

    @FXML
    private TableColumn<?, ?> columnKlientaiPastas;

    @FXML
    private Button buttonKlientaiPrideti;

    @FXML
    private Button buttonKlientaiRedaguoti;

    @FXML
    private Button buttonKlientaiIstrinti;

    @FXML
    private TableView<?> tableViewKomunikacijos;

    @FXML
    private TableColumn<?, ?> columnKomunikacijosID;

    @FXML
    private TableColumn<?, ?> columnKomunikacijosPavadinimas;

    @FXML
    private TableColumn<?, ?> columnKomunikacijosApibrezimas;

    @FXML
    private TableColumn<?, ?> columnKomunikacijosProduktas;

    @FXML
    private TableColumn<?, ?> columnKomunikacijosData;

    @FXML
    private Button buttonKomunikacijosPrideti;

    @FXML
    private Button buttonKomunikacijosRedaguoti;

    @FXML
    private Button buttonKomunikacijosIstrinti;

    @FXML
    void istrintiKlienta(ActionEvent event) {

    }

    @FXML
    void istrintiKomunikacija(ActionEvent event) {

    }

    @FXML
    void pridetiKlienta(ActionEvent event) {

    }

    @FXML
    void pridetiKomunikacija(ActionEvent event) {

    }

    @FXML
    void redaguotiKlienta(ActionEvent event) {

    }

    @FXML
    void redaguotiKomunikacija(ActionEvent event) {

    }
}
