package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.model.Zyme;
import com.example.smallbusinessmanagementsystem.persistenceController.ProduktasPersistenceController;
import com.example.smallbusinessmanagementsystem.persistenceController.ZymePersistenceController;

import java.util.List;
import java.util.Objects;

public class ProduktasService {
    ProduktasPersistenceController produktasPersistenceController;
    ZymePersistenceController zymePersistenceController;
    public ProduktasService()
    {
        produktasPersistenceController = new ProduktasPersistenceController();
        zymePersistenceController = new ZymePersistenceController();
    }
    public boolean tryCreateProduktas(String pavadinimas, String apibrezimas, Double pirkimoKaina, Double rekomenduojamaKaina)
    {
        Produktas produktas = new Produktas(pavadinimas,apibrezimas,pirkimoKaina,rekomenduojamaKaina);
        if(validateEmptyValues(produktas) && validateNegativeValues(produktas))
        {
            produktasPersistenceController.create(produktas);
            return true;
        }
        return false;
    }
    public boolean tryUpdateProduktas(Produktas newProduktas, Produktas oldProduktas)
    {
        if(validateEmptyValues(newProduktas) && validateNegativeValues(newProduktas))
        {
            produktasPersistenceController.update(newProduktas);
            return true;
        }
        return false;
    }
    public boolean tryDeleteProduktas(int id)
    {
        produktasPersistenceController.delete(id);
        return true;
    }
    public boolean addZyme(Produktas produktas, int zymeID)
    {
        Zyme zyme = zymePersistenceController.getZymeById(zymeID);
        produktas.addZyme(zyme);
        return tryUpdateProduktas(produktas, produktas);
    }
    public boolean removeZyme(Produktas produktas, int zymeID)
    {
        produktas.removeZyme(zymeID);
        return tryUpdateProduktas(produktas,produktas);
    }
    private boolean validateEmptyValues(Produktas produktas)
    {
        if(Objects.equals(produktas.getPavadinimas(), ""))
        {
            AllertBox.display("Klaida", "Visi laukai privalo būti užpildyti");
            return false;
        }
        return true;
    }
    private boolean validateNegativeValues(Produktas produktas)
    {
        if(produktas.getPirkimoKaina()<0||produktas.getRekomenduojamaKaina()<0)
        {
            AllertBox.display("Klaida","Neigiamos kainos nepriimtinos");
            return false;
        }
        return true;
    }
    public List<Produktas> getAllProduktai()
    {
        return produktasPersistenceController.getProduktasListFromDatabase();
    }
    public Produktas getProduktasById(int id)
    {
        return produktasPersistenceController.getProduktasById(id);
    }
}
