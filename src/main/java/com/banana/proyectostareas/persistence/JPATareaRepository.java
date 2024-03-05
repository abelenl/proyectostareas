package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.model.Tarea;

import java.util.*;
import javax.persistence.*;
import org.springframework.stereotype.Repository;

@Repository
public class JPATareaRepository implements TareaJPARepository{
    @PersistenceContext
    EntityManager em;

    @Override
    public Tarea findById(Long id) throws RuntimeException {
        Query query = em.createQuery("SELECT t FROM Tarea t WHERE t.id = ?1");
        return (Tarea) query.getResultList();
    }
    @Override
    public List<Tarea> findByProject(Long idProy) throws RuntimeException {
        Query query = em.createQuery("SELECT t FROM Tarea t WHERE t.id = ?1");
        return (List<Tarea>) query.getResultList();

    }

    @Override
    public Tarea update(Tarea tarea) throws RuntimeException {
        Tarea modTarea = em.find(Tarea.class, tarea.getId());
        modTarea.setDescripcion(tarea.getDescripcion());
        modTarea.setFechalimite(tarea.getFechalimite());
        modTarea.setOrden(tarea.getOrden());

        return modTarea;
    }
}
