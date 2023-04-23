package com.example.smallbusinessmanagementsystem.controller.Finansai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Finansas;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.service.FinansasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.CurrentVartotojas;
import com.example.smallbusinessmanagementsystem.utilities.FinansoTipas;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManageFinansasController implements Initializable{
    FinansasService finansasService;
    Finansas finansasModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    CurrentVartotojas currentVartotojas;
    public ManageFinansasController(ControllerOperation controllerOperationn, Finansas finansas)
    {
        windowManager = new WindowManager();
        finansasService = new FinansasService();
        finansasModifikacijai = finansas;
        controllerOperation = controllerOperationn;
        currentVartotojas = CurrentVartotojas.getInstance();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textFieldDarbuotojas.setEditable(false);
        fillChoiceBox(FinansoTipas.ISLAIDOS);
        if(controllerOperation == ControllerOperation.UPDATE)
        {
            buttonAction.setText("Atnaujinti");
        }
        else if(controllerOperation == ControllerOperation.CREATE)
        {
            buttonAction.setText("Sukurti");

        }
        setData(finansasModifikacijai);
        fillTableZymes();
    }
    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private DatePicker datePickerData;

    @FXML
    private TextField textFieldKiekis;

    @FXML
    private TableView<Zyme> tableViewZymes;

    @FXML
    private TableColumn<Zyme, String> columnZyme;

    @FXML
    private TextField textFieldDarbuotojas;

    @FXML
    private ChoiceBox<FinansoTipas> choiceBoxTipas;

    @FXML
    private TextArea textAreaApibudinimas;

    @FXML
    private Button buttonAtgal;

    @FXML
    private Button buttonAction;

    @FXML
    private Button buttonPridetiZyme;

    @FXML
    private Button buttonIstrintiZyme;

    @FXML
    void action(ActionEvent event) {
        if(controllerOperation==ControllerOperation.UPDATE)
        {
            if(validateKiekisFormat(textFieldKiekis.getText())) {
                constructFinansas();
                if (finansasService.tryUpdateFinansas(finansasModifikacijai)) {
                    AllertBox.display("Pavyko", "Finansas atnaujintas");
                    windowManager.showTabFinansai(event);
                }
            }
        }
        else if(controllerOperation==ControllerOperation.CREATE)
        {
            if(validateKiekisFormat(textFieldKiekis.getText()))
            {
                constructFinansas();
                if(finansasService.tryCreateFinansas(finansasModifikacijai))
                {
                    AllertBox.display("Pavyko","Finansas sukurtas");
                    windowManager.showTabFinansai(event);
                }
            }

        }
    }

    @FXML
    void atgal(ActionEvent event) {
        windowManager.showTabFinansai(event);
    }

    @FXML
    void istrinti(ActionEvent event) {
        if(finansasModifikacijai.getZymes()!=null)
        {
            for(int i = 0; i<finansasModifikacijai.getZymes().size();i++)
            {
                if(tableViewZymes.getSelectionModel().getSelectedItem().getId() == finansasModifikacijai.getZymes().get(i).getId())
                {
                    finansasModifikacijai.getZymes().remove(i);
                    break;
                }
            }
            fillTableZymes();
        }
    }

    @FXML
    void prideti(ActionEvent event) {
        constructFinansas();
        windowManager.showFindZyme(event,ControllerOperation.FIND_FOR_FINANSAS,finansasModifikacijai);
    }
    public void setData(Finansas finansas)
    {
            if(finansas.getData()!=null)
            {
                datePickerData.setValue(finansas.getData());
            }
            if(finansas.getPavadinimas()!=null && !finansas.getPavadinimas().isEmpty())
            {
                textFieldPavadinimas.setText(finansas.getPavadinimas());
            }
            if(finansas.getApibudinimas()!=null && !finansas.getApibudinimas().isEmpty())
            {
                textAreaApibudinimas.setText(finansas.getApibudinimas());
            }
            if(finansas.getKiekis()!=0)
            {
                textFieldKiekis.setText(String.valueOf(finansas.getKiekis()));
            }
            if(finansas.getTipas()!=null)
            {
                choiceBoxTipas.setValue(finansas.getTipas());
            }
            if(finansas.getVartotojas()!=null)
            {
                textFieldDarbuotojas.setText(finansas.getVartotojas().getVardas() + " " + finansas.getVartotojas().getPavarde());
            }
            if(finansas.getZymes()!=null)
            {
                fillTableZymes();
            }
    }
    public void constructFinansas()
    {
        finansasModifikacijai.setData(datePickerData.getValue());
        finansasModifikacijai.setPavadinimas(textFieldPavadinimas.getText());
        finansasModifikacijai.setApibudinimas(textAreaApibudinimas.getText());
        finansasModifikacijai.setKiekis(Double.parseDouble(textFieldKiekis.getText()));
        finansasModifikacijai.setTipas(choiceBoxTipas.getValue());
        if(finansasModifikacijai.getVartotojas()==null)
        {
            finansasModifikacijai.setVartotojas(currentVartotojas.getVartotojas());
        }
        finansasModifikacijai.setZymes(tableViewZymes.getItems());
    }
    private void fillTableZymes()
    {
        if(finansasModifikacijai.getZymes()!=null)
        {
            ObservableList<Zyme> zymes = FXCollections.observableList(finansasModifikacijai.getZymes());
            columnZyme.setCellValueFactory(new PropertyValueFactory<Zyme,String>("pavadinimas"));
            tableViewZymes.setItems(zymes);
        }
        else
        {
            tableViewZymes.getItems().clear();
        }
    }
    private boolean validateKiekisFormat(String kiekis)
    {
        if(Objects.equals(kiekis, "")||kiekis == null)
        {
            AllertBox.display("Klaida","Nenurodytas kiekis");
            return false;
        }
        try {
            double value = Double.parseDouble(kiekis);
            return true;
        } catch (NumberFormatException e) {
            AllertBox.display("Klaida","Blogas pinigų formatas");
            return false;
        }
    }
    private void fillChoiceBox(FinansoTipas finansoTipas)
    {
        choiceBoxTipas.getItems().clear();
        choiceBoxTipas.getItems().addAll(FinansoTipas.ISLAIDOS,FinansoTipas.PAJAMOS);
        choiceBoxTipas.setValue(finansoTipas);
    }
}

