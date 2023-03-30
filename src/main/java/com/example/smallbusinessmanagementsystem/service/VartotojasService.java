package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.persistenceController.VartotojasPersistenceController;

public class VartotojasService {
    VartotojasPersistenceController vartotojasPersistenceController;
    public VartotojasService()
    {
        vartotojasPersistenceController = new VartotojasPersistenceController();
    }
    public void createAdminIfNoUsers()
    {
        if(vartotojasPersistenceController.getVartotojasListFromDatabase().isEmpty())
        {
            Vartotojas vartotojas = new Vartotojas("admin","admin");
            vartotojasPersistenceController.create(vartotojas);
        }
    }
}
