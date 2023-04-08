package com.example.smallbusinessmanagementsystem.persistenceController;

import com.example.smallbusinessmanagementsystem.model.Tvarkarastis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TvarkarastisPersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public TvarkarastisPersistenceController() //removed void
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public void create(Tvarkarastis tvarkarastis)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(tvarkarastis);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Tvarkarastis nesukurtas, klaida");
            e.printStackTrace();
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
    public void update(Tvarkarastis tvarkarastis) {
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            tvarkarastis = entityManager.merge(tvarkarastis);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public List<Tvarkarastis> getTvarkarastisListFromDatabase(){
        EntityManager  entityManager = getEntityManager();
        try {
            CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
            query.select(query.from(Tvarkarastis.class));
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
    public Tvarkarastis getTvarkarastisById(int id) {
        EntityManager entityManager = null;
        Tvarkarastis tvarkarastis = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            tvarkarastis = entityManager.getReference(Tvarkarastis.class, id);
            tvarkarastis.getId();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Tvarkarastis su tokiu ID neegzistuoja");
        }
        return tvarkarastis;
    }
    public void delete(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Tvarkarastis tvarkarastis = null;
            try {
                tvarkarastis = entityManager.getReference(Tvarkarastis.class, id);
                tvarkarastis.getId();
            } catch (Exception e) {
                System.out.println("Tvarkarastis su tokiu ID neegzistuoja");
            }
            entityManager.remove(tvarkarastis);
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
