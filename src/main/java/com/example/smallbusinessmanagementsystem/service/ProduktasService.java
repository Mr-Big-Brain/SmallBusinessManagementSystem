package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.persistenceController.ProduktasPersistenceController;

public class ProduktasService {
    ProduktasPersistenceController produktasPersistenceController;
    public ProduktasService()
    {
        produktasPersistenceController = new ProduktasPersistenceController();
    }
    public boolean tryCreateProduktas()
    {
        return true;
    }
    public boolean tryUpdateProduktas()
    {
        return true;
    }
    public boolean tryDeleteProduktas()
    {
        return true;
    }
}
