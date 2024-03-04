package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.model.Proyecto;

import java.util.*;
import javax.persistence.*;
import org.springframework.stereotype.Repository;

@Repository
public class JPAProyectoRepository implements ProyectoJPARepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public Proyecto findById(Long id) throws RuntimeException {
        Query query = em.createQuery("SELECT p FROM Proyecto p WHERE p.id = ?1");
        return (Proyecto) query.getResultList();
    }
    @Override
    public List<Proyecto> findAll() throws RuntimeException {
        Query query = em.createQuery("SELECT p FROM Proyecto p");
        return (List<Proyecto>) query.getResultList();
    }

    @Override
    public Proyecto save(Proyecto proy) throws RuntimeException {
        em.persist(proy);
        return proy;

    }

    @Override
    public Proyecto update(Proyecto proy) throws RuntimeException {
        Proyecto modProy = em.find(Proyecto.class, proy.getId());
        modProy.setNombre(proy.getNombre());
        modProy.setFechaCreacion(proy.getFechaCreacion());
        modProy.setTareas(proy.getTareas());

        return modProy;
    }

}
