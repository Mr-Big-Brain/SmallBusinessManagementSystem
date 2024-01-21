package com.example.smallbusinessmanagementsystem.controller.Login;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.service.VartotojasService;
import com.example.smallbusinessmanagementsystem.utilities.Md5Converter;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginEditController {

    public VartotojasService vartotojasService;
    WindowManager windowManager;

    private Md5Converter md5Converter;
    //FXML
    private Stage stage;
    private Parent root;
    private Scene scene;

    public LoginEditController() {
        vartotojasService = new VartotojasService();
        windowManager = new WindowManager();
        md5Converter = new Md5Converter();
    }

    @FXML
    private TextField TextFieldVardasSenas;

    @FXML
    private TextField TextFieldVardasNaujas;

    @FXML
    private PasswordField passwordFieldSlaptazodisSenas;

    @FXML
    private PasswordField passwordFieldSlaptazodisNaujas;

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
        if(vartotojasService.prisijungimasEgzistuoja(TextFieldVardasSenas.getText(), md5Converter.getMD5Hash(passwordFieldSlaptazodisSenas.getText())))
        {
            Vartotojas senasVartotojas = vartotojasService.getVartotojasByPrisijungimoVardas(TextFieldVardasSenas.getText());
            Vartotojas naujasVartotojas = vartotojasService.getVartotojasByPrisijungimoVardas(TextFieldVardasSenas.getText());
            naujasVartotojas.setPrisijungimoVardas(TextFieldVardasNaujas.getText());
            naujasVartotojas.setSlaptazodis(md5Converter.getMD5Hash(passwordFieldSlaptazodisNaujas.getText()));
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
