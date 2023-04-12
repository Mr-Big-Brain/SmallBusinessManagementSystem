package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.persistenceController.PardavimasPersistenceController;

public class PardavimasService {
    PardavimasPersistenceController pardavimasPersistenceController;
    public PardavimasService()
    {
        pardavimasPersistenceController = new PardavimasPersistenceController();
    }
    public boolean tryCreatePardavimas()
    {
        return true;
    }
    public boolean tryUpdatePardavimas()
    {
        return true;
    }
    public boolean tryDeletePardavimas()
    {
        return true;
    }
}
