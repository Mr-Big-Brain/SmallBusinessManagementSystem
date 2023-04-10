package com.example.smallbusinessmanagementsystem.utilities;

import com.example.smallbusinessmanagementsystem.controller.Finansai.ManageFinansasController;
import com.example.smallbusinessmanagementsystem.controller.Klientai.ManageKlientasController;
import com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai.ManageRoleController;
import com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai.ManageVartotojasController;
import com.example.smallbusinessmanagementsystem.controller.Konfiguracija.KonfiguracijaTabController;
import com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Produktai.ManageProduktasController;
import com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Zymes.ManageZymeController;
import com.example.smallbusinessmanagementsystem.controller.MainController;
import com.example.smallbusinessmanagementsystem.controller.Pardavimai.ManagePardavimasController;
import com.example.smallbusinessmanagementsystem.controller.Pardavimai.ManagePardavimoLinijaController;
import com.example.smallbusinessmanagementsystem.controller.Sandelis.ManageSandelioPrekeController;
import com.example.smallbusinessmanagementsystem.controller.Tvarkarastis.ManageRenginisController;
import com.example.smallbusinessmanagementsystem.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowManager {
    private Stage currentStage;
    public WindowManager() {

    }
    public void showMain(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public void showLogin(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/login-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public void showLoginEdit(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Login/login-edit-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabPardavimai(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController mainController = fxmlLoader.getController();
            mainController.showTabPardavimai();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabSandelis(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController mainController = fxmlLoader.getController();
            mainController.showTabSandelis();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabTvarkarastis(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController mainController = fxmlLoader.getController();
            mainController.showTabTvarkarastis();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabKlientai(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController mainController = fxmlLoader.getController();
            mainController.showTabKlientai();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabFinansai(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController mainController = fxmlLoader.getController();
            mainController.showTabFinansai();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabStatistika(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController mainController = fxmlLoader.getController();
            mainController.showTabStatistika();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabKonfiguracija(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController mainController = fxmlLoader.getController();
            mainController.showTabKonfiguracija();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTabKonfiguracijaZymes(ActionEvent event) {
        try {
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent mainRoot = mainLoader.load();
            MainController mainController = mainLoader.getController();

            mainController.showTabKonfiguracija();

            FXMLLoader tabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Konfiguracija/tab-konfiguracija-view.fxml"));
            Parent tabRoot = tabLoader.load();
            KonfiguracijaTabController tabController = tabLoader.getController();

            tabController.showTabZymes();

            mainController.getTabPaneKategorijos().getSelectionModel().getSelectedItem().setContent(tabRoot);

            Stage nestedTabStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene nestedTabScene = new Scene(mainRoot);
            nestedTabStage.setScene(nestedTabScene);
            nestedTabStage.setTitle("Pagrindinis");


            nestedTabStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTabKonfiguracijaDarbuotojai(ActionEvent event) {
        try {
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent mainRoot = mainLoader.load();
            MainController mainController = mainLoader.getController();

            mainController.showTabKonfiguracija();

            FXMLLoader tabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Konfiguracija/tab-konfiguracija-view.fxml"));
            Parent tabRoot = tabLoader.load();
            KonfiguracijaTabController tabController = tabLoader.getController();

            tabController.showTabDarbuotojai();

            mainController.getTabPaneKategorijos().getSelectionModel().getSelectedItem().setContent(tabRoot);

            Stage nestedTabStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene nestedTabScene = new Scene(mainRoot);
            nestedTabStage.setScene(nestedTabScene);
            nestedTabStage.setTitle("Pagrindinis");


            nestedTabStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTabKonfiguracijaProduktai(ActionEvent event) {
        try {
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent mainRoot = mainLoader.load();
            MainController mainController = mainLoader.getController();

            mainController.showTabKonfiguracija();

            FXMLLoader tabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Konfiguracija/tab-konfiguracija-view.fxml"));
            Parent tabRoot = tabLoader.load();
            KonfiguracijaTabController tabController = tabLoader.getController();

            tabController.showTabProduktai();

            mainController.getTabPaneKategorijos().getSelectionModel().getSelectedItem().setContent(tabRoot);

            Stage nestedTabStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene nestedTabScene = new Scene(mainRoot);
            nestedTabStage.setScene(nestedTabScene);
            nestedTabStage.setTitle("Pagrindinis");


            nestedTabStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManageRole(ActionEvent event, ControllerOperation controllerOperation, VartotojoTipas vartotojoTipas) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Konfiguracija/Darbuotojai/manage-role-view.fxml"));
            ManageRoleController manageRoleController = new ManageRoleController(controllerOperation, vartotojoTipas);
            loader.setController(manageRoleController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManageFinansas(ActionEvent event, ControllerOperation controllerOperation, Finansas finansas) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Finansai/manage-finansas-view.fxml"));
            ManageFinansasController manageFinansasController = new ManageFinansasController(controllerOperation, finansas);
            loader.setController(manageFinansasController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManageKlientas(ActionEvent event, ControllerOperation controllerOperation, Klientas klientas) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Klientai/manage-klientas-view.fxml"));
            ManageKlientasController manageKlientasController = new ManageKlientasController(controllerOperation, klientas);
            loader.setController(manageKlientasController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManageVartotojas(ActionEvent event, ControllerOperation controllerOperation, Vartotojas vartotojas) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Konfiguracija/Darbuotojai/manage-vartotojas-view.fxml"));
            ManageVartotojasController manageVartotojasController = new ManageVartotojasController(controllerOperation, vartotojas);
            loader.setController(manageVartotojasController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManageProduktas(ActionEvent event, ControllerOperation controllerOperation, Produktas produktas) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Konfiguracija/Produktai/manage-produktas-view.fxml"));
            ManageProduktasController manageProduktasController = new ManageProduktasController(controllerOperation, produktas);
            loader.setController(manageProduktasController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManageZyme(ActionEvent event, ControllerOperation controllerOperation, Zyme zyme) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Konfiguracija/Zymes/manage-zyme-view.fxml"));
            ManageZymeController manageZymeController = new ManageZymeController(controllerOperation, zyme);
            loader.setController(manageZymeController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManagePardavimas(ActionEvent event, ControllerOperation controllerOperation, Pardavimas pardavimas) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Pardavimai/manage-pardavimas-view.fxml"));
            ManagePardavimasController managePardavimasController = new ManagePardavimasController(controllerOperation, pardavimas);
            loader.setController(managePardavimasController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManagePardavimoLinija(ActionEvent event, ControllerOperation controllerOperation, PardavimoLinija pardavimoLinija) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Pardavimai/manage-pardavimo-linija-view.fxml"));
            ManagePardavimoLinijaController managePardavimoLinijaController = new ManagePardavimoLinijaController(controllerOperation, pardavimoLinija);
            loader.setController(managePardavimoLinijaController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManageSandelioPreke(ActionEvent event, ControllerOperation controllerOperation, SandelioPreke sandelioPreke) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Sandelis/manage-sandelio-preke-view.fxml"));
            ManageSandelioPrekeController manageSandelioPrekeController = new ManageSandelioPrekeController(controllerOperation, sandelioPreke);
            loader.setController(manageSandelioPrekeController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManageRenginis(ActionEvent event, ControllerOperation controllerOperation, Tvarkarastis tvarkarastis) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Tvarkarastis/manage-renginis-view.fxml"));
            ManageRenginisController manageRenginisController = new ManageRenginisController(controllerOperation, tvarkarastis);
            loader.setController(manageRenginisController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Main");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }
