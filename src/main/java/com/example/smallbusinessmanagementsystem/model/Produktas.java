package com.example.smallbusinessmanagementsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Produktas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String pavadinimas;
    @Column
    private double pirkimoKaina;
    @Column
    private double rekomenduojamaKaina;
    @ManyToMany
    private List<Zyme> zymes;

    public Produktas() {
    }

    public Produktas(String pavadinimas, double pirkimoKaina, double rekomenduojamaKaina, List<Zyme> zymes) {
        this.pavadinimas = pavadinimas;
        this.pirkimoKaina = pirkimoKaina;
        this.rekomenduojamaKaina = rekomenduojamaKaina;
        this.zymes = zymes;
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

    public double getPirkimoKaina() {
        return pirkimoKaina;
    }

    public void setPirkimoKaina(double pirkimoKaina) {
        this.pirkimoKaina = pirkimoKaina;
    }

    public double getRekomenduojamaKaina() {
        return rekomenduojamaKaina;
    }

    public void setRekomenduojamaKaina(double rekomenduojamaKaina) {
        this.rekomenduojamaKaina = rekomenduojamaKaina;
    }

    public List<Zyme> getZymes() {
        return zymes;
    }

    public void setZymes(List<Zyme> zymes) {
        this.zymes = zymes;
    }
}
