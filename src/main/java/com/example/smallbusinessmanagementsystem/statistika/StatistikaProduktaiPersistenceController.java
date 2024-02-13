package com.example.smallbusinessmanagementsystem.statistika;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatistikaProduktaiPersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public StatistikaProduktaiPersistenceController()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public List<StatistikosElementas> getProductSalesSumsByDays(int produktoId, LocalDate nuo, LocalDate iki)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            String sql = "select SUM(pl.kainaUzViena * pl.kiekis), DATE(pa.data) from pardavimas pa INNER JOIN pardavimolinija pl ON pa.id = pl.pardavimas_id INNER JOIN produktas pr ON pr.id = pl.produktas_id where pr.id = :produktoId AND pa.data BETWEEN :nuo AND :iki GROUP by DATE(pa.data)";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("produktoId", produktoId);
            query.setParameter("nuo", nuo);
            query.setParameter("iki", iki);

            List<Object[]> resultList = query.getResultList();
            List<StatistikosElementas> statistikosElementasList = new ArrayList<>();

            for (Object[] result : resultList) {
                double kiekis = (Double) result[0];
                Date data = (Date) result[1];
                StatistikosElementas statistikosElementas = new StatistikosElementas(kiekis, "", data);
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
