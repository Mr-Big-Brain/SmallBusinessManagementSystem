package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
public class Vartotojas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String vardas;
    @Column
    private String pavarde;
    @Column
    private String telefonas;
    @Column
    private String apibrezimas;
    @Column
    private String prisijungimoVardas;
    @Column
    private String slaptazodis;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private VartotojoTipas vartotojoTipas;

    public Vartotojas() {
    }

    public Vartotojas(String vardas, String pavarde, String telefonas, String apibrezimas, String prisijungimoVardas, String slaptazodis, VartotojoTipas vartotojoTipas) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.telefonas = telefonas;
        this.apibrezimas = apibrezimas;
        this.prisijungimoVardas = prisijungimoVardas;
        this.slaptazodis = slaptazodis;
        this.vartotojoTipas = vartotojoTipas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrisijungimoVardas() {
        return prisijungimoVardas;
    }

    public void setPrisijungimoVardas(String prisijungimoVardas) {
        this.prisijungimoVardas = prisijungimoVardas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getTelefonas() {
        return telefonas;
    }

    public void setTelefonas(String telefonas) {
        this.telefonas = telefonas;
    }

    public String getApibrezimas() {
        return apibrezimas;
    }

    public void setApibrezimas(String apibrezimas) {
        this.apibrezimas = apibrezimas;
    }

    public VartotojoTipas getVartotojoTipas() {
        return vartotojoTipas;
    }

    public void setVartotojoTipas(VartotojoTipas vartotojoTipas) {
        this.vartotojoTipas = vartotojoTipas;
    }
}
