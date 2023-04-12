package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.persistenceController.PardavimoLinijaPersistenceController;

public class PardavimoLinijaService {
    PardavimoLinijaPersistenceController pardavimoLinijaPersistenceController;
    public PardavimoLinijaService()
    {
        pardavimoLinijaPersistenceController = new PardavimoLinijaPersistenceController();
    }
    public boolean tryCreatePardavimoLinija()
    {
        return true;
    }
    public boolean tryUpdatePardavimoLinija()
    {
        return true;
    }
    public boolean tryDeletePardavimoLinija()
    {
        return true;
    }
}
