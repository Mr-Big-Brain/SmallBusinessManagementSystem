package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Komunikacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String pavadinimas;
    @Column
    private String apibrezimas;
    @Column
    private LocalDate data;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Produktas produktas;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Klientas klientas;

    public Komunikacija() {
    }

    public Komunikacija(String pavadinimas, String apibrezimas, LocalDate data, Produktas produktas, Klientas klientas) {
        this.pavadinimas = pavadinimas;
        this.apibrezimas = apibrezimas;
        this.data = data;
        this.produktas = produktas;
        this.klientas = klientas;
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

    public String getApibrezimas() {
        return apibrezimas;
    }

    public void setApibrezimas(String apibrezimas) {
        this.apibrezimas = apibrezimas;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Produktas getProduktas() {
        return produktas;
    }

    public void setProduktas(Produktas produktas) {
        this.produktas = produktas;
    }

    public Klientas getKlientas() {
        return klientas;
    }

    public void setKlientas(Klientas klientas) {
        this.klientas = klientas;
    }
}
