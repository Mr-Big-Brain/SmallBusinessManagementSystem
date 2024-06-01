package com.example.smallbusinessmanagementsystem.statistika;

import com.example.smallbusinessmanagementsystem.service.ZymeService;
import com.example.smallbusinessmanagementsystem.utilities.FinansoTipas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StatistikaFinansaiPersistenceController {
    private EntityManagerFactory entityManagerFactory;
    ZymeService zymeService;
    public StatistikaFinansaiPersistenceController()
    {
        zymeService = new ZymeService();
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public StatistikosElementas getFinansoZymesStatistika(int zymeId, LocalDate nuo, LocalDate iki, FinansoTipas finansoTipas)
    {
        EntityManager entityManager = null;

        int finanansoTipasDB = 0;
        if(finansoTipas == FinansoTipas.IŠLAIDOS)
            finanansoTipasDB = 1;

        try {
            entityManager = getEntityManager();
            String sql = "SELECT SUM(fi.kiekis), zi.pavadinimas from finansas fi INNER JOIN finansas_zyme fz on fi.id = fz.Finansas_id INNER JOIN zyme zi on fz.zymes_id = zi.id WHERE fi.data BETWEEN :nuo AND :iki AND fi.tipas = :finanansoTipasDB AND fi.finansoStatusas = 0 AND zi.id = :zymeId GROUP BY zi.id";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("zymeId", zymeId);
            query.setParameter("nuo", nuo);
            query.setParameter("iki", iki);
            query.setParameter("finanansoTipasDB", finanansoTipasDB);

            List<Object[]> resultList = query.getResultList();
            StatistikosElementas statistikosElementas = new StatistikosElementas();

            String zymesPavadinimas = zymeService.getZymeById(zymeId).getPavadinimas();

            if(resultList.size()==0)
            {
                return new StatistikosElementas(0, zymeService.getZymeById(zymeId).getPavadinimas(), null);
            }
            for (Object[] result : resultList) {
                double kiekis = (Double) result[0];
                zymesPavadinimas = (String) result[1];
                statistikosElementas = new StatistikosElementas(kiekis, zymesPavadinimas, null);
            }
            return statistikosElementas;
        } catch (Exception e)
        {
            System.out.println("Statistika nesurinkta, klaida");
            e.printStackTrace();
            return new StatistikosElementas(0, zymeService.getZymeById(zymeId).getPavadinimas(), null);
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
}
