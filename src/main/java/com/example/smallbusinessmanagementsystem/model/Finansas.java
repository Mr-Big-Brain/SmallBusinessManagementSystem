package com.example.smallbusinessmanagementsystem.model;

import com.example.smallbusinessmanagementsystem.utilities.FinansoTipas;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Finansas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private FinansoTipas tipas;
    @Column
    private int kiekis;
    @Column
    private String pavadinimas;
    @Column
    private String apibudinimas;
    @Column
    private LocalDate data;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    private List<Zyme> zymes;
    @ManyToOne
    private Vartotojas vartotojas;
}
