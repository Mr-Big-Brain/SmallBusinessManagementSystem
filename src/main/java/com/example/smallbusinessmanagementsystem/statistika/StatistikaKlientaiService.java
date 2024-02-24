package com.example.smallbusinessmanagementsystem.statistika;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.service.KlientasService;

import java.time.LocalDate;
import java.util.List;

public class StatistikaKlientaiService {
    KlientasService klientasService;
    StatistikaKlientaiPersistenceController statistikaKlientaiPersistenceController;
    public StatistikaKlientaiService()
    {
        klientasService = new KlientasService();
        statistikaKlientaiPersistenceController = new StatistikaKlientaiPersistenceController();
    }

    public List<StatistikosElementas> getFaivouriteProducts(Klientas klientas, LocalDate nuo, LocalDate iki){

        if(validateInput(klientas, nuo, iki)) {
            return statistikaKlientaiPersistenceController.getFavouriteProducts(klientas.getId(), nuo, iki);
        }
        else
            return null;
    }
    public List<StatistikosElementas> getFaivouriteZymes(Klientas klientas, LocalDate nuo, LocalDate iki){

        if(validateInput(klientas, nuo, iki)) {
            return statistikaKlientaiPersistenceController.getFavouriteZymes(klientas.getId(), nuo, iki);
        }
        else
            return null;
    }
    public boolean validateInput(Klientas klientas, LocalDate nuo, LocalDate iki) {
        if(nuo == null || iki == null)
        {
            AllertBox.display("Klaida", "Reikia nurodyti datas");
            return false;
        }
        if(klientas == null)
        {
            AllertBox.display("Klaida", "Nepasirinkote kliento");
            return false;
        }
        return true;
    }
}
