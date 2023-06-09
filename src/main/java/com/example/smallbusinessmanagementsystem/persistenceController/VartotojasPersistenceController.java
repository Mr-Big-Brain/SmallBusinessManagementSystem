package com.example.smallbusinessmanagementsystem.persistenceController;

import com.example.smallbusinessmanagementsystem.model.Vartotojas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class VartotojasPersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public VartotojasPersistenceController() //removed void
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public void create(Vartotojas vartotojas)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(vartotojas);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Vartotojas nesukurtas, klaida");
            e.printStackTrace();
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
    public void update(Vartotojas vartotojas) {
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            vartotojas = entityManager.merge(vartotojas);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public List<Vartotojas> getVartotojasListFromDatabase(){
        EntityManager  entityManager = getEntityManager();
        try {
            CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
            query.select(query.from(Vartotojas.class));
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
    public Vartotojas getVartotojasById(int id) {
        EntityManager entityManager = null;
        Vartotojas vartotojas = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            vartotojas = entityManager.getReference(Vartotojas.class, id);
            vartotojas.getId();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Vartotojas su tokiu ID neegzistuoja");
        }
        return vartotojas;
    }
    public void delete(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Vartotojas vartotojas = null;
            try {
                vartotojas = entityManager.getReference(Vartotojas.class, id);
                vartotojas.getId();
            } catch (Exception e) {
                System.out.println("Vartotojas su tokiu ID neegzistuoja");
            }
            entityManager.remove(vartotojas);
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
