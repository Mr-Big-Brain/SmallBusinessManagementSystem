package com.example.smallbusinessmanagementsystem.controller.Pardavimai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.*;
import com.example.smallbusinessmanagementsystem.service.PardavimasService;
import com.example.smallbusinessmanagementsystem.service.PardavimoLinijaService;
import com.example.smallbusinessmanagementsystem.service.ProduktasService;
import com.example.smallbusinessmanagementsystem.service.SandelioPrekeService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.CurrentVartotojas;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ManagePardavimasController implements Initializable {
    PardavimasService pardavimasService;
    PardavimoLinijaService pardavimoLinijaService;
    Pardavimas pardavimasModifikacijai;
    List<PardavimoLinija> pardavimoLinijosModifikacijai;
    List<PardavimoLinija> pardavimoLinijosTrinimui;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    CurrentVartotojas currentVartotojas;
    ProduktasService produktasService;
    SandelioPrekeService sandelioPrekeService;
    public ManagePardavimasController(ControllerOperation controllerOperationn, Pardavimas pardavimas, List<PardavimoLinija> pardavimoLinijos)
    {
        windowManager = new WindowManager();
        pardavimasService = new PardavimasService();
        pardavimasModifikacijai = pardavimas;
        pardavimoLinijosModifikacijai = pardavimoLinijos;
        controllerOperation = controllerOperationn;
        currentVartotojas = CurrentVartotojas.getInstance();
        produktasService = new ProduktasService();
        sandelioPrekeService = new SandelioPrekeService();
        pardavimoLinijaService = new PardavimoLinijaService();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textFieldDarbuotojas.setEditable(false);
        textFieldPirkejas.setEditable(false);

        if(pardavimasModifikacijai==null)
        {
            pardavimasModifikacijai = new Pardavimas();
            pardavimasModifikacijai.setPardavejas(currentVartotojas.getVartotojas());
            pardavimasModifikacijai.setData(LocalDateTime.now());
        }
        if(pardavimoLinijosModifikacijai==null)
        {
            pardavimoLinijosModifikacijai = new ArrayList<>();
        }
        buttonAction.setText("Apdoroti");

        setData(pardavimasModifikacijai);
        fillTable();
    }
    @FXML
    private TableView<PardavimoLinija> tableViewPardavimoLinijos;

    @FXML
    private TableColumn<PardavimoLinija, String> columnProduktas;

    @FXML
    private TableColumn<PardavimoLinija, Integer> columnKiekis;

    @FXML
    private TableColumn<PardavimoLinija, Double> columnKainaVieneto;

    @FXML
    private TextField textFieldPirkejas;

    @FXML
    private Button buttonPridetiPirkeja;

    @FXML
    private TextField textFieldDarbuotojas;

    @FXML
    private Button buttonPridetiPardavimoLinija;

    @FXML
    private Button buttonPakeistiPardavimoLinija;

    @FXML
    private Button buttonIstrintiPardavimoLinija;

    @FXML
    private Button buttonAtgal;

    @FXML
    private Button buttonAction;

    @FXML
    private DatePicker datePickerData;

    @FXML
    private TextField textFieldLaikas;

    @FXML
    void action(ActionEvent event) {
        if(tryConstructEverything())
        {
            if(validateEverything())
            {
                modifyPardavimasIrLinijos();
                AllertBox.display("Pavyko","Pardavimas modifikuotas");
                windowManager.showTabPardavimai(event);
            }
        }
    }

    @FXML
    void atgal(ActionEvent event) {
        windowManager.showTabPardavimai(event);
    }

    @FXML
    void istrintiPardavimoLinija(ActionEvent event) {
        if(pardavimoLinijosTrinimui==null)
        {
            pardavimoLinijosTrinimui = new ArrayList<>();
        }
        if(tableViewPardavimoLinijos.getSelectionModel().getSelectedItem().getId()!=0)
        {
            pardavimoLinijosTrinimui.add(tableViewPardavimoLinijos.getSelectionModel().getSelectedItem());
        }
        tableViewPardavimoLinijos.getItems().remove(tableViewPardavimoLinijos.getSelectionModel().getSelectedItem());
        tableViewPardavimoLinijos.refresh();
    }

    @FXML
    void pakeistiPardavimoLinija(ActionEvent event) {
        windowManager.showManagePardavimoLinija(event,ControllerOperation.UPDATE,pardavimasModifikacijai,pardavimoLinijosModifikacijai,tableViewPardavimoLinijos.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void pridetiPardavimoLinija(ActionEvent event) {
        if(tryConstructEverything())
        {
            windowManager.showManagePardavimoLinija(event,controllerOperation,pardavimasModifikacijai,pardavimoLinijosModifikacijai,-1);
        }
    }

    @FXML
    void pridetiPirkeja(ActionEvent event) {
        if(tryConstructEverything())
        {
            windowManager.showFindKlientas(event,ControllerOperation.FIND_FOR_PARDAVIMAS, pardavimasModifikacijai, pardavimoLinijosModifikacijai);
        }
    }
    public void setData(Pardavimas pardavimas)
    {
        Vartotojas vartotojas = currentVartotojas.getVartotojas();
        textFieldLaikas.setText(constructStringFromLocalTime(pardavimas.getData().toLocalTime()));
        datePickerData.setValue(pardavimasModifikacijai.getData().toLocalDate());
        textFieldDarbuotojas.setText(vartotojas.getVardas() + " " + vartotojas.getPavarde());
        Klientas tempKlientas = pardavimasModifikacijai.getKlientas();
        if(tempKlientas!=null)
        {
            textFieldPirkejas.setText(tempKlientas.getId() + " " + tempKlientas.getPastas());
        }
    }
    private boolean tryConstructDateTime()
    {
        LocalTime tempTime;
        if(Objects.equals(datePickerData.getValue(), null))
        {
            AllertBox.display("Klaida","Nenurodyta data");
            return false;
        }
        if(Objects.equals(textFieldLaikas.getText(), null) || Objects.equals(textFieldLaikas.getText(), ""))
        {
            AllertBox.display("Klaida","Nenurodytas laikas");
            return false;
        }
        try {
            tempTime = LocalTime.parse(textFieldLaikas.getText());
            pardavimasModifikacijai.setData(LocalDateTime.of(datePickerData.getValue(),tempTime));
            return true;
        } catch (Exception e) {
            AllertBox.display("Klaida","Blogas laiko formatas");
            return false;
        }
    }
    private boolean validateDateAndTime()
    {
        if(pardavimasModifikacijai.getData().isAfter(LocalDateTime.now()))
        {
            AllertBox.display("Klaida", "Įvesti data ir laikas ateityje");
            return false;
        }
        return true;
    }
    private String constructStringFromLocalTime(LocalTime time)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);
    }
    private boolean tryConstructPardavimoLinijos()
    {
        if(!tableViewPardavimoLinijos.getItems().isEmpty())
        {
            pardavimoLinijosModifikacijai = null;
            pardavimoLinijosModifikacijai = tableViewPardavimoLinijos.getItems();
        }
        else
        {
            pardavimoLinijosModifikacijai = null;
        }
        return true;
    }
    private boolean tryConstructEverything()
    {
        if(tryConstructDateTime() && tryConstructPardavimoLinijos())
        {
            return true;
        }
        return false;
    }
    private void fillTable()
    {
        ObservableList<PardavimoLinija> pardavimoLinijos = FXCollections.observableList(pardavimoLinijosModifikacijai);
        columnKainaVieneto.setCellValueFactory(new PropertyValueFactory<PardavimoLinija,Double>("kainaUzViena"));
        columnKiekis.setCellValueFactory(new PropertyValueFactory<PardavimoLinija,Integer>("kiekis"));
        columnProduktas.setCellValueFactory(new PropertyValueFactory<PardavimoLinija,String>("produktas"));
        columnProduktas.setCellValueFactory(cellData -> {
            if(cellData.getValue().getProduktas()!=null)
            {
                int produktoId = cellData.getValue().getProduktas().getId();
                Produktas produktasTemp = produktasService.getProduktasById(produktoId);
                String produktoPavadinimas = (produktasTemp != null) ? produktasTemp.getId() + ", " + produktasTemp.getPavadinimas() : "";
                return new SimpleStringProperty(produktoPavadinimas);
            }
            else return new SimpleStringProperty("");
        });
        tableViewPardavimoLinijos.setItems(pardavimoLinijos);
    }
    private boolean validateEverything()
    {
        if(validateDateAndTime()&&validatePardavimoLinijos())
        {
            return true;
        }
        return false;
    }
    private boolean validatePardavimoLinijos()
    {
        return pardavimoLinijosNeTuscios() && pardavimoLinijoseNeraDublikatu() && pardavimoLinijuProduktaiYraSandelyje();
    }
    private boolean pardavimoLinijosNeTuscios()
    {
        if(pardavimoLinijosModifikacijai == null || pardavimoLinijosModifikacijai.isEmpty())
        {
            AllertBox.display("Klaida","Nėra nei vienos pardavimo linijos");
            return false;
        }
        return true;
    }
    private boolean pardavimoLinijoseNeraDublikatu()
    {
        for(int i=0;i<pardavimoLinijosModifikacijai.size();i++)
        {
            for(int j=i;j<pardavimoLinijosModifikacijai.size();j++)
            {
                if(i!=j && pardavimoLinijosModifikacijai.get(i).getProduktas().getId() == pardavimoLinijosModifikacijai.get(j).getProduktas().getId())
                {
                    AllertBox.display("Klaida", "Pardavimo linijose yra vienodų produktų");
                    return false;
                }
            }
        }
        return true;
    }
    private boolean pardavimoLinijuProduktaiYraSandelyje()
    {
        for(int i=0;i<pardavimoLinijosModifikacijai.size();i++)
        {
            if(!sandelioPrekeService.canBeDecreased(pardavimoLinijosModifikacijai.get(i).getProduktas(),
                    pardavimoLinijosModifikacijai.get(i).getKiekis()-findDeletedKiekis(pardavimoLinijosModifikacijai.get(i).getProduktas())))
            {
                AllertBox.display("Klaida", "Tiek " + pardavimoLinijosModifikacijai.get(i).getProduktas().getPavadinimas() + " produkto sandelyje nėra");
                return false;
            }
        }
        return true;
    }
    private Integer findDeletedKiekis(Produktas produktas)
    {
        if(pardavimoLinijosTrinimui != null && !pardavimoLinijosTrinimui.isEmpty())
        {
            for(int i=0;i<pardavimoLinijosTrinimui.size();i++)
            {
                if(pardavimoLinijosTrinimui.get(i).getProduktas().getId() == produktas.getId())
                {
                    return pardavimoLinijosTrinimui.get(i).getKiekis();
                }
            }
            return 0;
        }
        return 0;
    }
    private void modifyPardavimasIrLinijos()
    {
        if(pardavimasModifikacijai.getId()!=0)
        {
            pardavimoLinijaService.deleteAllPardavimoPardavimoLinijas(pardavimasModifikacijai);
            pardavimasService.tryUpdatePardavimas(pardavimasModifikacijai);
        }
        else
        {
            pardavimasService.tryCreatePardavimas(pardavimasModifikacijai);
        }

        Pardavimas newestPardavimas = pardavimasService.getNewestUserPardavimas(currentVartotojas.getVartotojas());
        for(int i=0;i<pardavimoLinijosModifikacijai.size();i++)
        {
            pardavimoLinijosModifikacijai.get(i).setPardavimas(newestPardavimas);
            pardavimoLinijaService.tryCreatePardavimoLinija(pardavimoLinijosModifikacijai.get(i));
        }


    }
}
