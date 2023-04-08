package com.example.smallbusinessmanagementsystem.persistenceController;

import com.example.smallbusinessmanagementsystem.model.Produktas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProduktasPersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public ProduktasPersistenceController() //removed void
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public void create(Produktas produktas)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(produktas);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Produktas nesukurtas, klaida");
            e.printStackTrace();
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
    public void update(Produktas produktas) {
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            produktas = entityManager.merge(produktas);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public List<Produktas> getProduktasListFromDatabase(){
        EntityManager  entityManager = getEntityManager();
        try {
            CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
            query.select(query.from(Produktas.class));
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
    public Produktas getProduktasById(int id) {
        EntityManager entityManager = null;
        Produktas produktas = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            produktas = entityManager.getReference(Produktas.class, id);
            produktas.getId();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Produktas su tokiu ID neegzistuoja");
        }
        return produktas;
    }
    public void delete(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Produktas produktas = null;
            try {
                produktas = entityManager.getReference(Produktas.class, id);
                produktas.getId();
            } catch (Exception e) {
                System.out.println("Produktas su tokiu ID neegzistuoja");
            }
            entityManager.remove(produktas);
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
