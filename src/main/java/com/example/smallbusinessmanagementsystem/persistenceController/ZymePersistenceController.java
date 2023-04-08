package com.example.smallbusinessmanagementsystem.persistenceController;

import com.example.smallbusinessmanagementsystem.model.Zyme;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ZymePersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public ZymePersistenceController() //removed void
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public void create(Zyme zyme)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(zyme);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Zyme nesukurta, klaida");
            e.printStackTrace();
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
    public void update(Zyme zyme) {
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            zyme = entityManager.merge(zyme);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public List<Zyme> getZymeListFromDatabase(){
        EntityManager  entityManager = getEntityManager();
        try {
            CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
            query.select(query.from(Zyme.class));
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
    public Zyme getZymeById(int id) {
        EntityManager entityManager = null;
        Zyme zyme = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            zyme = entityManager.getReference(Zyme.class, id);
            zyme.getId();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Zyme su tokiu ID neegzistuoja");
        }
        return zyme;
    }
    public void delete(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Zyme zyme = null;
            try {
                zyme = entityManager.getReference(Zyme.class, id);
                zyme.getId();
            } catch (Exception e) {
                System.out.println("Zyme su tokiu ID neegzistuoja");
            }
            entityManager.remove(zyme);
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
