package com.example.smallbusinessmanagementsystem.statistika;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatistikaKlientaiPersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public StatistikaKlientaiPersistenceController()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public List<StatistikosElementas> getFavouriteProducts(int klientoId, LocalDate nuo, LocalDate iki)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            String sql = "select CONCAT(pr.id, ' ', pr.pavadinimas), SUM(pl.kiekis) from klientas k INNER JOIN pardavimas pa ON k.id = pa.klientas_id INNER JOIN pardavimolinija pl ON pl.pardavimas_id = pa.id INNER JOIN produktas pr ON pl.produktas_id = pr.id WHERE k.id = :klientoId AND pa.data BETWEEN :nuo AND :iki GROUP BY pr.id";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("klientoId", klientoId);
            query.setParameter("nuo", nuo);
            query.setParameter("iki", iki);

            List<Object[]> resultList = query.getResultList();
            List<StatistikosElementas> statistikosElementasList = new ArrayList<>();

            for (Object[] result : resultList) {
                String produktoPavadinimas = (String) result[0];
                double kiekis = ((BigDecimal) result[1]).doubleValue();
                StatistikosElementas statistikosElementas = new StatistikosElementas(kiekis, produktoPavadinimas, null);
                statistikosElementasList.add(statistikosElementas);
            }

            return statistikosElementasList;
        } catch (Exception e)
        {
            System.out.println("Statistika nesurinkta, klaida");
            e.printStackTrace();
            return null;
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
    public List<StatistikosElementas> getFavouriteZymes(int klientoId, LocalDate nuo, LocalDate iki)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            String sql = "select z.pavadinimas, SUM(pl.kiekis) from klientas k INNER JOIN pardavimas pa ON k.id = pa.klientas_id INNER JOIN pardavimolinija pl ON pl.pardavimas_id = pa.id INNER JOIN produktas pr ON pl.produktas_id = pr.id INNER JOIN produktas_zyme pz on pz.Produktas_id = pr.id INNER JOIN zyme z on z.id = pz.zymes_id WHERE k.id = :klientoId AND pa.data BETWEEN :nuo AND :iki GROUP BY z.id";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("klientoId", klientoId);
            query.setParameter("nuo", nuo);
            query.setParameter("iki", iki);

            List<Object[]> resultList = query.getResultList();
            List<StatistikosElementas> statistikosElementasList = new ArrayList<>();

            for (Object[] result : resultList) {
                String produktoPavadinimas = (String) result[0];
                double kiekis = ((BigDecimal) result[1]).doubleValue();
                StatistikosElementas statistikosElementas = new StatistikosElementas(kiekis, produktoPavadinimas, null);
                statistikosElementasList.add(statistikosElementas);
            }

            return statistikosElementasList;
        } catch (Exception e)
        {
            System.out.println("Statistika nesurinkta, klaida");
            e.printStackTrace();
            return null;
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
}
