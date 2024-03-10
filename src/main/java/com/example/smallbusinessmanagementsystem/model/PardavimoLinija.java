package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
public class PardavimoLinija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int kiekis;
    @Column
    private double pirkimoKaina;
    @Column
    private double kainaUzViena;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Produktas produktas;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Pardavimas pardavimas;

    public PardavimoLinija() {
    }

    public PardavimoLinija(int kiekis, double pirkimoKaina, double kainaUzViena, Produktas produktas, Pardavimas pardavimas) {
        this.kiekis = kiekis;
        this.pirkimoKaina = pirkimoKaina;
        this.kainaUzViena = kainaUzViena;
        this.produktas = produktas;
        this.pardavimas = pardavimas;
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

    public double getPirkimoKaina() { return pirkimoKaina;};

    public void setPirkimoKaina(double pirkimoKaina) {this.pirkimoKaina = pirkimoKaina;}

    public double getKainaUzViena() {
        return kainaUzViena;
    }

    public void setKainaUzViena(double kainaUzViena) {
        this.kainaUzViena = kainaUzViena;
    }

    public Produktas getProduktas() {
        return produktas;
    }

    public void setProduktas(Produktas produktas) {
        this.produktas = produktas;
    }

    public Pardavimas getPardavimas() {
        return pardavimas;
    }

    public void setPardavimas(Pardavimas pardavimas) {
        this.pardavimas = pardavimas;
    }
}
