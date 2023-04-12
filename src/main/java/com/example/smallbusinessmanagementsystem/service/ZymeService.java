package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.persistenceController.ZymePersistenceController;
import com.example.smallbusinessmanagementsystem.utilities.ZymesTipas;
import java.util.Collections;

import java.util.List;
import java.util.Objects;

public class ZymeService {
    ZymePersistenceController zymePersistenceController;
    public ZymeService()
    {
        zymePersistenceController = new ZymePersistenceController();
    }
    public boolean tryCreateZyme(String pavadinimas, ZymesTipas tipas)
    {
        Zyme zyme = new Zyme(pavadinimas,tipas);
        if(validateEmptyValues(zyme) && validateUnique(zyme))
        {
            zymePersistenceController.create(zyme);
            return true;
        }
        return false;
    }
    public boolean tryUpdateZyme(Zyme oldZyme, Zyme newZyme)
    {
        if(validateEmptyValues(newZyme))
        {
            if(Objects.equals(oldZyme.getPavadinimas(), newZyme.getPavadinimas())||validateUnique(newZyme))
            {
                zymePersistenceController.update(newZyme);
                return true;
            }
            return false;
        }
        return false;
    }
    public boolean tryDeleteZyme(int id)
    {
        zymePersistenceController.delete(id);
        return true;
    }
    private boolean validateEmptyValues(Zyme zyme)
    {
        if(zyme.getTipas()==null || Objects.equals(zyme.getPavadinimas(), ""))
        {
            AllertBox.display("Klaida", "Nenurodytas žymės tipas arba pavadinimas");
            return false;
        }
        return true;
    }
    private boolean validateUnique(Zyme zyme)
    {
        if(pavadinimasEgzistuoja((zyme.getPavadinimas())))
        {
            AllertBox.display("Klaida", "Žymė su tokiu pavadinimu jau egzistuoja");
            return false;
        }
        return true;
    }
    public List<Zyme> getAllZyme()
    {
        return zymePersistenceController.getZymeListFromDatabase();
    }
    public List<Zyme> getAllProduktaiZyme()
    {
        List<Zyme> visosZymes = getAllZyme();
        if(!visosZymes.isEmpty())
        {
            for(int i=visosZymes.size()-1;i>=0;i--)
            {
                if(visosZymes.get(i).getTipas()!=ZymesTipas.PRODUKTAS)
                {
                    visosZymes.remove(i);
                }
            }
            return visosZymes;
        }
        else
        {
            return Collections.emptyList();
        }

    }
    public List<Zyme> getAllFinansaiZyme()
    {
        List<Zyme> visosZymes = getAllZyme();
        if(!visosZymes.isEmpty())
        {
            for(int i=visosZymes.size()-1;i>=0;i--)
            {
                if(visosZymes.get(i).getTipas()!=ZymesTipas.FINANSAS)
                {
                    visosZymes.remove(i);
                }
            }
            return visosZymes;
        }
        else
        {
            return Collections.emptyList();
        }
    }
    private boolean pavadinimasEgzistuoja(String pavadinimas)
    {
        List<Zyme> visosZymes = zymePersistenceController.getZymeListFromDatabase();
        for(int i=0; i<visosZymes.size(); i++)
            if(visosZymes.get(i).getPavadinimas().equals(pavadinimas))
            {
                return true;
            }
        return false;
    }
}
