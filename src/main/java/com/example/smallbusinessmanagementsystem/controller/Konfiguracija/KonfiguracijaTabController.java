package com.example.smallbusinessmanagementsystem.controller.Konfiguracija;

import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;

public class KonfiguracijaTabController {
    WindowLoader windowLoader;
    WindowManager windowManager;
    public KonfiguracijaTabController()
    {
        windowLoader = WindowLoader.getInstance();
        windowManager = new WindowManager();
    }
    @FXML
    private TabPane tabPaneKonfiguracija;

    @FXML
    private Tab tabDarbuotojai;

    @FXML
    private Tab tabProduktai;

    @FXML
    private Tab tabZymes;


    @FXML
    void onMouseClicked(MouseEvent event) {
        System.out.println("clicked " + tabPaneKonfiguracija.getSelectionModel().getSelectedItem().getId());
        MouseEvent mouseEvent = event;
        ActionEvent actionEvent = new ActionEvent(mouseEvent.getSource(),mouseEvent.getTarget());
        if(tabPaneKonfiguracija.getSelectionModel().getSelectedItem()==tabDarbuotojai)
        {
            windowLoader.setTabKonfiguracijaDarbuotojai(true);
            windowManager.showTabKonfiguracijaDarbuotojai(actionEvent);
            windowLoader.setTabKonfiguracijaDarbuotojai(false);
        }
        if(tabPaneKonfiguracija.getSelectionModel().getSelectedItem()==tabProduktai)
        {
            windowLoader.setTabKonfiguracijaProduktai(true);
            windowManager.showTabKonfiguracijaProduktai(actionEvent);
            windowLoader.setTabKonfiguracijaProduktai(false);
        }
        if(tabPaneKonfiguracija.getSelectionModel().getSelectedItem()==tabZymes)
        {
            windowLoader.setTabKonfiguracijaZymes(true);
            windowManager.showTabKonfiguracijaZymes(actionEvent);
            windowLoader.setTabKonfiguracijaZymes(false);
        }
    }
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
