package com.example.smallbusinessmanagementsystem.statistika;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.model.Zyme;

import java.time.LocalDate;
import java.util.List;

public class StatistikaZymesService {
    StatistikaZymesPersistenceController statistikaZymesPersistenceController;
    public StatistikaZymesService()
    {
        statistikaZymesPersistenceController = new StatistikaZymesPersistenceController();
    }
    public List<StatistikosElementas> getZymePardavimuSumos(Zyme zyme, LocalDate nuo, LocalDate iki)
    {
        if(validateInput(zyme, nuo, iki)) {
            return statistikaZymesPersistenceController.getZymeSalesSumsByDays(zyme.getId(), nuo, iki);
        }
        else
            return null;
    }
    public List<StatistikosElementas> getZymePardavimuPelnai(Zyme zyme, LocalDate nuo, LocalDate iki){

        if(validateInput(zyme, nuo, iki)) {
            return statistikaZymesPersistenceController.getZymeSalesProfitsByDays(zyme.getId(), nuo, iki);
        }
        else
            return null;
    }
    public List<StatistikosElementas> getZymePardavimuKiekiai(Zyme zyme, LocalDate nuo, LocalDate iki){

        if(validateInput(zyme, nuo, iki)) {
            return statistikaZymesPersistenceController.getZymeSalesCountsByDays(zyme.getId(), nuo, iki);
        }
        else
            return null;
    }


    public boolean validateInput(Zyme zyme, LocalDate nuo, LocalDate iki) {
        if(nuo == null || iki == null)
        {
            AllertBox.display("Klaida", "Reikia nurodyti datas");
            return false;
        }
        if(zyme == null)
        {
            AllertBox.display("Klaida", "Nepasirinkote produktų");
            return false;
        }
        return true;
    }
}
