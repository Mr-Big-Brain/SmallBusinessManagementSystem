package com.example.smallbusinessmanagementsystem.model;

import com.example.smallbusinessmanagementsystem.utilities.ZymesTipas;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zyme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String pavadinimas;
    @Column
    private ZymesTipas tipas;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    private List<Finansas> finansai;
    @ManyToMany
    private List<Produktas> produktai;

    public Zyme() {
    }
    public Zyme(String pavadinimas, ZymesTipas tipas) {
        this.pavadinimas = pavadinimas;
        this.tipas = tipas;
    }
    public Zyme(String pavadinimas, ZymesTipas tipas, List<Finansas> finansai, List<Produktas> produktai) {
        this.pavadinimas = pavadinimas;
        this.tipas = tipas;
        this.finansai = finansai;
        this.produktai = produktai;
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

    public ZymesTipas getTipas() {
        return tipas;
    }

    public void setTipas(ZymesTipas tipas) {
        this.tipas = tipas;
    }

    public List<Finansas> getFinansai() {
        return finansai;
    }

    public void setFinansai(List<Finansas> finansai) {
        this.finansai = finansai;
    }

    public List<Produktas> getProduktai() {
        return produktai;
    }

    public void setProduktai(List<Produktas> produktai) {
        this.produktai = produktai;
    }
}
