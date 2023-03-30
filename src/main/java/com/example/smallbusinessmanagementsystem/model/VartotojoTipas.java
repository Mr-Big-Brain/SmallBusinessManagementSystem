package com.example.smallbusinessmanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class VartotojoTipas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String pavadinimas;
    @Column
    private Boolean pardavimai;
    @Column
    private Boolean sandelis;
    @Column
    private Boolean klientai;
    @Column
    private Boolean konfiguracija;
    @Column
    private Boolean finansai;
    @Column
    private Boolean statistika;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Boolean getPardavimai() {
        return pardavimai;
    }

    public void setPardavimai(Boolean pardavimai) {
        this.pardavimai = pardavimai;
    }

    public Boolean getSandelis() {
        return sandelis;
    }

    public void setSandelis(Boolean sandelis) {
        this.sandelis = sandelis;
    }

    public Boolean getKlientai() {
        return klientai;
    }

    public void setKlientai(Boolean klientai) {
        this.klientai = klientai;
    }

    public Boolean getKonfiguracija() {
        return konfiguracija;
    }

    public void setKonfiguracija(Boolean konfiguracija) {
        this.konfiguracija = konfiguracija;
    }

    public Boolean getFinansai() {
        return finansai;
    }

    public void setFinansai(Boolean finansai) {
        this.finansai = finansai;
    }

    public Boolean getStatistika() {
        return statistika;
    }

    public void setStatistika(Boolean statistika) {
        this.statistika = statistika;
    }
}
