package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Tvarkarastis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private LocalDateTime dataNuo;
    @Column
    private LocalDateTime dataIki;
    @Column
    private String pavadinimas;
    @Column
    private String aprasymas;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Vartotojas kasSukure;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Vartotojas kamSukure;

    public Tvarkarastis() {
    }

    public Tvarkarastis(LocalDateTime dataNuo, LocalDateTime dataIki, String pavadinimas, String aprasymas, Vartotojas kasSukure, Vartotojas kamSukure) {
        this.dataNuo = dataNuo;
        this.dataIki = dataIki;
        this.pavadinimas = pavadinimas;
        this.aprasymas = aprasymas;
        this.kasSukure = kasSukure;
        this.kamSukure = kamSukure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataNuo() {
        return dataNuo;
    }

    public void setDataNuo(LocalDateTime dataNuo) {
        this.dataNuo = dataNuo;
    }

    public LocalDateTime getDataIki() {
        return dataIki;
    }

    public void setDataIki(LocalDateTime dataIki) {
        this.dataIki = dataIki;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getAprasymas() {
        return aprasymas;
    }

    public void setAprasymas(String aprasymas) {
        this.aprasymas = aprasymas;
    }

    public Vartotojas getKasSukure() {
        return kasSukure;
    }

    public void setKasSukure(Vartotojas kasSukure) {
        this.kasSukure = kasSukure;
    }

    public Vartotojas getKamSukure() {
        return kamSukure;
    }

    public void setKamSukure(Vartotojas kamSukure) {
        this.kamSukure = kamSukure;
    }
}
