package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.persistenceController.ZymePersistenceController;

public class ZymeService {
    ZymePersistenceController zymePersistenceController;
    public ZymeService()
    {
        zymePersistenceController = new ZymePersistenceController();
    }
    public boolean tryCreateZyme()
    {
        return true;
    }
    public boolean tryUpdateZyme()
    {
        return true;
    }
    public boolean tryDeleteZyme()
    {
        return true;
    }
}
