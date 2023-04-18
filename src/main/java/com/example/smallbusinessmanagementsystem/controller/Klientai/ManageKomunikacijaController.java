package com.example.smallbusinessmanagementsystem.controller.Klientai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.model.Komunikacija;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.service.KomunikacijaService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageKomunikacijaController implements Initializable {
    KomunikacijaService komunikacijaService;
    Komunikacija komunikacijaModifikacijai;
    Klientas klientasModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManageKomunikacijaController(ControllerOperation controllerOperationn, Komunikacija komunikacija)
    {
        windowManager = new WindowManager();
        komunikacijaService = new KomunikacijaService();
        komunikacijaModifikacijai = komunikacija;
        controllerOperation = controllerOperationn;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textFieldProduktas.setEditable(false);
        if(controllerOperation == ControllerOperation.UPDATE)
        {
            buttonAction.setText("Atnaujinti");
            setData(komunikacijaModifikacijai);
        }
        else if(controllerOperation == ControllerOperation.CREATE)
        {
            buttonAction.setText("Sukurti");
            if(komunikacijaModifikacijai!=null)
            {
                setData(komunikacijaModifikacijai);
            }
        }
    }
    @FXML
    private DatePicker datePickerData;

    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private Button buttonAtgal;

    @FXML
    private TextField textFieldProduktas;

    @FXML
    private Button buttonAction;

    @FXML
    private Button buttonPridetiProdukta;

    @FXML
    private TextArea textAreaApibrezimas;

    @FXML
    void action(ActionEvent event) {
        if(controllerOperation==ControllerOperation.UPDATE)
        {
            komunikacijaModifikacijai.setData(datePickerData.getValue());
            komunikacijaModifikacijai.setApibrezimas(textAreaApibrezimas.getText());
            komunikacijaModifikacijai.setPavadinimas(textFieldPavadinimas.getText());

            if(komunikacijaService.tryUpdateKomunikacija(komunikacijaModifikacijai))
            {
                AllertBox.display("Pavyko","Komunikacijos informacija atnaujinta");
                windowManager.showTabKlientai(event);
            }
        }
        else if(controllerOperation==ControllerOperation.CREATE)
        {
            Komunikacija komunikacija = constructKomunikacija();
            if(komunikacijaService.tryCreateKomunikacija(komunikacija))
            {
                AllertBox.display("Pavyko","Komunikacija sukurta");
                windowManager.showTabKlientai(event);
            }
        }
    }

    @FXML
    void atgal(ActionEvent event) {
        windowManager.showTabKlientai(event);
    }

    @FXML
    void pridetiProdukta(ActionEvent event) {
        if(controllerOperation == ControllerOperation.CREATE)
        {
            windowManager.showFindProduktas(event,ControllerOperation.FIND_FOR_KOMUNIKACIJA,constructKomunikacija());
        }
        else if(controllerOperation == ControllerOperation.UPDATE)
        {
            komunikacijaModifikacijai.setPavadinimas(textFieldPavadinimas.getText());
            komunikacijaModifikacijai.setApibrezimas(textAreaApibrezimas.getText());
            komunikacijaModifikacijai.setData(datePickerData.getValue());
            windowManager.showFindProduktas(event,ControllerOperation.FIND_FOR_KOMUNIKACIJA,komunikacijaModifikacijai);
        }
    }
    public void setData(Komunikacija komunikacija)
    {
        if(komunikacijaModifikacijai.getApibrezimas()!=null)
        {
            textAreaApibrezimas.setText(komunikacijaModifikacijai.getApibrezimas());
        }
        if(komunikacijaModifikacijai.getPavadinimas()!=null)
        {
            textFieldPavadinimas.setText(komunikacijaModifikacijai.getPavadinimas());
        }
        if(komunikacijaModifikacijai.getProduktas()!=null)
        {
            textFieldProduktas.setText(komunikacijaModifikacijai.getProduktas().getPavadinimas() + ", " + komunikacijaModifikacijai.getProduktas().getId());
        }
        if(komunikacijaModifikacijai.getData()!=null)
        {
            datePickerData.setValue(komunikacijaModifikacijai.getData());
        }
    }
    private Komunikacija constructKomunikacija()
    {
        return new Komunikacija(textFieldPavadinimas.getText(),textAreaApibrezimas.getText(),
                datePickerData.getValue(),komunikacijaModifikacijai.getProduktas(),
                komunikacijaModifikacijai.getKlientas());
    }
}
