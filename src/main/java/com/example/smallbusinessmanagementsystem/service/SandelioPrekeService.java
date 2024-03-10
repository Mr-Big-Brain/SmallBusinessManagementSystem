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
        if(sandelioPreke.getProduktas()!=null && getSandelioPrekeByProduktasIrPirkimoKaina(sandelioPreke.getProduktas().getId(), sandelioPreke.getPirkimoKaina())==null)
        {
            sandelioPrekePersistenceController.create(sandelioPreke);
        }
        return false;
    }
    public boolean tryIncreaseSandelioPreke(Produktas produktas, int kiekis, double pirkimoKaina)
    {
        if(getSandelioPrekeByProduktasIrPirkimoKaina(produktas.getId(), pirkimoKaina)!=null)
        {
            SandelioPreke sandelioPreke = getSandelioPrekeByProduktasIrPirkimoKaina(produktas.getId(), pirkimoKaina);
            sandelioPreke.setKiekis(sandelioPreke.getKiekis()+kiekis);
            sandelioPrekePersistenceController.update(sandelioPreke);
        }
        else
        {
            tryCreateSandelioPreke(new SandelioPreke(kiekis, produktas, pirkimoKaina));
        }
        return true;
    }
    public boolean tryDecreaseSandelioPreke(Produktas produktas, int kiekis, double pirkimoKaina)
    {
        if(getSandelioPrekeByProduktasIrPirkimoKaina(produktas.getId(), pirkimoKaina)!=null)
        {
            SandelioPreke sandelioPreke = getSandelioPrekeByProduktasIrPirkimoKaina(produktas.getId(), pirkimoKaina);
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
    public SandelioPreke getSandelioPrekeByProduktasIrPirkimoKaina(int produktasId, double pirkimoKaina)
    {
        List<SandelioPreke> visosSandelioPrekes = getAllSandelioPrekes();
        if(!visosSandelioPrekes.isEmpty())
        {
            for(int i=0;i<visosSandelioPrekes.size();i++)
            {
                if(visosSandelioPrekes.get(i).getProduktas().getId()==produktasId && visosSandelioPrekes.get(i).getPirkimoKaina()==pirkimoKaina)
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
    public boolean canBeDecreased(Produktas produktas, Integer kiekis, double pirkimoKaina)
    {
        SandelioPreke sandelioPreke = getSandelioPrekeByProduktasIrPirkimoKaina(produktas.getId(), pirkimoKaina);
        if(sandelioPreke!=null && sandelioPreke.getKiekis()>=kiekis)
        {
            return true;
        }
        return false;
    }
    public int getProduktoBendrasKiekisSandelyje(Produktas produktas)
    {
        List<SandelioPreke> visosSandelioPrekes = getAllSandelioPrekes();
        if(!visosSandelioPrekes.isEmpty())
        {
            int sum = 0;
            for(int i=0;i<visosSandelioPrekes.size();i++)
            {
                if(visosSandelioPrekes.get(i).getProduktas().getId()==produktas.getId())
                {
                    sum+=visosSandelioPrekes.get(i).getKiekis();
                }
            }
            return sum;
        }
        else
        {
            return 0;
        }
    }


}
