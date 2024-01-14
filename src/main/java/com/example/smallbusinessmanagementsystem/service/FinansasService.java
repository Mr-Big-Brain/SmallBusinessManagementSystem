package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Finansas;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.persistenceController.FinansasPersistenceController;
import com.example.smallbusinessmanagementsystem.utilities.FinansoTipas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
        if(finansoTipas == FinansoTipas.VISI)
            return finansasPersistenceController.getFinansasListFromDatabase();
        return finansasPersistenceController.getFinansasListByFinansoTipas(finansoTipas);
    }
    public List<Finansas> getAllFinansaiForTable(FinansoTipas finansoTipas, LocalDate nuo, LocalDate iki, String searchString)
    {
        List<Finansas> finansai= new ArrayList<>(getAllByTipas(finansoTipas));

        if(finansai.isEmpty()) {
            return Collections.emptyList();
        }

        if(nuo!=null)
        {
            for(int i = finansai.size()-1; i>=0; i--)
            {
                if(finansai.get(i).getData().isBefore(nuo))
                {
                    finansai.remove(i);
                }
            }
        }

        if(iki!=null)
        {
            for(int i = finansai.size()-1; i>=0; i--)
            {
                if(finansai.get(i).getData().isAfter(iki))
                {
                    finansai.remove(i);
                }
            }
        }

        Finansas tempFinansas;

        if(!Objects.equals(searchString, ""))
        {
            for(int i = finansai.size()-1; i>=0; i--)
            {

                tempFinansas = finansai.get(i);

                if(!(tempFinansas.getVartotojas().getVardas() + " " + tempFinansas.getVartotojas().getPavarde()).contains(searchString) &&
                        !zymesContainString(tempFinansas, searchString) &&
                        !tempFinansas.getData().toString().contains(searchString) &&
                        !String.valueOf(tempFinansas.getKiekis()).contains(searchString) &&
                        !tempFinansas.getPavadinimas().contains(searchString) &&
                        !tempFinansas.getTipas().toString().contains(searchString) &&
                        !String.valueOf(tempFinansas.getId()).contains(searchString)
                )
                {
                    finansai.remove(i);
                }
            }
        }
       return finansai;
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
    private boolean zymesContainString(Finansas finansas, String searchString)
    {
        List<Zyme> zymes = finansas.getZymes();
        for(int i=0;i<zymes.size();i++)
        {
            if(zymes.get(i).getPavadinimas().contains(searchString))
            {
                return true;
            }
        }
        return false;
    }

}
