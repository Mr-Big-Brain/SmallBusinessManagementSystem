package com.example.smallbusinessmanagementsystem.persistenceController;

import com.example.smallbusinessmanagementsystem.model.Klientas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class KlientasPersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public KlientasPersistenceController() //removed void
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public void create(Klientas klientas)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(klientas);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Klientas nesukurtas, klaida");
            e.printStackTrace();
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
    public void update(Klientas klientas) {
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            klientas = entityManager.merge(klientas);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public List<Klientas> getKlientasListFromDatabase(){
        EntityManager  entityManager = getEntityManager();
        try {
            CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
            query.select(query.from(Klientas.class));
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
    public Klientas getKlientasById(int id) {
        EntityManager entityManager = null;
        Klientas klientas = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            klientas = entityManager.getReference(Klientas.class, id);
            klientas.getId();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Klientas su tokiu ID neegzistuoja");
        }
        return klientas;
    }
    public void delete(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Klientas klientas = null;
            try {
                klientas = entityManager.getReference(Klientas.class, id);
                klientas.getId();
            } catch (Exception e) {
                System.out.println("Klientas su tokiu ID neegzistuoja");
            }
            entityManager.remove(klientas);
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
