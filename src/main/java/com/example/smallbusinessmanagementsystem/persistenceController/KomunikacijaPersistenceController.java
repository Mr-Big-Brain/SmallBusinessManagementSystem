package com.example.smallbusinessmanagementsystem.persistenceController;

import com.example.smallbusinessmanagementsystem.model.Finansas;
import com.example.smallbusinessmanagementsystem.model.Klientas;
import com.example.smallbusinessmanagementsystem.model.Komunikacija;
import com.example.smallbusinessmanagementsystem.utilities.FinansoTipas;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class KomunikacijaPersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public KomunikacijaPersistenceController() //removed void
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public void create(Komunikacija komunikacija)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(komunikacija);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Komunikacija nesukurta, klaida");
            e.printStackTrace();
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
    public void update(Komunikacija komunikacija) {
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            komunikacija = entityManager.merge(komunikacija);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public List<Komunikacija> getKomunikacijaListFromDatabase(){
        EntityManager  entityManager = getEntityManager();
        try {
            CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
            query.select(query.from(Komunikacija.class));
            Query q = entityManager.createQuery(query);

            return q.getResultList();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
        return null;
    }
    public Komunikacija getKomunikacijaById(int id) {
        EntityManager entityManager = null;
        Komunikacija komunikacija = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            komunikacija = entityManager.getReference(Komunikacija.class, id);
            komunikacija.getId();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Komunikacija su tokiu ID neegzistuoja");
        }
        return komunikacija;
    }
    public List<Komunikacija> getKomunijacijosByKlientas(Klientas klientas) {
        List<Komunikacija> komunikacijos = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT k FROM Komunikacija k WHERE k.klientas = :klientas";
            TypedQuery<Komunikacija> query = entityManager.createQuery(jpql, Komunikacija.class);
            query.setParameter("klientas", klientas);
            komunikacijos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return komunikacijos;
    }
    public void delete(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Komunikacija komunikacija = null;
            try {
                komunikacija = entityManager.getReference(Komunikacija.class, id);
                komunikacija.getId();
            } catch (Exception e) {
                System.out.println("Komunikacija su tokiu ID neegzistuoja");
            }
            entityManager.remove(komunikacija);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
