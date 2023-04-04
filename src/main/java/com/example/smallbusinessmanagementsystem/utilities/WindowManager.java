package com.example.smallbusinessmanagementsystem.utilities;

import com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai.UpdateVartotojoRoleController;
import com.example.smallbusinessmanagementsystem.controller.Konfiguracija.KonfiguracijaTabController;
import com.example.smallbusinessmanagementsystem.controller.Login.LoginController;
import com.example.smallbusinessmanagementsystem.controller.MainController;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

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

            FXMLLoader tabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabKonfiguracija/tab-konfiguracija-view.fxml"));
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

            FXMLLoader tabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabKonfiguracija/tab-konfiguracija-view.fxml"));
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

            FXMLLoader tabLoader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabKonfiguracija/tab-konfiguracija-view.fxml"));
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
    public void showRedaguotiRoles(ActionEvent event, VartotojoTipas vartotojoTipas) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smallbusinessmanagementsystem/FXML/TabKonfiguracija/TabDarbuotojai/update-vartotojo-role-view.fxml"));
            Parent root = loader.load();
            UpdateVartotojoRoleController updateVartotojoRoleController = loader.getController();
            updateVartotojoRoleController.setData(vartotojoTipas);
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
