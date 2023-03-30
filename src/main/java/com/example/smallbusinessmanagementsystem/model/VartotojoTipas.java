package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
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
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "vartotojoTipas", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @OrderBy("id ASC")
    private List<Vartotojas> vartotojai = new ArrayList<>();
    public VartotojoTipas() {

    }
    public VartotojoTipas(String pavadinimas, Boolean pardavimai, Boolean sandelis, Boolean klientai, Boolean konfiguracija, Boolean finansai, Boolean statistika) {
        this.pavadinimas = pavadinimas;
        this.pardavimai = pardavimai;
        this.sandelis = sandelis;
        this.klientai = klientai;
        this.konfiguracija = konfiguracija;
        this.finansai = finansai;
        this.statistika = statistika;
    }

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
