package com.example.smallbusinessmanagementsystem.model;

import javax.persistence.*;

@Entity
public class Klientas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String vardas;
    @Column
    private String pavarde;
    @Column
    private String imone;
    @Column
    private String telefonas;
    @Column
    private String pastas;

    public Klientas() {
    }

    public Klientas(String vardas, String pavarde, String imone, String telefonas, String pastas) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.imone = imone;
        this.telefonas = telefonas;
        this.pastas = pastas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getImone() {
        return imone;
    }

    public void setImone(String imone) {
        this.imone = imone;
    }

    public String getTelefonas() {
        return telefonas;
    }

    public void setTelefonas(String telefonas) {
        this.telefonas = telefonas;
    }

    public String getPastas() {
        return pastas;
    }

    public void setPastas(String pastas) {
        this.pastas = pastas;
    }
}
