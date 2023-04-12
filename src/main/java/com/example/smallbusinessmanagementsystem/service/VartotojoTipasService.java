package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.persistenceController.VartotojoTipasPersistenceController;

import java.util.List;
import java.util.Objects;

public class VartotojoTipasService {

    VartotojoTipasPersistenceController vartotojoTipasPersistenceController;
    VartotojasService vartotojasService;

    public VartotojoTipasService()
    {
        vartotojoTipasPersistenceController = new VartotojoTipasPersistenceController();
        vartotojasService = new VartotojasService();
    }
    public boolean tryCreateVartotojoTipa(String pavadinimas, boolean finansai, boolean klientai, boolean konfiguracija, boolean pardavimai, boolean sandelis, boolean statistika)
    {
        VartotojoTipas vartotojoTipas = new VartotojoTipas(pavadinimas,pardavimai,sandelis,klientai,konfiguracija,finansai,statistika);
        if(validateUniqueRolesPavadinimas(vartotojoTipas) && validateEmptyStrings(vartotojoTipas))
        {
            vartotojoTipasPersistenceController.create(vartotojoTipas);
            return true;
        }
        return false;
    }
    public boolean tryUpdateVartotojoTipa(VartotojoTipas newVartotojoTipas, VartotojoTipas oldVartotojoTipas)
    {
        if(validateEmptyStrings(newVartotojoTipas))
        {
            if(Objects.equals(newVartotojoTipas.getPavadinimas(), oldVartotojoTipas.getPavadinimas()) || validateUniqueRolesPavadinimas(newVartotojoTipas))
            {
                vartotojoTipasPersistenceController.update(newVartotojoTipas);;
                return true;
            }
            return false;
        }
        return false;

    }
    public boolean tryDeleteVartotojoTipa(int id)
    {
        if(vartotojasService.vartotojaiTuriRole(id))
        {
            AllertBox.display("Klaida", "Vartotojo rolė priskirta bent vienam vartotojui");
            return false;
        }
        else
        {
            vartotojoTipasPersistenceController.delete(id);
            return true;
        }
    }
    public boolean validateUniqueRolesPavadinimas(VartotojoTipas vartotojoTipas)
    {
        if(vartotojoTipoPavadinimasEgzistuoja(vartotojoTipas.getPavadinimas()))
        {
            AllertBox.display("Klaida","Toks rolės pavadinimas jau egzistuoja");
            return false;
        }
        return true;
    }
    public boolean validateEmptyStrings(VartotojoTipas vartotojoTipas)
    {
        if(Objects.equals(vartotojoTipas.getPavadinimas(), ""))
        {
            AllertBox.display("Klaida","Jus pamiršote pridėti rolės pavadinimą");
            return false;
        }
        return true;
    }
    public boolean vartotojoTipoPavadinimasEgzistuoja(String pavadinimas)
    {
        List<VartotojoTipas> visiVartotojoTipai;
        visiVartotojoTipai = vartotojoTipasPersistenceController.getVartotojoTipasListFromDatabase();
        for(int i=0; i<visiVartotojoTipai.size(); i++)
            if(visiVartotojoTipai.get(i).getPavadinimas().equals(pavadinimas))
            {
                return true;
            }
        return false;
    }
}
