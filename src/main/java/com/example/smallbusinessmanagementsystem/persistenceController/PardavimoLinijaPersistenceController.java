package com.example.smallbusinessmanagementsystem.persistenceController;

import com.example.smallbusinessmanagementsystem.model.PardavimoLinija;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PardavimoLinijaPersistenceController {
    private EntityManagerFactory entityManagerFactory;
    public PardavimoLinijaPersistenceController() //removed void
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManager getEntityManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        return entityManagerFactory.createEntityManager();
    }
    public void create(PardavimoLinija pardavimoLinija)
    {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(pardavimoLinija);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Pardavimo linija nesukurta, klaida");
            e.printStackTrace();
        }
        finally {
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
    }
    public void update(PardavimoLinija pardavimoLinija) {
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            pardavimoLinija = entityManager.merge(pardavimoLinija);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public List<PardavimoLinija> getPardavimoLinijaListFromDatabase(){
        EntityManager  entityManager = getEntityManager();
        try {
            CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
            query.select(query.from(PardavimoLinija.class));
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
    public PardavimoLinija getPardavimoLinijaById(int id) {
        EntityManager entityManager = null;
        PardavimoLinija pardavimoLinija = null;

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            pardavimoLinija = entityManager.getReference(PardavimoLinija.class, id);
            pardavimoLinija.getId();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Pardavimo linija su tokiu ID neegzistuoja");
        }
        return pardavimoLinija;
    }
    public void delete(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            PardavimoLinija pardavimoLinija = null;
            try {
                pardavimoLinija = entityManager.getReference(PardavimoLinija.class, id);
                pardavimoLinija.getId();
            } catch (Exception e) {
                System.out.println("Pardavimo linija su tokiu ID neegzistuoja");
            }
            entityManager.remove(pardavimoLinija);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public Double getPardavimoSuma(int pardavimasId) {
        Double sum = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT SUM(p.kainaUzViena * p.kiekis) FROM PardavimoLinija p WHERE p.pardavimas.id = :pardavimasId";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("pardavimasId", pardavimasId);
            sum = (Double) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return sum;
    }
    public List<PardavimoLinija> getPardavimoLinijosByPardavimas(int pardavimoId) {
        List<PardavimoLinija> pardavimoLinijos = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT p FROM PardavimoLinija p WHERE p.pardavimas.id = :pardavimoId";
            TypedQuery<PardavimoLinija> query = entityManager.createQuery(jpql, PardavimoLinija.class);
            query.setParameter("pardavimoId", pardavimoId);
            pardavimoLinijos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return pardavimoLinijos;
    }
}
