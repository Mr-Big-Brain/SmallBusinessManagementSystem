package com.example.smallbusinessmanagementsystem.statistika;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StatistikaZymesPersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public StatistikaZymesPersistenceController()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public void getKiekiai()
    {
//        select SUM(pl.kiekis), DATE(pa.data)
//        from pardavimas pa
//        INNER JOIN pardavimolinija pl ON pa.id = pl.pardavimas_id
//        INNER JOIN produktas pr ON pr.id = pl.produktas_id
//        INNER JOIN produktas_zyme pz ON pz.Produktas_id = pr.id
//        INNER JOIN zyme zy on zy.id = pz.zymes_id
//        where zy.id = 3
//        AND pa.data BETWEEN "2024-02-01" AND "2024-02-29" GROUP by zy.id, DATE(pa.data)
    }

    public void getPardavimuSumos()
    {
//        select SUM(pl.kainaUzViena * pl.kiekis), DATE(pa.data)
//        from pardavimas pa
//        INNER JOIN pardavimolinija pl ON pa.id = pl.pardavimas_id
//        INNER JOIN produktas pr ON pr.id = pl.produktas_id
//        INNER JOIN produktas_zyme pz ON pz.Produktas_id = pr.id
//        INNER JOIN zyme zy on zy.id = pz.zymes_id
//        where zy.id = 3
//        AND pa.data BETWEEN "2024-02-01" AND "2024-02-29" GROUP by zy.id, DATE(pa.data)
    }

    public void getPardavimuPelnas()
    {
//        select SUM((pl.kainaUzViena - pr.pirkimoKaina) * pl.kiekis), DATE(pa.data)
//        from pardavimas pa
//        INNER JOIN pardavimolinija pl ON pa.id = pl.pardavimas_id
//        INNER JOIN produktas pr ON pr.id = pl.produktas_id
//        INNER JOIN produktas_zyme pz ON pz.Produktas_id = pr.id
//        INNER JOIN zyme zy on zy.id = pz.zymes_id
//        where zy.id = 3
//        AND pa.data BETWEEN "2024-02-01" AND "2024-02-29" GROUP by zy.id, DATE(pa.data)
    }
}
