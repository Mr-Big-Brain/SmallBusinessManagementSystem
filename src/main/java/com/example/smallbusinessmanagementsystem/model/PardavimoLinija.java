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
    private double kainaUzViena;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Produktas produktas;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Pardavimas pardavimas;

}
