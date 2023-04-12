package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.persistenceController.KomunikacijaPersistenceController;

public class KomunikacijaService {
    KomunikacijaPersistenceController komunikacijaPersistenceController;
    public KomunikacijaService()
    {
        komunikacijaPersistenceController = new KomunikacijaPersistenceController();
    }
    public boolean tryCreateKomunikacija()
    {
        return true;
    }
    public boolean tryUpdateKomunikacija()
    {
        return true;
    }
    public boolean tryDeleteKomunikacija()
    {
        return true;
    }
}
