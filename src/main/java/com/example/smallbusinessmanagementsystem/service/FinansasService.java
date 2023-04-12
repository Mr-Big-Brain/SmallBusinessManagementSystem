package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.persistenceController.FinansasPersistenceController;

public class FinansasService {
    FinansasPersistenceController finansasPersistenceController;
    public FinansasService()
    {
        finansasPersistenceController = new FinansasPersistenceController();
    }
    public boolean tryCreateFinansas()
    {
        return true;
    }
    public boolean tryUpdateFinansas()
    {
        return true;
    }
    public boolean tryDeleteFinansas()
    {
        return true;
    }
}
