package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.model.Komunikacija;
import com.example.smallbusinessmanagementsystem.persistenceController.KlientasPersistenceController;

import java.util.Collections;
import java.util.List;

public class KlientasService {
    KlientasPersistenceController klientasPersistenceController;
    KomunikacijaService komunikacijaService;
    public KlientasService()
    {
        klientasPersistenceController = new KlientasPersistenceController();
        komunikacijaService = new KomunikacijaService();
    }
    public boolean tryCreateKlientas(String vardas, String pavarde, String imone, String telefonas, String pastas)
    {
        Klientas klientas = new Klientas(vardas,pavarde,imone,telefonas,pastas);
        klientasPersistenceController.create(klientas);
        return true;
    }
    public boolean tryUpdateKlientas(Klientas klientas)
    {
        klientasPersistenceController.update(klientas);
        return true;
    }
    public boolean tryDeleteKlientas(int id)
    {
        List<Komunikacija> komunikacijos = komunikacijaService.getKomunikacijosByKlientas(getKlientasById(id));
        if(komunikacijos!=null)
        {
            for(int i=komunikacijos.size()-1;i>=0;i--)
            {
                komunikacijaService.tryDeleteKomunikacija(komunikacijos.get(i).getId());
            }
        }
        klientasPersistenceController.delete(id);
        return true;
    }
    public Klientas getKlientasById(int id)
    {
        return klientasPersistenceController.getKlientasById(id);
    }
    public List<Klientas> getAllKlientai()
    {
        return klientasPersistenceController.getKlientasListFromDatabase();
    }
}
