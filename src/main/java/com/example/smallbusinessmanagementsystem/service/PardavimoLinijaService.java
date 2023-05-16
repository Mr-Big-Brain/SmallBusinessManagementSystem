package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.model.Pardavimas;
import com.example.smallbusinessmanagementsystem.model.PardavimoLinija;
import com.example.smallbusinessmanagementsystem.persistenceController.PardavimoLinijaPersistenceController;

import java.util.ArrayList;
import java.util.List;

public class PardavimoLinijaService {
    PardavimoLinijaPersistenceController pardavimoLinijaPersistenceController;
    SandelioPrekeService sandelioPrekeService;
    public PardavimoLinijaService()
    {
        sandelioPrekeService = new SandelioPrekeService();
        pardavimoLinijaPersistenceController = new PardavimoLinijaPersistenceController();
    }
    public boolean tryCreatePardavimoLinija(PardavimoLinija pardavimoLinija)
    {
        if(sandelioPrekeService.tryDecreaseSandelioPreke(pardavimoLinija.getProduktas(),pardavimoLinija.getKiekis()))
        {
            pardavimoLinijaPersistenceController.create(pardavimoLinija);
            return true;
        }
        return false;
    }
    public boolean tryDeletePardavimoLinija(int id)
    {
        PardavimoLinija pardavimoLinijaTrinimui = pardavimoLinijaPersistenceController.getPardavimoLinijaById(id);
        sandelioPrekeService.tryIncreaseSandelioPreke(pardavimoLinijaTrinimui.getProduktas(),pardavimoLinijaTrinimui.getKiekis());
        pardavimoLinijaPersistenceController.delete((id));
        return true;
    }
    public void deleteAllPardavimoPardavimoLinijas(Pardavimas pardavimas)
    {
        List<PardavimoLinija> pardavimoLinijos = pardavimoLinijaPersistenceController.getPardavimoLinijaListFromDatabase();
        if(pardavimoLinijos!=null && !pardavimoLinijos.isEmpty())
        {
            for(int i=0;i<pardavimoLinijos.size();i++)
            {
                if(pardavimoLinijos.get(i).getPardavimas().getId()==pardavimas.getId())
                {
                    tryDeletePardavimoLinija(pardavimoLinijos.get(i).getId());
                }
            }
        }
    }
    public double getPardavimoSuma(Integer pardavimoId)
    {
        return pardavimoLinijaPersistenceController.getPardavimoSuma(pardavimoId);
    }
    public List<PardavimoLinija> getVisosPardavimoLinijos()
    {
        return pardavimoLinijaPersistenceController.getPardavimoLinijaListFromDatabase();
    }
    public List<PardavimoLinija> getPardavimoLinijosByPardavimas(int pardavimoId)
    {
        List<PardavimoLinija> visosPardavimoLinijos = getVisosPardavimoLinijos();
        List<PardavimoLinija> pardavimoPardavimoLinijos = new ArrayList<>();
        if(visosPardavimoLinijos!=null && !visosPardavimoLinijos.isEmpty())
        {
            for(int i=0;i<visosPardavimoLinijos.size();i++)
            {
                if(visosPardavimoLinijos.get(i).getPardavimas().getId()==pardavimoId)
                {
                    pardavimoPardavimoLinijos.add(visosPardavimoLinijos.get(i));
                }
            }
        }
        return pardavimoPardavimoLinijos;
    }
}
