package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
public class SandelioPreke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int kiekis;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Produktas produktas;

    public SandelioPreke() {
    }

    public SandelioPreke(int kiekis, Produktas produktas) {
        this.kiekis = kiekis;
        this.produktas = produktas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKiekis() {
        return kiekis;
    }

    public void setKiekis(int kiekis) {
        this.kiekis = kiekis;
    }

    public Produktas getProduktas() {
        return produktas;
    }

    public void setProduktas(Produktas produktas) {
        this.produktas = produktas;
    }
}
