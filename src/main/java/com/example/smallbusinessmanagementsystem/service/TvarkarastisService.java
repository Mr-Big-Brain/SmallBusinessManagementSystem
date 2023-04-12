package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.persistenceController.TvarkarastisPersistenceController;

public class TvarkarastisService {
    TvarkarastisPersistenceController tvarkarastisPersistenceController;
    public TvarkarastisService()
    {
        tvarkarastisPersistenceController = new TvarkarastisPersistenceController();
    }
    public boolean tryCreateTvarkarastis()
    {
        return true;
    }
    public boolean tryUpdateTvarkarastis()
    {
        return true;
    }
    public boolean tryDeleteTvarkarastis()
    {
        return true;
    }
}
