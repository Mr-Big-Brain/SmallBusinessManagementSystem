package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.model.SandelioPreke;
import com.example.smallbusinessmanagementsystem.persistenceController.SandelioPrekePersistenceController;

import java.util.List;

public class SandelioPrekeService {
    SandelioPrekePersistenceController sandelioPrekePersistenceController;
    public SandelioPrekeService()
    {
        sandelioPrekePersistenceController = new SandelioPrekePersistenceController();
    }
    public boolean tryCreateSandelioPreke(SandelioPreke sandelioPreke)
    {
        if(sandelioPreke.getProduktas()!=null && getSandelioPrekeByProduktas(sandelioPreke.getProduktas().getId())==null)
        {
            sandelioPrekePersistenceController.create(sandelioPreke);
        }
        return false;
    }
    public boolean tryIncreaseSandelioPreke(Produktas produktas, int kiekis)
    {
        if(getSandelioPrekeByProduktas(produktas.getId())!=null)
        {
            SandelioPreke sandelioPreke = getSandelioPrekeByProduktas(produktas.getId());
            sandelioPreke.setKiekis(sandelioPreke.getKiekis()+kiekis);
            sandelioPrekePersistenceController.update(sandelioPreke);
        }
        else
        {
            tryCreateSandelioPreke(new SandelioPreke(kiekis, produktas));
        }
        return true;
    }
    public boolean tryDecreaseSandelioPreke(Produktas produktas, int kiekis)
    {
        if(getSandelioPrekeByProduktas(produktas.getId())!=null)
        {
            SandelioPreke sandelioPreke = getSandelioPrekeByProduktas(produktas.getId());
            sandelioPreke.setKiekis(sandelioPreke.getKiekis()-kiekis);
            if(sandelioPreke.getKiekis()<0)
            {
                return false;
            }
            else
            {
                sandelioPrekePersistenceController.update(sandelioPreke);
                return true;
            }
        }
        else
        {
            AllertBox.display("Klaida","Prekės nėra sandelyje");
            return false;
        }
    }
    public boolean tryDeleteSandelioPreke(SandelioPreke sandelioPreke)
    {
        if(sandelioPreke.getKiekis()==0)
        {
            sandelioPrekePersistenceController.delete(sandelioPreke.getId());
            return true;
        }
        return false;
    }
    public List<SandelioPreke> getAllSandelioPrekes()
    {
        return sandelioPrekePersistenceController.getSandelioPrekeListFromDatabase();
    }
    public SandelioPreke getSandelioPrekeByProduktas(int produktasId)
    {
        List<SandelioPreke> visosSandelioPrekes = getAllSandelioPrekes();
        if(!visosSandelioPrekes.isEmpty())
        {
            for(int i=0;i<visosSandelioPrekes.size();i++)
            {
                if(visosSandelioPrekes.get(i).getProduktas().getId()==produktasId)
                {
                    return visosSandelioPrekes.get(i);
                }
            }
            return null;
        }
        else
        {
            return null;
        }
    }


}
