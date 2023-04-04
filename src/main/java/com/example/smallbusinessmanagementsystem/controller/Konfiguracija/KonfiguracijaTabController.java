package com.example.smallbusinessmanagementsystem.controller.Konfiguracija;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class KonfiguracijaTabController {
    @FXML
    private TabPane tabPaneKonfiguracija;

    @FXML
    private Tab tabDarbuotojai;

    @FXML
    private Tab tabProduktai;

    @FXML
    private Tab tabZymes;

    public void showTabDarbuotojai()
    {
        tabPaneKonfiguracija.getSelectionModel().select(tabDarbuotojai);
    }
    public void showTabProduktai()
    {
        tabPaneKonfiguracija.getSelectionModel().select(tabProduktai);
    }
    public void showTabZymes()
    {
        tabPaneKonfiguracija.getSelectionModel().select(tabZymes);
    }
}
