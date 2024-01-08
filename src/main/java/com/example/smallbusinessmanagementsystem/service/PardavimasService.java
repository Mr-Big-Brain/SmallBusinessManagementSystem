package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.model.Pardavimas;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.persistenceController.PardavimasPersistenceController;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;

public class PardavimasService {
    PardavimasPersistenceController pardavimasPersistenceController;
    PardavimoLinijaService pardavimoLinijaService;
    public PardavimasService()
    {
        pardavimasPersistenceController = new PardavimasPersistenceController();
        pardavimoLinijaService = new PardavimoLinijaService();
    }
    public boolean tryCreatePardavimas(Pardavimas pardavimas)
    {
        pardavimasPersistenceController.create(pardavimas);
        return true;
    }
    public boolean tryUpdatePardavimas(Pardavimas pardavimas)
    {
        pardavimasPersistenceController.update(pardavimas);
        return true;
    }
    public boolean tryDeletePardavimas(Integer id)
    {
        pardavimoLinijaService.deleteAllPardavimoPardavimoLinijas(getPardavimasById(id));
        pardavimasPersistenceController.delete(id);
        return true;
    }
    public Pardavimas getNewestUserPardavimas(Vartotojas vartotojas)
    {
        List<Pardavimas> visiPardavimai = pardavimasPersistenceController.getPardavimasListFromDatabase();
        int maxId=0;
        for(int i=0;i<visiPardavimai.size();i++)
        {
            if(visiPardavimai.get(i).getPardavejas().getId()==vartotojas.getId())
            {
                if(visiPardavimai.get(i).getId()>maxId)
                {
                    maxId = visiPardavimai.get(i).getId();
                }
            }
        }
        if(maxId!=0)
        {
            return pardavimasPersistenceController.getPardavimasById(maxId);
        }
        else
        {
            return null;
        }

    }
    public List<Pardavimas> getAllPardavimai()
    {
        return pardavimasPersistenceController.getPardavimasListFromDatabase();
    }
    public List<Pardavimas> getAllPardavimai(LocalDate nuo, LocalDate iki)
    {
        List<Pardavimas> visiPardavimai = getAllPardavimai();

        if(visiPardavimai!=null&&!visiPardavimai.isEmpty())
        {
            for(int i=visiPardavimai.size()-1;i>=0;i--)
            {
                if(nuo!=null && visiPardavimai.get(i).getData().toLocalDate().isBefore(nuo))
                {
                    visiPardavimai.remove(i);
                }
                else if(iki!=null && visiPardavimai.get(i).getData().toLocalDate().isAfter(iki))
                {
                    visiPardavimai.remove(i);
                }
            }
        }
        return visiPardavimai;
    }
    public Pardavimas getPardavimasById(int id)
    {
        return pardavimasPersistenceController.getPardavimasById(id);
    }
}
