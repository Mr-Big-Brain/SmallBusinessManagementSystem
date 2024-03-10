package com.example.smallbusinessmanagementsystem.controller.Sandelis;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.SandelioPreke;
import com.example.smallbusinessmanagementsystem.service.SandelioPrekeService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManageSandelioPrekeController implements Initializable{
    SandelioPrekeService sandelioPrekeService;
    SandelioPreke sandelioPrekeModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    public ManageSandelioPrekeController(ControllerOperation controllerOperationn, SandelioPreke sandelioPreke)
    {
        windowManager = new WindowManager();
        sandelioPrekeService = new SandelioPrekeService();
        sandelioPrekeModifikacijai = sandelioPreke;
        controllerOperation = controllerOperationn;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        textFieldProduktas.setEditable(false);
        fillTextFieldProduktas();
        fillTextFieldPirkimoKaina();

        if(sandelioPrekeModifikacijai!=null)
        {
            buttonPasirinktiProdukta.setVisible(false);
        }
        if(controllerOperation == ControllerOperation.INCREASE)
        {
            buttonAction.setText("Pridėti");
        }
        else if(controllerOperation == ControllerOperation.DECREASE)
        {
            buttonAction.setText("Nurašyti");
        }
    }
    @FXML
    private TextField textFieldProduktas;

    @FXML
    private Button buttonPasirinktiProdukta;

    @FXML
    private TextField textFieldKiekis;

    @FXML
    private TextField textFieldPirkimoKaina;

    @FXML
    private Button buttonAtgal;

    @FXML
    private Button buttonAction;

    @FXML
    void action(ActionEvent event) {
        if(controllerOperation == ControllerOperation.INCREASE)
        {
            if(sandelioPrekeModifikacijai!=null && validateIntegerKiekis())
            {
                if(validateEmptyKiekis())
                {
                    if(sandelioPrekeService.tryIncreaseSandelioPreke(sandelioPrekeModifikacijai.getProduktas(),getIntegerFromKiekis(), getDoubleFromPirkimoKaina()))
                    {
                        AllertBox.display("Pavyko","Prekės pridėtos");
                        windowManager.showTabSandelis(event);
                    }
                }
            }
            else
            {
                if(validateEmptyKiekis() && validateIntegerKiekis() && validateEmptyProduktas())
                {
                    sandelioPrekeModifikacijai.setKiekis(Integer.parseInt(textFieldKiekis.getText()));
                    if(sandelioPrekeService.tryCreateSandelioPreke(sandelioPrekeModifikacijai))
                    {
                        AllertBox.display("Pavyko","Prekė dabar yra sandėlyje");
                    }
                }
            }
        }
        else if(controllerOperation == ControllerOperation.DECREASE)
        {
            if(sandelioPrekeModifikacijai!=null && validateIntegerKiekis())
            {
                if(sandelioPrekeService.tryDecreaseSandelioPreke(sandelioPrekeModifikacijai.getProduktas(),getIntegerFromKiekis(),getDoubleFromPirkimoKaina()))
                {
                    AllertBox.display("Pavyko","Prekės nurašytos");
                    windowManager.showTabSandelis(event);
                }
                else
                {
                    AllertBox.display("Klaida","Norėjote nurašyti daugiau prekių, negu yra sandėlyje");
                }
            }
            else
            {
                AllertBox.display("Klaida","Klaida");
            }
        }
    }

    @FXML
    void atgal(ActionEvent event) {
        windowManager.showTabSandelis(event);
    }

    @FXML
    void pasirinktiProdukta(ActionEvent event) {
        if(controllerOperation == ControllerOperation.INCREASE)
        {
            if(sandelioPrekeModifikacijai==null)
            {
                sandelioPrekeModifikacijai = new SandelioPreke();
            }
            windowManager.showFindProduktas(event,ControllerOperation.INCREASE,sandelioPrekeModifikacijai);
        }
        if(controllerOperation == ControllerOperation.DECREASE)
        {
            windowManager.showFindProduktas(event,ControllerOperation.DECREASE,sandelioPrekeModifikacijai);
        }

    }
    private void fillTextFieldProduktas()
    {
        if(sandelioPrekeModifikacijai!=null && sandelioPrekeModifikacijai.getProduktas()!=null)
        {
            textFieldProduktas.setText(sandelioPrekeModifikacijai.getProduktas().getId() + ", " + sandelioPrekeModifikacijai.getProduktas().getPavadinimas());
        }
    }
    private void fillTextFieldPirkimoKaina()
    {
        if(sandelioPrekeModifikacijai!=null && sandelioPrekeModifikacijai.getProduktas()!=null)
        {
            textFieldPirkimoKaina.setText(String.valueOf(sandelioPrekeModifikacijai.getPirkimoKaina()));
        }
    }
    private boolean validateEmptyKiekis()
    {
        if(Objects.equals(textFieldKiekis.getText(), ""))
        {
            AllertBox.display("Klaida","Nenurodytas kiekis");
            return false;
        }
        return true;
    }
    private boolean validateIntegerKiekis()
    {
        try {
            Integer.parseInt(textFieldKiekis.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private boolean validateEmptyProduktas()
    {
        if(sandelioPrekeModifikacijai.getProduktas()==null)
        {
            AllertBox.display("Klaida","Nenurodytas produktas");
            return false;
        }
        return true;
    }
    private Integer getIntegerFromKiekis()
    {
        return Integer.parseInt(textFieldKiekis.getText());
    }
    private Double getDoubleFromPirkimoKaina()
    {
        return Double.parseDouble(textFieldPirkimoKaina.getText());
    }
}
