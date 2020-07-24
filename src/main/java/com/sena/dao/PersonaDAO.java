package com.sena.dao;

import com.sena.entities.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PersonaDAO {

    @PersistenceContext()
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Persona.findAll", Persona.class).getResultList();
    }
    
    public boolean personaExists(String cedula){
        Query query = em.createNamedQuery("Persona.findByPerCedula", Persona.class);
        query.setParameter("perCedula", cedula);
        List resultObject = query.getResultList();
        boolean result = false;
        if(!resultObject.isEmpty()){
            result = true;
        }
        return result;
    }

    public Persona findById(Integer id) {
        return em.find(Persona.class, id);
    }

    public void update(Persona persona) {
        em.merge(persona);
    }

    public void create(Persona persona) {
        em.persist(persona);
    }

    public void delete(Persona persona) {
        if (!em.contains(persona)) {
            persona = em.merge(persona);
        }

        em.remove(persona);
    }
}