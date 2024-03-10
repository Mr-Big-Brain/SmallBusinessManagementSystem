package com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Produktai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.service.ProduktasService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManageProduktasController implements Initializable {
    ProduktasService produktasService;
    Produktas produktasModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManageProduktasController(ControllerOperation controllerOperationn, Produktas produktas)
    {
        windowManager = new WindowManager();
        produktasService = new ProduktasService();
        produktasModifikacijai = produktas;
        controllerOperation = controllerOperationn;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(controllerOperation == ControllerOperation.CREATE)
        {
            buttonAction.setText("Sukurti");
        }
        else if(controllerOperation == ControllerOperation.UPDATE)
        {
            buttonAction.setText("Atnaujinti");

            textFieldPavadinimas.setText(produktasModifikacijai.getPavadinimas());
            textAreaApibrezimas.setText(produktasModifikacijai.getApibrezimas());
            textFieldRekomenduojamaKaina.setText(String.valueOf(produktasModifikacijai.getRekomenduojamaKaina()));
        }
    }
    @FXML
    private TextField textFieldPavadinimas;

    @FXML
    private TextField textFieldRekomenduojamaKaina;

    @FXML
    private TextArea textAreaApibrezimas;

    @FXML
    private Button buttonAtgal;

    @FXML
    private Button buttonAction;

    @FXML
    void action(ActionEvent event) {
        if(validateKainos()) {
            if (controllerOperation == ControllerOperation.CREATE) {
                if (produktasService.tryCreateProduktas(
                        textFieldPavadinimas.getText(), textAreaApibrezimas.getText(), Double.parseDouble(textFieldRekomenduojamaKaina.getText())))
                {
                    AllertBox.display("Pavyko", "Produktas sukurtas");
                    windowManager.showTabKonfiguracijaProduktai(event);
                }
            }
            if (controllerOperation == ControllerOperation.UPDATE) {
                Produktas naujasProduktas = new Produktas(
                        textFieldPavadinimas.getText(), textAreaApibrezimas.getText(), Double.parseDouble(textFieldRekomenduojamaKaina.getText()));

                naujasProduktas.setId(produktasModifikacijai.getId());

                if (produktasService.tryUpdateProduktas(naujasProduktas, produktasModifikacijai)) {
                    AllertBox.display("Pavyko", "Produktas atnaujintas");
                    windowManager.showTabKonfiguracijaProduktai(event);
                }
            }
        }
    }

    @FXML
    void atgal(ActionEvent event) {
        windowManager.showTabKonfiguracijaProduktai(event);
    }

    private boolean validateKainos()
    {
        if(Objects.equals(textFieldRekomenduojamaKaina.getText(),""))
        {
            AllertBox.display("Klaida","Negalima palikti tuščių kainų");
            return false;
        }
        try {
            double value = Double.parseDouble(textFieldRekomenduojamaKaina.getText());
            return true;
        } catch (NumberFormatException e) {
            AllertBox.display("Klaida","Blogas kainos formatas");
            return false;
        }
    }
}