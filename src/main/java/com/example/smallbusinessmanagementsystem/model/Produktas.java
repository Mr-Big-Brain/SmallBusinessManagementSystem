package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Produktas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String pavadinimas;
    @Column
    private String apibrezimas;
    @Column
    private double rekomenduojamaKaina;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Zyme> zymes;

    public Produktas() {
    }

    public Produktas(String pavadinimas, String apibrezimas, double rekomenduojamaKaina) {
        this.pavadinimas = pavadinimas;
        this.apibrezimas = apibrezimas;
        this.rekomenduojamaKaina = rekomenduojamaKaina;
    }

    public Produktas(String pavadinimas, String apibrezimas, double rekomenduojamaKaina, List<Zyme> zymes) {
        this.pavadinimas = pavadinimas;
        this.apibrezimas = apibrezimas;
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

    public String getApibrezimas() {
        return apibrezimas;
    }

    public void setApibrezimas(String apibrezimas) {
        this.apibrezimas = apibrezimas;
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

    public void addZyme(Zyme zyme)
    {
        if (this.zymes == null) {
            this.zymes = new ArrayList<>();
        }
        this.zymes.add(zyme);
    }
    public void removeZyme(int zymesID)
    {
        for(int i=0;i<this.zymes.size();i++)
        {
            if(this.zymes.get(i).getId()==zymesID)
            {
                this.zymes.remove(i);
                break;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produktas produktas = (Produktas) o;
        return getId() == produktas.getId() && Double.compare(produktas.getRekomenduojamaKaina(), getRekomenduojamaKaina()) == 0 && Objects.equals(getPavadinimas(), produktas.getPavadinimas()) && Objects.equals(getApibrezimas(), produktas.getApibrezimas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPavadinimas(), getApibrezimas(), getRekomenduojamaKaina(), getZymes());
    }
}
