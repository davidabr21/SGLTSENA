package com.sena.dao;

import com.sena.entities.Equipo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EquipoDAO {

    @PersistenceContext()
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Equipo.findAll", Equipo.class).getResultList();
    }

    public Equipo findById(Long id) {
        return em.find(Equipo.class, id);
    }

    public void update(Equipo equipo) {
        em.merge(equipo);
    }

    public void create(Equipo equipo) {
        em.persist(equipo);
    }

    public void delete(Equipo equipo) {
        if (!em.contains(equipo)) {
            equipo = em.merge(equipo);
        }

        em.remove(equipo);
    }
}