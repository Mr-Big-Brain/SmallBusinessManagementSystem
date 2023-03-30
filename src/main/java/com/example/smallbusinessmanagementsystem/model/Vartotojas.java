package com.example.smallbusinessmanagementsystem.model;

import javax.persistence.*;

@Entity
public class Vartotojas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String prisijungimoVardas;
    @Column
    private String slaptazodis;
    public Vartotojas() {
    }
    public Vartotojas(String prisijungimoVardas, String slaptazodis) {
        this.prisijungimoVardas = prisijungimoVardas;
        this.slaptazodis = slaptazodis;
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
}
