package com.example.smallbusinessmanagementsystem.controller.Statistika;

import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;

public class StatistikaTabController {
    WindowLoader windowLoader;
    WindowManager windowManager;
    public StatistikaTabController()
    {
        windowLoader = WindowLoader.getInstance();
        windowManager = new WindowManager();
    }
    @FXML
    private TabPane tabPaneStatistika;

    @FXML
    private Tab tabProduktai;

    @FXML
    private Tab tabKlientai;

    @FXML
    private Tab tabFinansai;

    @FXML
    private Tab tabZymes;

    @FXML
    void onMouseClicked(MouseEvent event) {
        MouseEvent mouseEvent = event;
        ActionEvent actionEvent = new ActionEvent(mouseEvent.getSource(),mouseEvent.getTarget());
        if(tabPaneStatistika.getSelectionModel().getSelectedItem()==tabProduktai)
        {
            windowLoader.setTabStatistikaProduktai(true);
            windowManager.showTabStatistikaProduktai(actionEvent,null,null,null);
            windowLoader.setTabStatistikaProduktai(false);
        }
        if(tabPaneStatistika.getSelectionModel().getSelectedItem()==tabKlientai)
        {
            windowLoader.setTabStatistikaKlientai(true);
            windowManager.showTabStatistikaKlientai(actionEvent, null, null, null, null);
            windowLoader.setTabStatistikaKlientai(false);
        }
        if(tabPaneStatistika.getSelectionModel().getSelectedItem()==tabFinansai)
        {
            windowLoader.setTabStatistikaFinansai(true);
            windowManager.showTabStatistikaFinansai(actionEvent);
            windowLoader.setTabStatistikaFinansai(false);
        }
        if(tabPaneStatistika.getSelectionModel().getSelectedItem()==tabZymes)
        {
            windowLoader.setTabStatistikaZymes(true);
            windowManager.showTabStatistikaZymes(actionEvent);
            windowLoader.setTabStatistikaZymes(false);
        }
    }
    public void showTabProduktai()
    {
        tabPaneStatistika.getSelectionModel().select(tabProduktai);
    }
    public void showTabKlientai()
    {
        tabPaneStatistika.getSelectionModel().select(tabKlientai);
    }
    public void showTabFinansai()
    {
        tabPaneStatistika.getSelectionModel().select(tabFinansai);
    }
    public void showTabZymes()
    {
        tabPaneStatistika.getSelectionModel().select(tabZymes);
    }
    public TabPane getTabPaneStatistika()
    {
        return tabPaneStatistika;
    }
}
