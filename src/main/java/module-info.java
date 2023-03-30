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

    opens com.example.smallbusinessmanagementsystem.service to com.example.smallbusinessmanagementsystem.controller, org.hibernate.orm.core;
    exports com.example.smallbusinessmanagementsystem.service;


}