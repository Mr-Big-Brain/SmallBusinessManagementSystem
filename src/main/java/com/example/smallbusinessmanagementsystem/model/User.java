package com.example.smallbusinessmanagementsystem.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String prisijungimoVardas;
    @Column
    private String slaptazodis;
    public User() {
    }
    public User(String prisijungimoVardas, String slaptazodis) {
        this.prisijungimoVardas = prisijungimoVardas;
        this.slaptazodis = slaptazodis;
    }
}
