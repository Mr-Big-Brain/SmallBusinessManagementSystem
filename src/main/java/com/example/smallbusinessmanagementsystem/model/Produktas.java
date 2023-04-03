package com.example.smallbusinessmanagementsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Produktas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String pavadinimas;
    @Column
    private double pirkimoKaina;
    @Column
    private double rekomenduojamaKaina;
    @ManyToMany
    private List<Zyme> zymes;
}
