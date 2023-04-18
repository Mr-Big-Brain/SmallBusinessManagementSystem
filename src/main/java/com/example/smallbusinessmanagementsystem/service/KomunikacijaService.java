package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Komunikacija;
import com.example.smallbusinessmanagementsystem.persistenceController.KomunikacijaPersistenceController;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class KomunikacijaService {
    KomunikacijaPersistenceController komunikacijaPersistenceController;
    public KomunikacijaService()
    {
        komunikacijaPersistenceController = new KomunikacijaPersistenceController();
    }
    public boolean tryCreateKomunikacija(Komunikacija komunikacija)
    {
        if(validateEmptyFields(komunikacija) && validateDate(komunikacija))
        {
            komunikacijaPersistenceController.create(komunikacija);
            return true;
        }
        return false;
    }
    public boolean tryUpdateKomunikacija(Komunikacija komunikacija)
    {
        if(validateEmptyFields(komunikacija) && validateDate(komunikacija))
        {
            komunikacijaPersistenceController.update(komunikacija);
            return true;
        }
        return false;
    }
    public boolean tryDeleteKomunikacija(int id)
    {
        komunikacijaPersistenceController.delete(id);
        return true;
    }
    public List<Komunikacija> getAllKomunikacijos()
    {
        return komunikacijaPersistenceController.getKomunikacijaListFromDatabase();
    }
    private boolean validateEmptyFields(Komunikacija komunikacija)
    {
        if(komunikacija.getData() == null || Objects.equals(komunikacija.getPavadinimas(), ""))
        {
            AllertBox.display("Klaida", "Nenurodyta data, arba komunikacijos pavadinimas");
            return false;
        }
        return true;
    }
    private boolean validateDate(Komunikacija komunikacija)
    {
        if(komunikacija.getData().isAfter(LocalDate.now()))
        {
            AllertBox.display("Klaida", "Nurodyta data ateityje");
            return false;
        }
        return true;
    }
}
