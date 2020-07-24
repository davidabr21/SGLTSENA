package com.sena.dao;

import com.sena.entities.Linea;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LineaDAO {

    @PersistenceContext()
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Linea.findAll", Linea.class).getResultList();
    }
    
    public boolean lineaExists(String numeroLinea){
        Query query = em.createNamedQuery("Linea.findByLinNumeroLinea", Linea.class);
        query.setParameter("linNumeroLinea", numeroLinea);
        List resultObject = query.getResultList();
        boolean result = false;
        if(!resultObject.isEmpty()){
            result = true;
        }
        return result;
    }
    
    public Linea getByPerId(int perId) {
        return em.createNamedQuery("Linea.findByPerId", Linea.class).setParameter("perId", perId).setFirstResult(0).setMaxResults(1).getSingleResult();
    }

    public Linea findById(Long id) {
        return em.find(Linea.class, id);
    }

    public void update(Linea todo) {
        em.merge(todo);
    }

    public void create(Linea todo) {
        em.persist(todo);
    }

    public void delete(Linea todo) {
        if (!em.contains(todo)) {
            todo = em.merge(todo);
        }

        em.remove(todo);
    }
}