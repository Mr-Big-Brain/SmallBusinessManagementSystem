package com.example.smallbusinessmanagementsystem.utilities;

import com.example.smallbusinessmanagementsystem.controller.*;
import com.example.smallbusinessmanagementsystem.controller.Finansai.ManageFinansasController;
import com.example.smallbusinessmanagementsystem.controller.Klientai.ManageKlientasController;
import com.example.smallbusinessmanagementsystem.controller.Klientai.ManageKomunikacijaController;
import com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai.ManageRoleController;
import com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai.ManageVartotojasController;
import com.example.smallbusinessmanagementsystem.controller.Konfiguracija.KonfiguracijaTabController;
import com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Produktai.ManageProduktasController;
import com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Zymes.ManageZymeController;
import com.example.smallbusinessmanagementsystem.controller.Pardavimai.ManagePardavimasController;
import com.example.smallbusinessmanagementsystem.controller.Pardavimai.ManagePardavimoLinijaController;
import com.example.smallbusinessmanagementsystem.controller.Sandelis.ManageSandelioPrekeController;
import com.example.smallbusinessmanagementsystem.controller.Statistika.Finansai.StatistikaFinansaiTabController;
import com.example.smallbusinessmanagementsystem.controller.Statistika.Klientai.StatistikaKlientaiTabController;
import com.example.smallbusinessmanagementsystem.controller.Statistika.Produktai.StatistikaProduktaiTabController;
import com.example.smallbusinessmanagementsystem.controller.Statistika.StatistikaTabController;
import com.example.smallbusinessmanagementsystem.controller.Statistika.Zymes.StatistikaZymesTabController;
import com.example.smallbusinessmanagementsystem.controller.Tvarkarastis.ManageRenginisController;
import com.example.smallbusinessmanagementsystem.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class WindowManager {
    private Stage currentStage;
    WindowLoader windowLoader;
    public WindowManager() {
        windowLoader = WindowLoader.getInstance();
    }
    public void showMain(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Pagrindinis");
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
        stage.setTitle("Prisijungimas");
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
            stage.setTitle("Keisti prisijungimo duomenis");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabPardavimai(ActionEvent event) {
        try {
            windowLoader.setTabPardavimai(true);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController mainController = fxmlLoader.getController();
            mainController.showTabPardavimai();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Pardavimai");

            stage.show();
            windowLoader.setTabPardavimai(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabSandelis(ActionEvent event) {
        try {
            windowLoader.setTabSandelis(true);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController mainController = fxmlLoader.getController();
            mainController.showTabSandelis();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Sandėlis");

            stage.show();
            windowLoader.setTabSandelis(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabTvarkarastis(ActionEvent event) {
        try {
            windowLoader.setTabTvarkarastis(true);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController mainController = fxmlLoader.getController();
            mainController.showTabTvarkarastis();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Tvarkaraštis");

            stage.show();
            windowLoader.setTabTvarkarastis(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabKlientai(ActionEvent event) {
        try {
            windowLoader.setTabKlientai(true);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController mainController = fxmlLoader.getController();
            mainController.showTabKlientai();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Klientai");

            stage.show();
            windowLoader.setTabKlientai(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabFinansai(ActionEvent event) {
        try {
            windowLoader.setTabFinansai(true);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController mainController = fxmlLoader.getController();
            mainController.showTabFinansai();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Finansai");

            stage.show();
            windowLoader.setTabFinansai(false);
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
            stage.setTitle("Statistika");

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
            stage.setTitle("Konfigūracija");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTabKonfiguracijaZymes(ActionEvent event) {
        try {
            windowLoader.setTabKonfiguracijaZymes(true);
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
            nestedTabStage.setTitle("Žymės");


            nestedTabStage.show();
            windowLoader.setTabKonfiguracijaZymes(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTabKonfiguracijaDarbuotojai(ActionEvent event) {
        try {
            windowLoader.setTabKonfiguracijaDarbuotojai(true);
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
            nestedTabStage.setTitle("Darbuotojai");


            nestedTabStage.show();
            windowLoader.setTabKonfiguracijaDarbuotojai(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTabKonfiguracijaProduktai(ActionEvent event) {
        try {
            windowLoader.setTabKonfiguracijaProduktai(true);
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
            nestedTabStage.setTitle("Produktai");


            nestedTabStage.show();
            windowLoader.setTabKonfiguracijaProduktai(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabStatistikaProduktai(ActionEvent event, List<Produktas> produktasList, LocalDate nuo, LocalDate iki) {
        try {
            windowLoader.setTabStatistikaProduktai(true);
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent mainRoot = mainLoader.load();
            MainController mainController = mainLoader.getController();

            mainController.showTabStatistika();

            FXMLLoader tabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabStatistika/tab-statistika-view.fxml"));
            Parent tabRoot = tabLoader.load();
            StatistikaTabController tabController = tabLoader.getController();

            tabController.showTabProduktai();

            Stage nestedTabStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader subTabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabStatistika/tab-statistika-produktai-view.fxml"));
            StatistikaProduktaiTabController statistikaProduktaiTabControllernew = new StatistikaProduktaiTabController(produktasList,nuo,iki);
            subTabLoader.setController(statistikaProduktaiTabControllernew);
            Parent subTabRoot = subTabLoader.load();
            StatistikaProduktaiTabController subTabController = subTabLoader.getController();


            tabController.getTabPaneStatistika().getSelectionModel().getSelectedItem().setContent(subTabRoot);
            mainController.getTabPaneKategorijos().getSelectionModel().getSelectedItem().setContent(tabRoot);

            Scene nestedTabScene = new Scene(mainRoot);
            nestedTabStage.setScene(nestedTabScene);
            nestedTabStage.setTitle("Produktų statistika");


            nestedTabStage.show();

            windowLoader.setTabStatistikaProduktai(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabStatistikaKlientai(ActionEvent event, Klientas klientas, LocalDate nuo, LocalDate iki, StatistikaKlientaiChoice statistikaKlientaiChoice) {
        try {
            windowLoader.setTabStatistikaKlientai(true);
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent mainRoot = mainLoader.load();
            MainController mainController = mainLoader.getController();

            mainController.showTabStatistika();

            FXMLLoader tabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabStatistika/tab-statistika-view.fxml"));
            Parent tabRoot = tabLoader.load();
            StatistikaTabController tabController = tabLoader.getController();

            tabController.showTabKlientai();

            Stage nestedTabStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader subTabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabStatistika/tab-statistika-klientai-view.fxml"));
            StatistikaKlientaiTabController statistikaKlientaiTabControllernew = new StatistikaKlientaiTabController(klientas, nuo, iki, statistikaKlientaiChoice);
            subTabLoader.setController(statistikaKlientaiTabControllernew);
            Parent subTabRoot = subTabLoader.load();
            StatistikaKlientaiTabController subTabController = subTabLoader.getController();


            tabController.getTabPaneStatistika().getSelectionModel().getSelectedItem().setContent(subTabRoot);
            mainController.getTabPaneKategorijos().getSelectionModel().getSelectedItem().setContent(tabRoot);

            Scene nestedTabScene = new Scene(mainRoot);
            nestedTabStage.setScene(nestedTabScene);
            nestedTabStage.setTitle("Klientų statistika");


            nestedTabStage.show();

            windowLoader.setTabStatistikaProduktai(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabStatistikaFinansai(ActionEvent event) {
        try {
            windowLoader.setTabStatistikaFinansai(true);
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent mainRoot = mainLoader.load();
            MainController mainController = mainLoader.getController();

            mainController.showTabStatistika();

            FXMLLoader tabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabStatistika/tab-statistika-view.fxml"));
            Parent tabRoot = tabLoader.load();
            StatistikaTabController tabController = tabLoader.getController();

            tabController.showTabFinansai();


            Stage nestedTabStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader subTabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabStatistika/tab-statistika-finansai-view.fxml"));
            StatistikaFinansaiTabController statistikaFinansaiTabControllernew = new StatistikaFinansaiTabController();
            subTabLoader.setController(statistikaFinansaiTabControllernew);
            Parent subTabRoot = subTabLoader.load();
            StatistikaFinansaiTabController subTabController = subTabLoader.getController();


            tabController.getTabPaneStatistika().getSelectionModel().getSelectedItem().setContent(subTabRoot);
            mainController.getTabPaneKategorijos().getSelectionModel().getSelectedItem().setContent(tabRoot);

            Scene nestedTabScene = new Scene(mainRoot);
            nestedTabStage.setScene(nestedTabScene);
            nestedTabStage.setTitle("Finansų statistika");


            nestedTabStage.show();

            windowLoader.setTabStatistikaFinansai(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabStatistikaFinansai(ActionEvent event, List<Zyme> zymeList, LocalDate nuo, LocalDate iki, FinansoTipas finansoTipas) {
        try {
            windowLoader.setTabStatistikaFinansai(true);
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent mainRoot = mainLoader.load();
            MainController mainController = mainLoader.getController();

            mainController.showTabStatistika();

            FXMLLoader tabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabStatistika/tab-statistika-view.fxml"));
            Parent tabRoot = tabLoader.load();
            StatistikaTabController tabController = tabLoader.getController();

            tabController.showTabFinansai();


            Stage nestedTabStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader subTabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabStatistika/tab-statistika-finansai-view.fxml"));
            StatistikaFinansaiTabController statistikaFinansaiTabControllernew = new StatistikaFinansaiTabController(zymeList, nuo, iki, finansoTipas);
            subTabLoader.setController(statistikaFinansaiTabControllernew);
            Parent subTabRoot = subTabLoader.load();
            StatistikaFinansaiTabController subTabController = subTabLoader.getController();


            tabController.getTabPaneStatistika().getSelectionModel().getSelectedItem().setContent(subTabRoot);
            mainController.getTabPaneKategorijos().getSelectionModel().getSelectedItem().setContent(tabRoot);

            Scene nestedTabScene = new Scene(mainRoot);
            nestedTabStage.setScene(nestedTabScene);
            nestedTabStage.setTitle("Finansų statistika");


            nestedTabStage.show();

            windowLoader.setTabStatistikaFinansai(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabStatistikaZymes(ActionEvent event) {
        try {
            windowLoader.setTabStatistikaZymes(true);
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent mainRoot = mainLoader.load();
            MainController mainController = mainLoader.getController();

            mainController.showTabStatistika();

            FXMLLoader tabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabStatistika/tab-statistika-view.fxml"));
            Parent tabRoot = tabLoader.load();
            StatistikaTabController tabController = tabLoader.getController();

            tabController.showTabZymes();


            Stage nestedTabStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader subTabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabStatistika/tab-statistika-zymes-view.fxml"));
            StatistikaZymesTabController statistikaZymesTabControllernew = new StatistikaZymesTabController();
            subTabLoader.setController(statistikaZymesTabControllernew);
            Parent subTabRoot = subTabLoader.load();
            StatistikaZymesTabController subTabController = subTabLoader.getController();


            tabController.getTabPaneStatistika().getSelectionModel().getSelectedItem().setContent(subTabRoot);
            mainController.getTabPaneKategorijos().getSelectionModel().getSelectedItem().setContent(tabRoot);

            Scene nestedTabScene = new Scene(mainRoot);
            nestedTabStage.setScene(nestedTabScene);
            nestedTabStage.setTitle("Žymių statistika");


            nestedTabStage.show();

            windowLoader.setTabStatistikaZymes(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTabStatistikaZymes(ActionEvent event, List<Zyme> zymeList, LocalDate nuo, LocalDate iki, StatistikaProduktaiChoice statistikaProduktaiChoice) {
        try {
            windowLoader.setTabStatistikaZymes(true);
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/main-view.fxml"));
            Parent mainRoot = mainLoader.load();
            MainController mainController = mainLoader.getController();

            mainController.showTabStatistika();

            FXMLLoader tabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabStatistika/tab-statistika-view.fxml"));
            Parent tabRoot = tabLoader.load();
            StatistikaTabController tabController = tabLoader.getController();

            tabController.showTabZymes();


            Stage nestedTabStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader subTabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabStatistika/tab-statistika-zymes-view.fxml"));
            StatistikaZymesTabController statistikaZymesTabControllernew = new StatistikaZymesTabController(zymeList, nuo, iki, statistikaProduktaiChoice);
            subTabLoader.setController(statistikaZymesTabControllernew);
            Parent subTabRoot = subTabLoader.load();
            StatistikaZymesTabController subTabController = subTabLoader.getController();


            tabController.getTabPaneStatistika().getSelectionModel().getSelectedItem().setContent(subTabRoot);
            mainController.getTabPaneKategorijos().getSelectionModel().getSelectedItem().setContent(tabRoot);

            Scene nestedTabScene = new Scene(mainRoot);
            nestedTabStage.setScene(nestedTabScene);
            nestedTabStage.setTitle("Žymių statistika");


            nestedTabStage.show();

            windowLoader.setTabStatistikaZymes(false);
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
            stage.setTitle("Rolė");

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
            stage.setTitle("Finansų įrašas");

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
            stage.setTitle("Klientas");

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
            stage.setTitle("Darbuotojas");

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
            stage.setTitle("Produktas");

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
            stage.setTitle("Žymė");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManagePardavimas(ActionEvent event, ControllerOperation controllerOperation, Pardavimas pardavimas, List<PardavimoLinija> pardavimoLinijos) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Pardavimai/manage-pardavimas-view.fxml"));
            ManagePardavimasController managePardavimasController = new ManagePardavimasController(controllerOperation, pardavimas, pardavimoLinijos);
            loader.setController(managePardavimasController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Pardavimas");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManagePardavimoLinija(ActionEvent event, ControllerOperation controllerOperation, Pardavimas pardavimas, List<PardavimoLinija> pardavimoLinijos, Integer linijosNum) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Pardavimai/manage-pardavimo-linija-view.fxml"));
            ManagePardavimoLinijaController managePardavimoLinijaController = new ManagePardavimoLinijaController(controllerOperation, pardavimas, pardavimoLinijos, linijosNum);
            loader.setController(managePardavimoLinijaController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Pardavimo linija");

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
            stage.setTitle("Sandėlio prekė");

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
            stage.setTitle("Renginys");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManageKomunikacija(ActionEvent event, ControllerOperation controllerOperation, Komunikacija komunikacija) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/Klientai/manage-komunikacija-view.fxml"));
            ManageKomunikacijaController manageKomunikacijaController = new ManageKomunikacijaController(controllerOperation, komunikacija);
            loader.setController(manageKomunikacijaController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Komunikacija");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showFindZyme(ActionEvent event, ControllerOperation controllerOperation, Object object) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/find-zyme-view.fxml"));
            FindZymeController findZymeController = new FindZymeController(controllerOperation, object);
            loader.setController(findZymeController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Žymė");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showFindZyme(ActionEvent event, ControllerOperation controllerOperation, List<Zyme> zymeList, LocalDate nuo, LocalDate iki, FinansoTipas finansoTipas) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/find-zyme-view.fxml"));
            FindZymeController findZymeController = new FindZymeController(controllerOperation, zymeList, nuo, iki, finansoTipas);
            loader.setController(findZymeController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Rasti žymę");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showFindZyme(ActionEvent event, ControllerOperation controllerOperation, List<Zyme> zymeList, LocalDate nuo, LocalDate iki, StatistikaProduktaiChoice statistikaProduktaiChoice) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/find-zyme-view.fxml"));
            FindZymeController findZymeController = new FindZymeController(controllerOperation, zymeList, nuo, iki, statistikaProduktaiChoice);
            loader.setController(findZymeController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Rasti žymę");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showFindProduktas(ActionEvent event, ControllerOperation controllerOperation, Object object) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/find-produktas-view.fxml"));
            FindProduktasController findProduktasController = new FindProduktasController(controllerOperation, object);
            loader.setController(findProduktasController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Rasti produktą");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showFindProduktas(ActionEvent event, ControllerOperation controllerOperationn, Pardavimas pardavimas, List<PardavimoLinija> pardavimoLinijos, Integer linijosNumm) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/find-produktas-view.fxml"));
            FindProduktasController findProduktasController = new FindProduktasController(controllerOperationn,pardavimas,pardavimoLinijos,linijosNumm);
            loader.setController(findProduktasController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Rasti produktą");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showFindProduktas(ActionEvent event, List<Produktas> produktasList, LocalDate nuo, LocalDate iki, ControllerOperation controllerOperation) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/find-produktas-view.fxml"));
            FindProduktasController findProduktasController = new FindProduktasController(produktasList,nuo,iki,controllerOperation);
            loader.setController(findProduktasController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Rasti produktą");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showFindSandelioPreke(ActionEvent event, ControllerOperation controllerOperation, List<PardavimoLinija> pardavimoLinijaList, Pardavimas pardavimas, int linijosNum) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/find-sandelio-preke-view.fxml"));
            FindSandelioPrekeController findSandelioPrekeController = new FindSandelioPrekeController(controllerOperation, pardavimoLinijaList, pardavimas, linijosNum);
            loader.setController(findSandelioPrekeController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Rasti prekę");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showFindVartotojas(ActionEvent event, ControllerOperation controllerOperation, Object object) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/find-vartotojas-view.fxml"));
            FindVartotojasController findVartotojasController = new FindVartotojasController(controllerOperation, object);
            loader.setController(findVartotojasController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Rasti vartotoją");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showFindKlientas(ActionEvent event, ControllerOperation controllerOperation, Object object, List<PardavimoLinija> pardavimoLinijos) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/find-klientas-view.fxml"));
            FindKlientasController findKlientasController = new FindKlientasController(controllerOperation, object, pardavimoLinijos);
            loader.setController(findKlientasController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Rasti klientą");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showFindKlientas(ActionEvent event, ControllerOperation controllerOperationn, LocalDate nuo, LocalDate iki, StatistikaKlientaiChoice statistikaKlientaiChoice) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/find-klientas-view.fxml"));
            FindKlientasController findKlientasController = new FindKlientasController(controllerOperationn, nuo, iki, statistikaKlientaiChoice);
            loader.setController(findKlientasController); // set the controller instance

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Rasti klientą");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
