package com.example.smallbusinessmanagementsystem.statistika;

import java.util.Date;

public class StatistikosElementas {
    private double kiekis;
    private String pavadinimas;
    private Date data;

    public StatistikosElementas() {
    }

    public StatistikosElementas(double kiekis, String pavadinimas, Date data) {
        this.kiekis = kiekis;
        this.pavadinimas = pavadinimas;
        this.data = data;
    }

    public double getKiekis() {
        return kiekis;
    }

    public void setKiekis(double kiekis) {
        this.kiekis = kiekis;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StatistikosElementas{" +
                "kiekis=" + kiekis +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", data=" + data +
                '}';
    }
}
