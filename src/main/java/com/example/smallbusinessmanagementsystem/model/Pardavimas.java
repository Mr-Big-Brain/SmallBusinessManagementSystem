package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pardavimas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private LocalDateTime data;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Vartotojas pardavejas;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Klientas klientas;
}
