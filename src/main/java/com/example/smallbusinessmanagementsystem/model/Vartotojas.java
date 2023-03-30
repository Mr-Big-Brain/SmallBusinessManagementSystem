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
}
