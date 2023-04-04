package com.example.smallbusinessmanagementsystem.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainController {
    public MainController()
    {

    }

    @FXML
    public TabPane tabPaneKategorijos;

    @FXML
    private Tab tabPardavimai;

    @FXML
    private Tab tabSandelis;

    @FXML
    private Tab tabTvarkarastis;

    @FXML
    private Tab tabKlientai;

    @FXML
    private Tab tabKonfiguracija;

    @FXML
    private Tab tabFinansai;

    @FXML
    private Tab tabStatistika;

    public void showTabKlientai()
    {
        tabPaneKategorijos.getSelectionModel().select(tabKlientai);
    }
    public void showTabKonfiguracija()
    {
        tabPaneKategorijos.getSelectionModel().select(tabKonfiguracija);
    }
    public void showTabPardavimai()
    {
        tabPaneKategorijos.getSelectionModel().select(tabPardavimai);
    }
    public void showTabSandelis()
    {
        tabPaneKategorijos.getSelectionModel().select(tabSandelis);
    }
    public void showTabTvarkarastis()
    {
        tabPaneKategorijos.getSelectionModel().select(tabTvarkarastis);
    }
    public void showTabFinansai()
    {
        tabPaneKategorijos.getSelectionModel().select(tabFinansai);
    }
    public void showTabStatistika()
    {
        tabPaneKategorijos.getSelectionModel().select(tabStatistika);
    }

    public TabPane getTabPaneKategorijos() {
        return tabPaneKategorijos;
    }
}
