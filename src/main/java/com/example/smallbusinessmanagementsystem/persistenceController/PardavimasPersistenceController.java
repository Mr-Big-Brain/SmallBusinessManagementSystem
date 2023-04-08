package com.example.smallbusinessmanagementsystem.persistenceController;

import com.example.smallbusinessmanagementsystem.model.Pardavimas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PardavimasPersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public PardavimasPersistenceController() //removed void
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public void create(Pardavimas pardavimas)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(pardavimas);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Pardavimas nesukurtas, klaida");
            e.printStackTrace();
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
    public void update(Pardavimas pardavimas) {
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            pardavimas = entityManager.merge(pardavimas);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public List<Pardavimas> getPardavimasListFromDatabase(){
        EntityManager  entityManager = getEntityManager();
        try {
            CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
            query.select(query.from(Pardavimas.class));
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
    public Pardavimas getPardavimasById(int id) {
        EntityManager entityManager = null;
        Pardavimas pardavimas = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            pardavimas = entityManager.getReference(Pardavimas.class, id);
            pardavimas.getId();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Pardavimas su tokiu ID neegzistuoja");
        }
        return pardavimas;
    }
    public void delete(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Pardavimas pardavimas = null;
            try {
                pardavimas = entityManager.getReference(Pardavimas.class, id);
                pardavimas.getId();
            } catch (Exception e) {
                System.out.println("Pardavimas su tokiu ID neegzistuoja");
            }
            entityManager.remove(pardavimas);
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
