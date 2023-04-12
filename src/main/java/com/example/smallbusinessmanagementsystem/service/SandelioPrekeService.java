package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.persistenceController.SandelioPrekePersistenceController;

public class SandelioPrekeService {
    SandelioPrekePersistenceController sandelioPrekePersistenceController;
    public SandelioPrekeService()
    {
        sandelioPrekePersistenceController = new SandelioPrekePersistenceController();
    }
    public boolean tryCreateSandelioPreke()
    {
        return true;
    }
    public boolean tryUpdateSandelioPreke()
    {
        return true;
    }
    public boolean tryDeleteSandelioPreke()
    {
        return true;
    }
}
