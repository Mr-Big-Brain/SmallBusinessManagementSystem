package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.persistenceController.VartotojasPersistenceController;
import com.example.smallbusinessmanagementsystem.persistenceController.VartotojoTipasPersistenceController;

import java.util.List;

public class VartotojasService {
    VartotojasPersistenceController vartotojasPersistenceController;
    VartotojoTipasPersistenceController vartotojoTipasPersistenceController;
    public VartotojasService()
    {
        vartotojasPersistenceController = new VartotojasPersistenceController();
        vartotojoTipasPersistenceController = new VartotojoTipasPersistenceController();
    }
    public VartotojoTipas rastiAdministratoriausVartotojoTipa()
    {
        List<VartotojoTipas> visiVartotojuTipai;
        VartotojoTipas vartotojoTipas = null;
        visiVartotojuTipai = vartotojoTipasPersistenceController.getVartotojoTipasListFromDatabase();
        for(int i=0; i<visiVartotojuTipai.size(); i++) {
            vartotojoTipas = visiVartotojuTipai.get(i);
            if (vartotojoTipas.getFinansai() && vartotojoTipas.getKlientai() &&
                    vartotojoTipas.getKonfiguracija() && vartotojoTipas.getPardavimai() &&
                    vartotojoTipas.getSandelis() && vartotojoTipas.getStatistika())
            {
                return vartotojoTipas;
            }
        }
        return null;
    }
    public void createAdminIfNoUsers()
    {
        if(vartotojasPersistenceController.getVartotojasListFromDatabase().isEmpty())
        {
            VartotojoTipas vartotojoTipas = new VartotojoTipas("Administratorius", true,true,true,true,true,true);
            vartotojoTipasPersistenceController.create(vartotojoTipas);

            Vartotojas vartotojas = new Vartotojas("Vardas","Pavarde","Telefonas","Apibrėžimas","admin","admin",vartotojoTipas);
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
