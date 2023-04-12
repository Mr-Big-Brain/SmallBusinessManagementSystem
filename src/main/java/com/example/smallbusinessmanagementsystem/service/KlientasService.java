package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.persistenceController.KlientasPersistenceController;

public class KlientasService {
    KlientasPersistenceController klientasPersistenceController;
    public KlientasService()
    {
        klientasPersistenceController = new KlientasPersistenceController();
    }
    public boolean tryCreateKlientas()
    {
        return true;
    }
    public boolean tryUpdateKlientas()
    {
        return true;
    }
    public boolean tryDeleteKlientas()
    {
        return true;
    }
}
