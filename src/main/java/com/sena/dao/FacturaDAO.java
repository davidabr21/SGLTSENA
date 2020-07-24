package com.sena.dao;

import com.sena.entities.Factura;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FacturaDAO {

    @PersistenceContext()
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Factura.findAll", Factura.class).getResultList();
    }

    public Factura findById(Long id) {
        return em.find(Factura.class, id);
    }
    
    public List getAllByLinea(String numeroLinea, Date minDate) {
        return em.createNamedQuery("Factura.findByMinFacFechaEmision", Factura.class)
                .setParameter("linNumeroLinea", numeroLinea)
                .setParameter("facFechaEmision", minDate)
                .getResultList();
    }

    public void update(Factura todo) {
        em.merge(todo);
    }

    public void create(Factura todo) {
        em.persist(todo);
    }

    public void delete(Factura todo) {
        if (!em.contains(todo)) {
            todo = em.merge(todo);
        }

        em.remove(todo);
    }
}