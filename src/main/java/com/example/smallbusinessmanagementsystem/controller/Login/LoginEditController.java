package com.example.smallbusinessmanagementsystem.controller.Login;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.persistenceController.VartotojasPersistenceController;
import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginEditController {

    public VartotojasPersistenceController vartotojasPersistenceController;
    public VartotojasService vartotojasService;
    WindowManager windowManager;

    //FXML
    private Stage stage;
    private Parent root;
    private Scene scene;

    public LoginEditController() {
        vartotojasPersistenceController = new VartotojasPersistenceController();
        vartotojasService = new VartotojasService();
        windowManager = new WindowManager();
    }

    @FXML
    private TextField TextFieldVardasSenas;

    @FXML
    private TextField TextFieldSlaptazodisSenas;

    @FXML
    private TextField TextFieldVardasNaujas;

    @FXML
    private TextField TextFieldSlaptazodisNaujas;

    @FXML
    private Button buttonKeistiDuomenis;

    @FXML
    private Button buttonAtgal;

    @FXML
    void griztiAtgal(ActionEvent event) {
        windowManager.showLogin(event);
    }

    @FXML
    void keistiDuomenis(ActionEvent event) {
        if(vartotojasService.prisijungimasEgzistuoja(TextFieldVardasSenas.getText(), TextFieldSlaptazodisSenas.getText()))
        {
            Vartotojas senasVartotojas = vartotojasService.getVartotojasByPrisijungimoVardas(TextFieldVardasSenas.getText());
            Vartotojas naujasVartotojas = vartotojasService.getVartotojasByPrisijungimoVardas(TextFieldVardasSenas.getText());
            naujasVartotojas.setPrisijungimoVardas(TextFieldVardasNaujas.getText());
            naujasVartotojas.setSlaptazodis(TextFieldSlaptazodisNaujas.getText());
            if(vartotojasService.tryUpdateVartotojas(naujasVartotojas, senasVartotojas))
            {
                AllertBox.display("Pavyko","Vartotojas atnaujintas");
                windowManager.showLogin(event);
            }
        }
        else
        {
            AllertBox.display("Klaida", "Toks vartotojas nerastas");
        }
    }
}
