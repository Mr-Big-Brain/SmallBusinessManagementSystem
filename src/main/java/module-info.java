module com.example.smallbusinessmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.hibernate.orm.core;
    requires java.persistence;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    //requires mysql.connector.java;
    requires java.sql;

    opens com.example.smallbusinessmanagementsystem to javafx.fxml;
    exports com.example.smallbusinessmanagementsystem;

    opens com.example.smallbusinessmanagementsystem.controller to javafx.fxml;
    exports com.example.smallbusinessmanagementsystem.controller;

    opens com.example.smallbusinessmanagementsystem.model to org.hibernate.orm.core;
    exports com.example.smallbusinessmanagementsystem.model;

    opens com.example.smallbusinessmanagementsystem.persistenceController to com.example.smallbusinessmanagementsystem.controller, org.hibernate.orm.core;
    exports com.example.smallbusinessmanagementsystem.persistenceController;

    exports com.example.smallbusinessmanagementsystem.utilities;

    opens com.example.smallbusinessmanagementsystem.service to com.example.smallbusinessmanagementsystem.controller, org.hibernate.orm.core;
    exports com.example.smallbusinessmanagementsystem.service;
    exports com.example.smallbusinessmanagementsystem.controller.Konfiguracija;
    opens com.example.smallbusinessmanagementsystem.controller.Konfiguracija to javafx.fxml;
    exports com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai;
    opens com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Darbuotojai to javafx.fxml;
    exports com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Produktai;
    opens com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Produktai to javafx.fxml;
    exports com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Zymes;
    opens com.example.smallbusinessmanagementsystem.controller.Konfiguracija.Zymes to javafx.fxml;
    exports com.example.smallbusinessmanagementsystem.controller.Statistika;
    opens com.example.smallbusinessmanagementsystem.controller.Statistika to javafx.fxml;
    exports com.example.smallbusinessmanagementsystem.controller.Finansai;
    opens com.example.smallbusinessmanagementsystem.controller.Finansai to javafx.fxml;
    exports com.example.smallbusinessmanagementsystem.controller.Klientai;
    opens com.example.smallbusinessmanagementsystem.controller.Klientai to javafx.fxml;
    exports com.example.smallbusinessmanagementsystem.controller.Login;
    opens com.example.smallbusinessmanagementsystem.controller.Login to javafx.fxml;
    exports com.example.smallbusinessmanagementsystem.controller.Pardavimai;
    opens com.example.smallbusinessmanagementsystem.controller.Pardavimai to javafx.fxml;
    exports com.example.smallbusinessmanagementsystem.controller.Sandelis;
    opens com.example.smallbusinessmanagementsystem.controller.Sandelis to javafx.fxml;
    exports com.example.smallbusinessmanagementsystem.controller.Tvarkarastis;
    opens com.example.smallbusinessmanagementsystem.controller.Tvarkarastis to javafx.fxml;


}