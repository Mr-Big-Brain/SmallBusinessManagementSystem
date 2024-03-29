package com.example.smallbusinessmanagementsystem.persistenceController;

import com.example.smallbusinessmanagementsystem.model.Finansas;
import com.example.smallbusinessmanagementsystem.model.PardavimoLinija;
import com.example.smallbusinessmanagementsystem.utilities.FinansoTipas;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class FinansasPersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public FinansasPersistenceController() //removed void
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public void create(Finansas finansas)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(finansas);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Finansas nesukurtas, klaida");
            e.printStackTrace();
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
    public void update(Finansas finansas) {
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            finansas = entityManager.merge(finansas);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public List<Finansas> getFinansasListFromDatabase(){
        EntityManager  entityManager = getEntityManager();
        try {
            CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
            query.select(query.from(Finansas.class));
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
    public List<Finansas> getFinansasListByFinansoTipas(FinansoTipas finansoTipas) {
        List<Finansas> finansai = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT f FROM Finansas f WHERE f.tipas = :finansoTipas";
            TypedQuery<Finansas> query = entityManager.createQuery(jpql, Finansas.class);
            query.setParameter("finansoTipas", finansoTipas);
            finansai = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return finansai;
    }
    public Finansas getFinansasById(int id) {
        EntityManager entityManager = null;
        Finansas finansas = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            finansas = entityManager.getReference(Finansas.class, id);
            finansas.getId();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Finansas su tokiu ID neegzistuoja");
        }
        return finansas;
    }
    public void delete(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Finansas finansas = null;
            try {
                finansas = entityManager.getReference(Finansas.class, id);
                finansas.getId();
            } catch (Exception e) {
                System.out.println("Finansas su tokiu ID neegzistuoja");
            }
            entityManager.remove(finansas);
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
