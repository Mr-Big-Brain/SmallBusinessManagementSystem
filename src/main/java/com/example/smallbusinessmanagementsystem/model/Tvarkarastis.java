package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Tvarkarastis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private LocalDate data;
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

    public Tvarkarastis(LocalDate data, String pavadinimas, String aprasymas, Vartotojas kasSukure, Vartotojas kamSukure) {
        this.data = data;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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
