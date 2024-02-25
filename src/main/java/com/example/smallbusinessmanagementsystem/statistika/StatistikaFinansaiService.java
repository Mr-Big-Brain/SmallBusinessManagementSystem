package com.example.smallbusinessmanagementsystem.statistika;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.service.KlientasService;
import com.example.smallbusinessmanagementsystem.service.ZymeService;
import com.example.smallbusinessmanagementsystem.utilities.FinansoTipas;

import java.time.LocalDate;
import java.util.List;

public class StatistikaFinansaiService {
    ZymeService zymeService;
    StatistikaFinansaiPersistenceController statistikaFinansaiPersistenceController;
    public StatistikaFinansaiService()
    {
        zymeService = new ZymeService();
        statistikaFinansaiPersistenceController = new StatistikaFinansaiPersistenceController();
    }
    public StatistikosElementas getFinansoZymesStatistika(Zyme zyme, LocalDate nuo, LocalDate iki, FinansoTipas finansoTipas){

        if(validateInput(zyme, nuo, iki)) {
            return statistikaFinansaiPersistenceController.getFinansoZymesStatistika(zyme.getId(), nuo, iki,finansoTipas);
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
            AllertBox.display("Klaida", "Nepasirinkote finansų žymių");
            return false;
        }
        return true;
    }
}
