package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pardavimas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private LocalDateTime data;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Vartotojas pardavejas;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Klientas klientas;

    public Pardavimas() {
    }

    public Pardavimas(LocalDateTime data, Vartotojas pardavejas, Klientas klientas) {
        this.data = data;
        this.pardavejas = pardavejas;
        this.klientas = klientas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Vartotojas getPardavejas() {
        return pardavejas;
    }

    public void setPardavejas(Vartotojas pardavejas) {
        this.pardavejas = pardavejas;
    }

    public Klientas getKlientas() {
        return klientas;
    }

    public void setKlientas(Klientas klientas) {
        this.klientas = klientas;
    }
}
