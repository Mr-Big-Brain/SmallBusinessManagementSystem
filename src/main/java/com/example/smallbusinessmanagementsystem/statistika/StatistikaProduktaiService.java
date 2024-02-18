package com.example.smallbusinessmanagementsystem.statistika;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Pardavimas;
import com.example.smallbusinessmanagementsystem.model.PardavimoLinija;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.service.PardavimasService;
import com.example.smallbusinessmanagementsystem.service.PardavimoLinijaService;
import com.example.smallbusinessmanagementsystem.utilities.WindowLoader;
import com.example.smallbusinessmanagementsystem.utilities.WindowManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StatistikaProduktaiService {
    private List<PardavimoLinija> pardavimoLinijos;
    private List<Produktas> produktai;

    PardavimoLinijaService pardavimoLinijaService;
    PardavimasService pardavimasService;
    StatistikaProduktaiPersistenceController statistikaProduktaiPersistenceController;

    public StatistikaProduktaiService()
    {
        pardavimasService = new PardavimasService();
        pardavimoLinijaService = new PardavimoLinijaService();
        pardavimoLinijos = pardavimoLinijaService.getVisosPardavimoLinijos();
        statistikaProduktaiPersistenceController = new StatistikaProduktaiPersistenceController();
    }

    public List<StatistikosElementas> getProduktoPardavimuSumos(Produktas produktas, LocalDate nuo, LocalDate iki)
    {
        if(validateInput(produktas, nuo, iki)) {
            return statistikaProduktaiPersistenceController.getProductSalesSumsByDays(produktas.getId(), nuo, iki);
        }
        else
            return null;
    }
    public List<StatistikosElementas> getProduktoPardavimuPelnai(Produktas produktas, LocalDate nuo, LocalDate iki){

        if(validateInput(produktas, nuo, iki)) {
            return statistikaProduktaiPersistenceController.getProductSalesProfitsByDays(produktas.getId(), nuo, iki);
        }
        else
            return null;
    }
    public List<StatistikosElementas> getProduktoPardavimuKiekiai(Produktas produktas, LocalDate nuo, LocalDate iki){

        if(validateInput(produktas, nuo, iki)) {
            return statistikaProduktaiPersistenceController.getProductSalesCountsByDays(produktas.getId(), nuo, iki);
        }
        else
            return null;
    }


    public boolean validateInput(Produktas produktas, LocalDate nuo, LocalDate iki) {
        if(nuo == null || iki == null)
        {
            AllertBox.display("Klaida", "Reikia nurodyti datas");
            return false;
        }
        if(produktas == null)
        {
            AllertBox.display("Klaida", "Nepasirinkote produktų");
            return false;
        }
        return true;
    }
}
