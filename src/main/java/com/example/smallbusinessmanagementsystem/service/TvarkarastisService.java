package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Tvarkarastis;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.persistenceController.TvarkarastisPersistenceController;

import java.time.LocalDate;
import java.util.List;

public class TvarkarastisService {
    TvarkarastisPersistenceController tvarkarastisPersistenceController;
    public TvarkarastisService()
    {
        tvarkarastisPersistenceController = new TvarkarastisPersistenceController();
    }
    public boolean tryCreateTvarkarastis(LocalDate data, String pavadinimas, String aprasymas, Vartotojas kasSukure, Vartotojas kamSukure)
    {
        if(validateEmptyPavadinimas(pavadinimas) && validateEmptyVartotojas(kasSukure) && validateEmptyVartotojas(kamSukure) && validateData(data))
        {
            Tvarkarastis tvarkarastis = new Tvarkarastis(data,pavadinimas,aprasymas,kasSukure,kamSukure);
            tvarkarastisPersistenceController.create(tvarkarastis);
            return true;
        }
        return false;
    }
    public boolean tryUpdateTvarkarastis(Tvarkarastis tvarkarastis)
    {
        if(!validateEmptyPavadinimas(tvarkarastis.getPavadinimas()))
        {
            return false;
        }
        if(!validateData(tvarkarastis.getData()))
        {
            return false;
        }
        if(!validateEmptyVartotojas(tvarkarastis.getKamSukure()))
        {
            return false;
        }
        if(!validateEmptyVartotojas(tvarkarastis.getKasSukure()))
        {
            return false;
        }
        tvarkarastisPersistenceController.update(tvarkarastis);
        return true;
    }
    public boolean tryDeleteTvarkarastis(int id)
    {
        tvarkarastisPersistenceController.delete(id);
        return true;
    }
    public List<Tvarkarastis> getAllTvarkarastis()
    {
        return tvarkarastisPersistenceController.getTvarkarastisListFromDatabase();
    }
    public List<Tvarkarastis> getTvarkarastisByKamSukure(Vartotojas kamSukure)
    {
        List<Tvarkarastis> tvarkarasciai = getAllTvarkarastis();
        if(!tvarkarasciai.isEmpty())
        {
            for(int i = tvarkarasciai.size()-1; i>=0; i--)
            {
                if(tvarkarasciai.get(i).getKamSukure().getId()!=kamSukure.getId())
                {
                    tvarkarasciai.remove(i);
                }
            }
        }
        return tvarkarasciai;
    }
    public List<Tvarkarastis> getTvarkarastisByKasSukure(Vartotojas kasSukure)
    {
        List<Tvarkarastis> tvarkarasciai = getAllTvarkarastis();
        if(!tvarkarasciai.isEmpty())
        {
            for(int i = tvarkarasciai.size()-1; i>=0; i--)
            {
                if(tvarkarasciai.get(i).getKasSukure().getId()!=kasSukure.getId())
                {
                    tvarkarasciai.remove(i);
                }
            }
        }
        return tvarkarasciai;
    }
    private boolean validateEmptyPavadinimas(String pavadinimas)
    {
        if(pavadinimas==null || pavadinimas.equals(""))
        {
            AllertBox.display("Klaida","Pavadinimas nenurodytas");
            return false;
        }
        return true;
    }
    private boolean validateEmptyVartotojas(Vartotojas vartotojas)
    {
        if(vartotojas==null || vartotojas.getId()==0)
        {
            AllertBox.display("Klaida","Nepasirinktas vartotojas");
            return false;
        }
        return true;
    }
    private boolean validateData(LocalDate date)
    {
        if(date == null)
        {
            AllertBox.display("Klaida","Nenurodyta data");
            return false;
        }
        if(date.isBefore(LocalDate.now()))
        {
            AllertBox.display("Klaida","Nurodyta tvarkaraščio data praeityje");
            return false;
        }
        return true;
    }


}
