package com.example.smallbusinessmanagementsystem.persistenceController;

import com.example.smallbusinessmanagementsystem.model.VartotojoTipas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class VartotojoTipasPersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public VartotojoTipasPersistenceController() //removed void
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public void create(VartotojoTipas vartotojosTipas)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(vartotojosTipas);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Vartotojo tipas nesukurtas, klaida");
            e.printStackTrace();
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
    public void update(VartotojoTipas vartotojosTipas) {
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            vartotojosTipas = entityManager.merge(vartotojosTipas);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public List<VartotojoTipas> getVartotojoTipasListFromDatabase(){
        EntityManager  entityManager = getEntityManager();
        try {
            CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
            query.select(query.from(VartotojoTipas.class));
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
    public VartotojoTipas getVartotojoTipasById(int id) {
        EntityManager entityManager = null;
        VartotojoTipas vartotojoTipas = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            vartotojoTipas = entityManager.getReference(VartotojoTipas.class, id);
            vartotojoTipas.getId();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Vartotojas su tokiu ID neegzistuoja");
        }
        return vartotojoTipas;
    }
    public void delete(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            VartotojoTipas vartotojoTipas = null;
            try {
                vartotojoTipas = entityManager.getReference(VartotojoTipas.class, id);
                vartotojoTipas.getId();
            } catch (Exception e) {
                System.out.println("UserType with given id doesn't exist");
            }
            entityManager.remove(vartotojoTipas);
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
