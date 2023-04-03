package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.persistenceController.VartotojoTipasPersistenceController;

import java.util.Objects;

public class VartotojoTipasService {

    VartotojoTipasPersistenceController vartotojoTipasPersistenceController;

    public VartotojoTipasService()
    {
        vartotojoTipasPersistenceController = new VartotojoTipasPersistenceController();
    }
    public void sukurtiNaujaVartotojoTipa(String pavadinimas, boolean finansai, boolean klientai, boolean konfiguracija, boolean pardavimai, boolean sandelis, boolean statistika)
    {
        if(Objects.equals(pavadinimas, ""))
        {
            AllertBox.display("Klaida","Jus pamiršote pridėti rolės pavadinimą");
        }
        else
        {
            VartotojoTipas vartotojoTipas=new VartotojoTipas(pavadinimas,pardavimai,sandelis,klientai,konfiguracija,finansai,statistika);
            vartotojoTipasPersistenceController.create(vartotojoTipas);
            AllertBox.display("Pavyko","Nauja darbuotojo rolė sukurta");
        }

    }
    public void istrintiVartotojoTipa(int id)
    {
        vartotojoTipasPersistenceController.delete(id);
    }
}
