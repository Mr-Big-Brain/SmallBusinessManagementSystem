package com.example.smallbusinessmanagementsystem.controller.Sandelis;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.model.SandelioPreke;
import com.example.smallbusinessmanagementsystem.service.ProduktasService;
import com.example.smallbusinessmanagementsystem.service.SandelioPrekeService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SandelisTabController implements Initializable {
    WindowManager windowManager;
    SandelioPrekeService sandelioPrekeService;
    ProduktasService produktasService;
    public SandelisTabController()
    {
        windowManager = new WindowManager();
        sandelioPrekeService = new SandelioPrekeService();
        produktasService = new ProduktasService();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillTableProduktai(null);
    }
    @FXML
    private Button buttonPridetiProdukta;

    @FXML
    private Button buttonIstrintiProdukta;

    @FXML
    private Button buttonRastiProdukta;

    @FXML
    private TableView<SandelioPreke> tableViewProduktai;

    @FXML
    private TableColumn<SandelioPreke, String> columnSandelisProduktas;

    @FXML
    private TableColumn<SandelioPreke, Integer> columnSandelisKiekis;

    @FXML
    private Button buttonNurasytiProdukta;

    @FXML
    void istrintiProdukta(ActionEvent event) {
        if(tableViewProduktai.getSelectionModel().getSelectedItem().getKiekis() == 0)
        {
            if(sandelioPrekeService.tryDeleteSandelioPreke(tableViewProduktai.getSelectionModel().getSelectedItem()))
            {
                AllertBox.display("Pavyko", "Produktas ištrintas iš sandėlio");
            }
            fillTableProduktai(null);
        }
        else
        {
            AllertBox.display("Klaida", "Sandelyje dar liko prekių");
        }
    }

    @FXML
    void nurasytiProdukta(ActionEvent event) {
        if(tableViewProduktai.getSelectionModel().getSelectedItem() == null)
        {
            windowManager.showManageSandelioPreke(event,ControllerOperation.DECREASE,null);
        }
        else
        {
            windowManager.showManageSandelioPreke(event,ControllerOperation.DECREASE,tableViewProduktai.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void pridetiProdukta(ActionEvent event) {
        if(tableViewProduktai.getSelectionModel().getSelectedItem() == null)
        {
            windowManager.showManageSandelioPreke(event,ControllerOperation.INCREASE,null);
        }
        else
        {
            windowManager.showManageSandelioPreke(event,ControllerOperation.INCREASE,tableViewProduktai.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void rastiProdukta(ActionEvent event) {
        windowManager.showFindProduktas(event,ControllerOperation.FIND_FOR_SANDELIS,null);
    }
    private void fillTableProduktai(Produktas produktas)
    {
        ObservableList<SandelioPreke> sandelioPrekes = FXCollections.observableList(sandelioPrekeService.getAllSandelioPrekes());
        columnSandelisKiekis.setCellValueFactory(new PropertyValueFactory<SandelioPreke,Integer>("kiekis"));
        columnSandelisProduktas.setCellValueFactory(new PropertyValueFactory<SandelioPreke,String>("produktas"));
        columnSandelisProduktas.setCellValueFactory(cellData -> {
            if(cellData.getValue().getProduktas()!=null)
            {
                int produktoId = cellData.getValue().getProduktas().getId();
                Produktas produktasTemp = produktasService.getProduktasById(produktoId);
                String produktoPavadinimas = (produktasTemp != null) ? produktasTemp.getId() + ", " + produktasTemp.getPavadinimas() : "";
                return new SimpleStringProperty(produktoPavadinimas);
            }
            else return new SimpleStringProperty("");
        });
        tableViewProduktai.setItems(sandelioPrekes);
    }

}
