package com.example.smallbusinessmanagementsystem.model;

import com.example.smallbusinessmanagementsystem.utilities.FinansoTipas;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Finansas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private FinansoTipas tipas;
    @Column
    private double kiekis;
    @Column
    private String pavadinimas;
    @Column
    private String apibudinimas;
    @Column
    private LocalDate data;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    private List<Zyme> zymes;
    @ManyToOne
    private Vartotojas vartotojas;

    public Finansas() {
    }

    public Finansas(FinansoTipas tipas, double kiekis, String pavadinimas, String apibudinimas, LocalDate data, List<Zyme> zymes, Vartotojas vartotojas) {
        this.tipas = tipas;
        this.kiekis = kiekis;
        this.pavadinimas = pavadinimas;
        this.apibudinimas = apibudinimas;
        this.data = data;
        this.zymes = zymes;
        this.vartotojas = vartotojas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FinansoTipas getTipas() {
        return tipas;
    }

    public void setTipas(FinansoTipas tipas) {
        this.tipas = tipas;
    }

    public double getKiekis() {
        return kiekis;
    }

    public void setKiekis(double kiekis) {
        this.kiekis = kiekis;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getApibudinimas() {
        return apibudinimas;
    }

    public void setApibudinimas(String apibudinimas) {
        this.apibudinimas = apibudinimas;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Zyme> getZymes() {
        return zymes;
    }

    public void setZymes(List<Zyme> zymes) {
        this.zymes = zymes;
    }

    public Vartotojas getVartotojas() {
        return vartotojas;
    }

    public void setVartotojas(Vartotojas vartotojas) {
        this.vartotojas = vartotojas;
    }
}
