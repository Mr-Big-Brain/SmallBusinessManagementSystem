package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Tvarkarastis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private LocalDateTime dataNuo;
    @Column
    private LocalDateTime dataIki;
    @Column
    private String pavadinimas;
    @Column
    private String aprasymas;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Vartotojas kasSukure;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Vartotojas kamSukure;
}
