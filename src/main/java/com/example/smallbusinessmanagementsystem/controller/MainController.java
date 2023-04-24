package com.example.smallbusinessmanagementsystem.controller;

import com.example.smallbusinessmanagementsystem.controller.Klientai.KlientaiTabController;
import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MainController {
    WindowManager windowManager;
    WindowLoader windowLoader;
    public MainController()
    {
        windowManager = new WindowManager();
        windowLoader = WindowLoader.getInstance();
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

    @FXML
    void onMouseClicked(MouseEvent event) throws IOException {
        System.out.println("clicked " + tabPaneKategorijos.getSelectionModel().getSelectedItem().getId());
        MouseEvent mouseEvent = event;
        ActionEvent actionEvent = new ActionEvent(mouseEvent.getSource(),mouseEvent.getTarget());
        if(tabPaneKategorijos.getSelectionModel().getSelectedItem()==tabKlientai)
        {
            windowLoader.setTabKlientai(true);
            windowManager.showTabKlientai(actionEvent);
            windowLoader.setTabKlientai(false);
        }
        if(tabPaneKategorijos.getSelectionModel().getSelectedItem()==tabFinansai)
        {
            windowLoader.setTabFinansai(true);
            windowManager.showTabFinansai(actionEvent);
            windowLoader.setTabFinansai(false);
        }
        if(tabPaneKategorijos.getSelectionModel().getSelectedItem()==tabPardavimai)
        {
            windowLoader.setTabPardavimai(true);
            windowManager.showTabPardavimai(actionEvent);
            windowLoader.setTabPardavimai(false);
        }
        if(tabPaneKategorijos.getSelectionModel().getSelectedItem()==tabSandelis)
        {
            windowLoader.setTabSandelis(true);
            windowManager.showTabSandelis(actionEvent);
            windowLoader.setTabSandelis(false);
        }
        if(tabPaneKategorijos.getSelectionModel().getSelectedItem()==tabTvarkarastis)
        {
            windowLoader.setTabTvarkarastis(true);
            windowManager.showTabTvarkarastis(actionEvent);
            windowLoader.setTabTvarkarastis(false);
        }
        if(tabPaneKategorijos.getSelectionModel().getSelectedItem()==tabKonfiguracija)
        {
            windowLoader.setTabKonfiguracijaDarbuotojai(true);
            windowManager.showTabKonfiguracijaDarbuotojai(actionEvent);
            windowLoader.setTabKonfiguracijaDarbuotojai(false);
        }
    }

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
