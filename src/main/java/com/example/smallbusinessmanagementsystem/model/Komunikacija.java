package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
public class Komunikacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String pavadinimas;
    @Column
    private String apibrezimas;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Produktas produktas;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Klientas klientas;
}
