package com.example.smallbusinessmanagementsystem.controller.Pardavimai;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Pardavimas;
import com.example.smallbusinessmanagementsystem.model.PardavimoLinija;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.service.PardavimoLinijaService;
import com.example.smallbusinessmanagementsystem.utilities.ControllerOperation;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManagePardavimoLinijaController implements Initializable{
    PardavimoLinijaService pardavimoLinijaService;
    List<PardavimoLinija> pardavimoLinijosModifikacijai;
    Pardavimas pardavimasModifikacijai;
    WindowManager windowManager;
    ControllerOperation controllerOperation;
    Integer linijosNumeris;
    public ManagePardavimoLinijaController(ControllerOperation controllerOperationn, Pardavimas pardavimas, List<PardavimoLinija> pardavimoLinijos, Integer linijosNum)
    {
        windowManager = new WindowManager();
        pardavimoLinijaService = new PardavimoLinijaService();
        pardavimoLinijosModifikacijai = pardavimoLinijos;
        controllerOperation = controllerOperationn;
        pardavimasModifikacijai = pardavimas;
        linijosNumeris = linijosNum;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonAction.setText("Apdoroti");
        fillData();
    }

    @FXML
    private TextField textFieldProduktas;

    @FXML
    private TextField textFieldKainaVieneto;

    @FXML
    private TextField textFieldPirkimoKaina;

    @FXML
    private TextField textFieldKiekis;

    @FXML
    private Button buttonAtgal;

    @FXML
    private Button buttonAction;

    @FXML
    private Button buttonPridetiProdukta;

    @FXML
    void action(ActionEvent event) {
        if(validatePardavimoLinija())
        {
            constructPardavimoLinija();
            windowManager.showManagePardavimas(event,controllerOperation,pardavimasModifikacijai,pardavimoLinijosModifikacijai);
        }
    }

    @FXML
    void atgal(ActionEvent event) {
        if(controllerOperation==ControllerOperation.CREATE_PARDAVIMAS)
        {
            pardavimoLinijosModifikacijai.remove(pardavimoLinijosModifikacijai.size()-1);
        }
        windowManager.showManagePardavimas(event,controllerOperation,pardavimasModifikacijai,pardavimoLinijosModifikacijai);
    }

    @FXML
    void pridetiProdukta(ActionEvent event) {
        windowManager.showFindSandelioPreke(event,controllerOperation,pardavimoLinijosModifikacijai, pardavimasModifikacijai,linijosNumeris);
    }
    private boolean validatePardavimoLinija()
    {
        if(validateKainaFormat(textFieldKainaVieneto.getText(), true)&&validateKiekisFormat(textFieldKiekis.getText(),true)&&validateProduktas())
        {
            return true;
        }
        return false;
    }
    private boolean validateKainaFormat(String kaina, Boolean arSuPranesimais)
    {
        if(Objects.equals(kaina, "")||kaina == null)
        {
            if(arSuPranesimais)
            {
                AllertBox.display("Klaida","Nenurodyta kaina");
            }
            return false;
        }
        try {
            double value = Double.parseDouble(kaina);
            if(value<=0)
            {
                if(arSuPranesimais) {
                    AllertBox.display("Klaida", "Pinigų suma privalo buti teigiama");
                }
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            if(arSuPranesimais) {
                AllertBox.display("Klaida", "Blogas pinigų formatas");
            }
            return false;
        }
    }
    private boolean validateKiekisFormat(String kiekis,Boolean arSuPranesimais)
    {
        if(Objects.equals(kiekis, "")||kiekis == null)
        {
            if(arSuPranesimais)
            {
                AllertBox.display("Klaida","Nenurodytas kiekis");
            }
            return false;
        }
        try {
            Integer value = Integer.parseInt(kiekis);
            if(value<=0)
            {
                if(arSuPranesimais) {
                    AllertBox.display("Klaida", "Kiekis privalo buti teigiamas");
                }
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            if(arSuPranesimais) {
                AllertBox.display("Klaida", "Blogas kiekio formatas");
            }
            return false;
        }
    }
    private boolean validateProduktas()
    {
        if(linijosNumeris==-1)
        {
            linijosNumeris = pardavimoLinijosModifikacijai.size()-1;
        }
        if(pardavimoLinijosModifikacijai.get(linijosNumeris).getProduktas()==null)
        {
            AllertBox.display("Klaida", "Nepasirinktas produktas");
            return false;
        }
        return true;
    }
    private void constructPardavimoLinija()
    {
        if(pardavimoLinijosModifikacijai==null)
        {
            pardavimoLinijosModifikacijai = new ArrayList<>();
        }
        if(linijosNumeris == -1)
        {
            PardavimoLinija pardavimoLinija = new PardavimoLinija();
            if(validateKiekisFormat(textFieldKiekis.getText(),false))
            {
                pardavimoLinija.setKiekis(Integer.parseInt(textFieldKiekis.getText()));
            }
            if(validateKainaFormat(textFieldKainaVieneto.getText(), false))
            {
                pardavimoLinija.setKainaUzViena(Double.parseDouble(textFieldKainaVieneto.getText()));
            }
            pardavimoLinijosModifikacijai.add(pardavimoLinija);
            linijosNumeris = pardavimoLinijosModifikacijai.size()-1;
        }
        else
        {
            if(validateKiekisFormat(textFieldKiekis.getText(),false))
            {
                pardavimoLinijosModifikacijai.get(linijosNumeris).setKiekis(Integer.parseInt(textFieldKiekis.getText()));
            }
            if(validateKainaFormat(textFieldKainaVieneto.getText(),false))
            {
                pardavimoLinijosModifikacijai.get(linijosNumeris).setKainaUzViena(Double.parseDouble(textFieldKainaVieneto.getText()));
            }
        }
    }
    private void fillData()
    {
        if(pardavimoLinijosModifikacijai!=null && pardavimoLinijosModifikacijai.size()!=0 && pardavimoLinijosModifikacijai.size()>linijosNumeris)
        {
            if(linijosNumeris == -1)
            {
                insertData(0);
            }
            else
            {
                insertData(linijosNumeris);
            }

        }
    }
    private void insertData(int lineNo) {
        if(pardavimoLinijosModifikacijai.get(lineNo).getKainaUzViena()!=0)
        {
            textFieldKainaVieneto.setText(String.valueOf(pardavimoLinijosModifikacijai.get(lineNo).getKainaUzViena()));
        }
        if(pardavimoLinijosModifikacijai.get(lineNo).getPirkimoKaina()!=0)
        {
            textFieldPirkimoKaina.setText(String.valueOf(pardavimoLinijosModifikacijai.get(lineNo).getPirkimoKaina()));
        }
        if(pardavimoLinijosModifikacijai.get(lineNo).getKiekis()!=0)
        {
            textFieldKiekis.setText(String.valueOf(pardavimoLinijosModifikacijai.get(lineNo).getKiekis()));
        }
        if(pardavimoLinijosModifikacijai.get(lineNo).getProduktas()!=null)
        {
            Produktas produktas = pardavimoLinijosModifikacijai.get(lineNo).getProduktas();
            textFieldProduktas.setText(produktas.getId() +  ", " + produktas.getPavadinimas());
        }
    }


}
