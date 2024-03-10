package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.model.Pardavimas;
import com.example.smallbusinessmanagementsystem.model.PardavimoLinija;
import com.example.smallbusinessmanagementsystem.persistenceController.PardavimasPersistenceController;
import com.example.smallbusinessmanagementsystem.persistenceController.PardavimoLinijaPersistenceController;

import java.util.ArrayList;
import java.util.List;

public class PardavimoLinijaService {
    PardavimoLinijaPersistenceController pardavimoLinijaPersistenceController;
    SandelioPrekeService sandelioPrekeService;
    PardavimasPersistenceController pardavimasPersistenceController;
    public PardavimoLinijaService()
    {
        sandelioPrekeService = new SandelioPrekeService();
        pardavimoLinijaPersistenceController = new PardavimoLinijaPersistenceController();
        pardavimasPersistenceController = new PardavimasPersistenceController();
    }
    public boolean tryCreatePardavimoLinija(PardavimoLinija pardavimoLinija)
    {
        if(sandelioPrekeService.tryDecreaseSandelioPreke(pardavimoLinija.getProduktas(),pardavimoLinija.getKiekis(), pardavimoLinija.getPirkimoKaina()))
        {
            pardavimoLinijaPersistenceController.create(pardavimoLinija);
            return true;
        }
        return false;
    }
    public boolean tryCreatePardavimoLinijos(List<PardavimoLinija> pardavimoLinijos, int pardavimoId)
    {
        for(int i=0;i<pardavimoLinijos.size();i++)
        {
            pardavimoLinijos.get(i).setPardavimas(pardavimasPersistenceController.getPardavimasById(pardavimoId));
            pardavimoLinijos.get(i).setId(0);
            pardavimoLinijaPersistenceController.create(pardavimoLinijos.get(i));
        }
        return true;
    }
    public boolean tryDeletePardavimoLinija(int id)
    {
        PardavimoLinija pardavimoLinijaTrinimui = pardavimoLinijaPersistenceController.getPardavimoLinijaById(id);
        sandelioPrekeService.tryIncreaseSandelioPreke(pardavimoLinijaTrinimui.getProduktas(),pardavimoLinijaTrinimui.getKiekis(),pardavimoLinijaTrinimui.getPirkimoKaina());
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
        return pardavimoLinijaPersistenceController.getPardavimoLinijosByPardavimas(pardavimoId);
    }
}
