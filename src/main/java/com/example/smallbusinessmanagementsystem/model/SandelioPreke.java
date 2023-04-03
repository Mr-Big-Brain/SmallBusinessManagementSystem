package com.example.smallbusinessmanagementsystem.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
public class SandelioPreke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int kiekis;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Produktas produktas;
}
