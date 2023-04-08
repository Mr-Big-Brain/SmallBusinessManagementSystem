package com.example.smallbusinessmanagementsystem.persistenceController;

import com.example.smallbusinessmanagementsystem.model.SandelioPreke;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class SandelioPrekePersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public SandelioPrekePersistenceController() //removed void
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public void create(SandelioPreke sandelioPreke)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(sandelioPreke);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Sandelio preke nesukurta, klaida");
            e.printStackTrace();
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
    public void update(SandelioPreke sandelioPreke) {
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            sandelioPreke = entityManager.merge(sandelioPreke);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public List<SandelioPreke> getSandelioPrekeListFromDatabase(){
        EntityManager  entityManager = getEntityManager();
        try {
            CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
            query.select(query.from(SandelioPreke.class));
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
    public SandelioPreke getSandelioPrekeById(int id) {
        EntityManager entityManager = null;
        SandelioPreke sandelioPreke = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            sandelioPreke = entityManager.getReference(SandelioPreke.class, id);
            sandelioPreke.getId();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Sandelio preke su tokiu ID neegzistuoja");
        }
        return sandelioPreke;
    }
    public void delete(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            SandelioPreke sandelioPreke = null;
            try {
                sandelioPreke = entityManager.getReference(SandelioPreke.class, id);
                sandelioPreke.getId();
            } catch (Exception e) {
                System.out.println("Sandelio preke su tokiu ID neegzistuoja");
            }
            entityManager.remove(sandelioPreke);
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
