package com.example.smallbusinessmanagementsystem.controller;

import com.example.smallbusinessmanagementsystem.controller.Klientai.KlientaiTabController;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.utilities.CurrentVartotojas;
import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    WindowManager windowManager;
    WindowLoader windowLoader;
    CurrentVartotojas currentVartotojas;
    public MainController()
    {
        windowManager = new WindowManager();
        windowLoader = WindowLoader.getInstance();
        currentVartotojas = CurrentVartotojas.getInstance();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hideTabs();
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
        if(tabPaneKategorijos.getSelectionModel().getSelectedItem()==tabStatistika)
        {
            windowLoader.setTabStatistikaProduktai(true);
            windowManager.showTabStatistikaProduktai(actionEvent, null, null, null);
            windowLoader.setTabStatistikaProduktai(false);
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

    private void hideTabs() {
        VartotojoTipas vartotojoTipas;
        vartotojoTipas = currentVartotojas.getVartotojas().getVartotojoTipas();
        if(!vartotojoTipas.getFinansai())
        {
            tabPaneKategorijos.getTabs().remove(tabFinansai);
        }
        if(!vartotojoTipas.getKlientai())
        {
            tabPaneKategorijos.getTabs().remove(tabKlientai);
        }
        if(!vartotojoTipas.getStatistika())
        {
            tabPaneKategorijos.getTabs().remove(tabStatistika);
        }
        if(!vartotojoTipas.getSandelis())
        {
            tabPaneKategorijos.getTabs().remove(tabSandelis);
        }
        if(!vartotojoTipas.getKonfiguracija())
        {
            tabPaneKategorijos.getTabs().remove(tabKonfiguracija);
        }
        if(!vartotojoTipas.getPardavimai())
        {
            tabPaneKategorijos.getTabs().remove(tabPardavimai);
        }
    }
}
