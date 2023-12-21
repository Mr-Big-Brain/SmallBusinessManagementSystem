package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Finansas;
import com.example.smallbusinessmanagementsystem.persistenceController.FinansasPersistenceController;
import com.example.smallbusinessmanagementsystem.utilities.FinansoTipas;

import java.time.LocalDate;
import java.util.List;

public class FinansasService {
    FinansasPersistenceController finansasPersistenceController;
    public FinansasService()
    {
        finansasPersistenceController = new FinansasPersistenceController();
    }
    public boolean tryCreateFinansas(Finansas finansas)
    {
        if(validatePavadinimas(finansas.getPavadinimas()) && validateKiekis(finansas.getKiekis()) && validateData(finansas.getData()) && validateFinansoTipas(finansas.getTipas()))
        {
            finansasPersistenceController.create(finansas);
            return true;
        }
        return false;
    }
    public boolean tryUpdateFinansas(Finansas finansas)
    {
        if(validatePavadinimas(finansas.getPavadinimas()) && validateKiekis(finansas.getKiekis()) && validateData(finansas.getData()) && validateFinansoTipas(finansas.getTipas()))
        {
            finansasPersistenceController.update(finansas);
            return true;
        }
        return false;
    }
    public boolean tryDeleteFinansas(int id)
    {
        finansasPersistenceController.delete(id);
        return true;
    }
    public List<Finansas> getAllFinanasai()
    {
        return finansasPersistenceController.getFinansasListFromDatabase();
    }
    public List<Finansas> getAllByTipas(FinansoTipas finansoTipas)
    {
        return finansasPersistenceController.getFinansasListByFinansoTipas(finansoTipas);
    }
    private boolean validatePavadinimas(String pavadinimas)
    {
        if(pavadinimas.isEmpty())
        {
            AllertBox.display("Klaida","Pavadinimas nenurodytas");
            return false;
        }
        return true;
    }
    private boolean validateKiekis(double kiekis)
    {
        if(kiekis==0)
        {
            AllertBox.display("Klaida", "Kiekis negali buti nulinis");
            return false;
        }
        if(kiekis<0)
        {
            AllertBox.display("Klaida", "Kiekis negali buti neigiamas. Naudokite finanso tipus");
            return false;
        }
        return true;
    }
    private boolean validateData(LocalDate data)
    {
        if(data == null)
        {
            AllertBox.display("Klaida","Nenurodyta data");
            return false;
        }
        return true;
    }
    private boolean validateFinansoTipas(FinansoTipas finansoTipas)
    {
        if(finansoTipas == null)
        {
            AllertBox.display("Klaida","Nenurodytas finanso tipas");
            return false;
        }
        return true;
    }

}
