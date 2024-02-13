package com.example.smallbusinessmanagementsystem.statistika;

import java.util.List;

public class StatistikosVienetas {
    private List<StatistikosElementas> statistikosElementasList;

    private String pavadinimas;

    public StatistikosVienetas(List<StatistikosElementas> statistikosElementasList, String pavadinimas) {
        this.statistikosElementasList = statistikosElementasList;
        this.pavadinimas = pavadinimas;
    }

    public List<StatistikosElementas> getStatistikosElementasList() {
        return statistikosElementasList;
    }

    public void setStatistikosElementasList(List<StatistikosElementas> statistikosElementasList) {
        this.statistikosElementasList = statistikosElementasList;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }
}
