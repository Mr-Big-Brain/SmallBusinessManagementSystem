package com.example.smallbusinessmanagementsystem.model;

import com.example.smallbusinessmanagementsystem.utilities.ZymesTipas;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zyme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String pavadinimas;
    @Column
    private ZymesTipas tipas;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    private List<Finansas> finansai;
    @ManyToMany
    private List<Produktas> produktai;
}
