package com.example.smallbusinessmanagementsystem.statistika;

public class StatistikosElementas {
    private double kiekis;
    private String pavadinimas;

    public StatistikosElementas() {
    }

    public StatistikosElementas(double kiekis, String pavadinimas) {
        this.kiekis = kiekis;
        this.pavadinimas = pavadinimas;
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
}
