package com.example.smallbusinessmanagementsystem.statistika;

import com.example.smallbusinessmanagementsystem.model.Pardavimas;
import com.example.smallbusinessmanagementsystem.model.PardavimoLinija;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.service.PardavimasService;
import com.example.smallbusinessmanagementsystem.service.PardavimoLinijaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StatistikaProduktaiService {
    private List<PardavimoLinija> pardavimoLinijos;
    private List<Produktas> produktai;

    PardavimoLinijaService pardavimoLinijaService;
    PardavimasService pardavimasService;

    public StatistikaProduktaiService()
    {
        pardavimasService = new PardavimasService();
        pardavimoLinijaService = new PardavimoLinijaService();
        pardavimoLinijos = pardavimoLinijaService.getVisosPardavimoLinijos();
    }
    public List<StatistikosElementas> getProduktuKiekiai(List<Produktas> produktaiList,LocalDate nuo, LocalDate iki)
    {
        List<StatistikosElementas> statistikosElementai = new ArrayList<>();
        StatistikosElementas tempStatistikosElementas = new StatistikosElementas();
        for(int i=0;i<produktaiList.size();i++)
        {
            tempStatistikosElementas = new StatistikosElementas(getProduktoPardavimuSuma(produktaiList.get(i),nuo,iki),produktaiList.get(i).getPavadinimas());
            statistikosElementai.add(tempStatistikosElementas);
        }
        return statistikosElementai;
    }
    public double getProduktoPardavimuSuma(Produktas produktas, LocalDate nuo, LocalDate iki)
    {
        double sum = 0;
        Pardavimas linijosPardavimas;
        for(int i=0;i<pardavimoLinijos.size();i++)
        {
            linijosPardavimas = pardavimoLinijos.get(i).getPardavimas();
            if(pardavimoLinijos.get(i).getProduktas().getId() == produktas.getId() && linijosPardavimas.getData().isAfter(nuo.atStartOfDay()) && linijosPardavimas.getData().isBefore(iki.atStartOfDay()))
            {
                sum += ((pardavimoLinijos.get(i).getKiekis() * pardavimoLinijos.get(i).getKainaUzViena()) - (pardavimoLinijos.get(i).getKiekis()*pardavimoLinijos.get(i).getProduktas().getPirkimoKaina()));
            }
        }
        return sum;
    }
}
