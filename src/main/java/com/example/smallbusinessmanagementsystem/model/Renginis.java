package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Renginis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String pavadinimas;
    @Column
    private String aprasymas;
    @Column
    private LocalDateTime dataNuo;
    @Column
    private LocalDateTime dataIki;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Vartotojas kasSukure;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Vartotojas kamSukure;
}
