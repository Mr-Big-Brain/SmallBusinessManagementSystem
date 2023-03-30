package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.persistenceController.VartotojasPersistenceController;

import java.io.Console;
import java.util.List;

public class VartotojasService {
    VartotojasPersistenceController vartotojasPersistenceController;
    public VartotojasService()
    {
        vartotojasPersistenceController = new VartotojasPersistenceController();
    }
    public void createAdminIfNoUsers()
    {
        if(vartotojasPersistenceController.getVartotojasListFromDatabase().isEmpty())
        {
            Vartotojas vartotojas = new Vartotojas("admin","admin");
            vartotojasPersistenceController.create(vartotojas);
        }
    }

    public boolean vartotojasEgzistuoja(String prisijungimoVardas)
    {
        List<Vartotojas> visiVartotojai;
        visiVartotojai = vartotojasPersistenceController.getVartotojasListFromDatabase();
        for(int i=0; i<visiVartotojai.size(); i++)
            if(visiVartotojai.get(i).getPrisijungimoVardas().equals(prisijungimoVardas))
            {
                return true;
            }
        return false;
    }

    public boolean vartotojasEgzistuoja(String prisijungimoVardas, String slaptazodis)
    {
        List<Vartotojas> visiVartotojai;
        visiVartotojai = vartotojasPersistenceController.getVartotojasListFromDatabase();
        for(int i=0; i<visiVartotojai.size(); i++)
            if(visiVartotojai.get(i).getPrisijungimoVardas().equals(prisijungimoVardas) && visiVartotojai.get(i).getSlaptazodis().equals(slaptazodis))
            {
                return true;
            }
        AllertBox.display("Klaida", "Neteisingas vartotojo vardas arba slaptažodis");
        return false;
    }

    public void keistiVartotojoPrisijungima(String senasPrisijungimoVardas, String senasSlaptazodis, String naujasPrisijungimoVardas, String naujasSlaptazodis)
    {
        Vartotojas vartotojas = getVartotojasById(senasPrisijungimoVardas, senasSlaptazodis);
        if(!naujasPrisijungimoVardas.isEmpty() && !naujasSlaptazodis.isEmpty())
        {
            vartotojas.setPrisijungimoVardas(naujasPrisijungimoVardas);
            vartotojas.setSlaptazodis(naujasSlaptazodis);
        }

        vartotojasPersistenceController.update(vartotojas);
    }
    private Vartotojas getVartotojasById(String prisijungimoVardas, String slaptazodis)
    {
        List<Vartotojas> visiVartotojai;
        visiVartotojai = vartotojasPersistenceController.getVartotojasListFromDatabase();
        for(int i=0; i<visiVartotojai.size(); i++)
            if(visiVartotojai.get(i).getPrisijungimoVardas().equals(prisijungimoVardas) && visiVartotojai.get(i).getSlaptazodis().equals(slaptazodis))
            {
                return visiVartotojai.get(i);
            }
        return null;
    }
}
