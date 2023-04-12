package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Produktas;
import com.example.smallbusinessmanagementsystem.persistenceController.ProduktasPersistenceController;

import java.util.Objects;

public class ProduktasService {
    ProduktasPersistenceController produktasPersistenceController;
    public ProduktasService()
    {
        produktasPersistenceController = new ProduktasPersistenceController();
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
}
