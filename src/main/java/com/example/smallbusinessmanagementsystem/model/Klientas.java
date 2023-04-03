package com.example.smallbusinessmanagementsystem.model;

import javax.persistence.*;

@Entity
public class Klientas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String vardas;
    @Column
    private String pavarde;
    @Column
    private String imone;
    @Column
    private String telefonas;
    @Column
    private String pastas;
}
