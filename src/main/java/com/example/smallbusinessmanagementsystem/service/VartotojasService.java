package com.example.smallbusinessmanagementsystem.service;

import com.example.smallbusinessmanagementsystem.AllertBox;
import com.example.smallbusinessmanagementsystem.model.Vartotojas;
import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;
import com.example.smallbusinessmanagementsystem.persistenceController.VartotojasPersistenceController;
import com.example.smallbusinessmanagementsystem.persistenceController.VartotojoTipasPersistenceController;
import com.example.smallbusinessmanagementsystem.utilities.Md5Converter;

import java.util.List;
import java.util.Objects;

public class VartotojasService {
    VartotojasPersistenceController vartotojasPersistenceController;
    VartotojoTipasPersistenceController vartotojoTipasPersistenceController;
    Md5Converter md5Converter;
    public VartotojasService()
    {
        vartotojasPersistenceController = new VartotojasPersistenceController();
        vartotojoTipasPersistenceController = new VartotojoTipasPersistenceController();
        md5Converter = new Md5Converter();
    }
    public boolean validateVartotojoTipas(Vartotojas vartotojas)
    {
        if(vartotojas.getVartotojoTipas() == null)
        {
            AllertBox.display("Klaida", "Nepasirinktas vartotojo tipas");
            return false;
        }
        return true;
    }
    public boolean validateEmptyStrings(Vartotojas vartotojas)
    {
        if(Objects.equals(vartotojas.getVardas(), "") || Objects.equals(vartotojas.getPavarde(), "")|| Objects.equals(vartotojas.getTelefonas(), "") || Objects.equals(vartotojas.getPrisijungimoVardas(), ""))
        {
            AllertBox.display("Klaida", "Vardo, pavardės, prisijungimo vardo, arba telefono laukai neužpildyti");
            return false;
        }
        return true;
    }
    public boolean validateUniquePrisijungimoVardas(Vartotojas vartotojas)
    {
        if(prisijungimoVardasEgzistuoja(vartotojas.getPrisijungimoVardas()))
        {
            AllertBox.display("Klaida", "Toks vartotojo vardas jau egzistuoja");
            return false;
        }
        return true;
    }
    public boolean tryCreateVartotojas(String vardas, String pavarde, String telefonas, String apibrezimas, String prisijungimoVardas, String slaptazodis, VartotojoTipas vartotojoTipas)
    {
        Vartotojas vartotojas = new Vartotojas(vardas,pavarde,telefonas,apibrezimas,prisijungimoVardas,slaptazodis,vartotojoTipas);

        if(validateVartotojoTipas(vartotojas) && validateUniquePrisijungimoVardas(vartotojas) && validateEmptyStrings(vartotojas))
        {
            vartotojasPersistenceController.create(vartotojas);
            return true;
        }
        return false;
    }
    public boolean tryUpdateVartotojas(Vartotojas newVartotojas, Vartotojas oldVartotojas)
    {
        if(validateEmptyStrings(newVartotojas) && validateVartotojoTipas(newVartotojas))
        {
            if(Objects.equals(newVartotojas.getPrisijungimoVardas(), oldVartotojas.getPrisijungimoVardas()) || validateUniquePrisijungimoVardas(newVartotojas))
            {
                vartotojasPersistenceController.update(newVartotojas);
                return true;
            }
            return false;
        }
        return false;
    }
    public boolean tryDeleteVartotojas(int id)
    {
        vartotojasPersistenceController.delete(id);
        return true;
    }
    public VartotojoTipas rastiAdministratoriausVartotojoTipa()
    {
        List<VartotojoTipas> visiVartotojuTipai;
        VartotojoTipas vartotojoTipas = null;
        visiVartotojuTipai = vartotojoTipasPersistenceController.getVartotojoTipasListFromDatabase();
        for(int i=0; i<visiVartotojuTipai.size(); i++) {
            vartotojoTipas = visiVartotojuTipai.get(i);
            if (vartotojoTipas.getFinansai() && vartotojoTipas.getKlientai() &&
                    vartotojoTipas.getKonfiguracija() && vartotojoTipas.getPardavimai() &&
                    vartotojoTipas.getSandelis() && vartotojoTipas.getStatistika())
            {
                return vartotojoTipas;
            }
        }
        return null;
    }
    public void createAdminIfNoUsers()
    {
        if(vartotojasPersistenceController.getVartotojasListFromDatabase().isEmpty())
        {
            VartotojoTipas vartotojoTipas = new VartotojoTipas("Administratorius", true,true,true,true,true,true);
            vartotojoTipasPersistenceController.create(vartotojoTipas);

            Vartotojas vartotojas = new Vartotojas("Vardas","Pavarde","Telefonas","Apibrėžimas","admin",md5Converter.getMD5Hash("admin"), vartotojoTipas);
            vartotojasPersistenceController.create(vartotojas);


        }
    }

    public boolean prisijungimoVardasEgzistuoja(String prisijungimoVardas)
    {
        List<Vartotojas> visiVartotojai;
        visiVartotojai = vartotojasPersistenceController.getVartotojasListFromDatabase();
        for(int i=0; i<visiVartotojai.size(); i++)
            if(visiVartotojai.get(i).getPrisijungimoVardas().equals(prisijungimoVardas))
            {
                return true;
            }
        return false;
    }

    public boolean prisijungimasEgzistuoja(String prisijungimoVardas, String slaptazodis)
    {
        List<Vartotojas> visiVartotojai;
        visiVartotojai = vartotojasPersistenceController.getVartotojasListFromDatabase();
        for(int i=0; i<visiVartotojai.size(); i++)
            if(visiVartotojai.get(i).getPrisijungimoVardas().equals(prisijungimoVardas) && visiVartotojai.get(i).getSlaptazodis().equals(slaptazodis))
            {
                return true;
            }
        AllertBox.display("Klaida", "Neteisingas vartotojo vardas arba slaptažodis");
        return false;
    }

    public void keistiVartotojoPrisijungima(String senasPrisijungimoVardas, String senasSlaptazodis, String naujasPrisijungimoVardas, String naujasSlaptazodis)
    {
        Vartotojas vartotojas = getVartotojasByPrisijungimasSlaptazodis(senasPrisijungimoVardas, senasSlaptazodis);
        if(!naujasPrisijungimoVardas.isEmpty() && !naujasSlaptazodis.isEmpty())
        {
            vartotojas.setPrisijungimoVardas(naujasPrisijungimoVardas);
            vartotojas.setSlaptazodis(naujasSlaptazodis);
        }

        vartotojasPersistenceController.update(vartotojas);
    }
    public boolean vartotojaiTuriRole(int rolesId)
    {
        List<Vartotojas> vartotojai = vartotojasPersistenceController.getVartotojasListFromDatabase();
        for(int i=0;i<vartotojai.size();i++)
        {
            if(vartotojai.get(i).getVartotojoTipas().getId()==rolesId)
            {
                return true;
            }
        }
        return false;
    }
    public Vartotojas getVartotojasByPrisijungimasSlaptazodis(String prisijungimoVardas, String slaptazodis)
    {
        List<Vartotojas> visiVartotojai;
        visiVartotojai = vartotojasPersistenceController.getVartotojasListFromDatabase();
        for(int i=0; i<visiVartotojai.size(); i++)
            if(visiVartotojai.get(i).getPrisijungimoVardas().equals(prisijungimoVardas) && visiVartotojai.get(i).getSlaptazodis().equals(slaptazodis))
            {
                return visiVartotojai.get(i);
            }
        return null;
    }
    public Vartotojas getVartotojasByPrisijungimoVardas(String prisijungimoVardas)
    {
        List<Vartotojas> vartotojai = vartotojasPersistenceController.getVartotojasListFromDatabase();
        for(int i=0;i<vartotojai.size();i++)
        {
            if(Objects.equals(vartotojai.get(i).getPrisijungimoVardas(), prisijungimoVardas))
            {
                return vartotojai.get(i);
            }
        }
        return null;
    }
    public List<Vartotojas> getAllVartotojas()
    {
        return vartotojasPersistenceController.getVartotojasListFromDatabase();
    }
    public Vartotojas getVartotojasById(int id)
    {
        return vartotojasPersistenceController.getVartotojasById(id);
    }
}
