package com.banana.proyectostareas.service;

import com.banana.proyectostareas.exception.*;
import com.banana.proyectostareas.model.*;

import com.banana.proyectostareas.persistence.ProyectoRepositoryData;
import com.banana.proyectostareas.persistence.TareaRepositoryData;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import javax.persistence.*;

@Service
public class ProyectoTarea implements ProyectoTareaService{
    @Autowired
    private ProyectoRepositoryData proyRepo;
    @Autowired
    private TareaRepositoryData tareaRepo;

    @PersistenceContext
    EntityManager em;

    public Proyecto crearProyecto(Proyecto proyecto) throws RuntimeException {
        return proyRepo.save(proyecto);
    }

    public Proyecto anadeTareaAProyecto(Long idProyecto, Tarea tarea) throws ProyectoNotfoundException, RuntimeException {
        Proyecto modProy = proyRepo.findById(idProyecto).orElseThrow(() -> new RuntimeException());
        em.detach(modProy);
        modProy.getTareas().add(tarea);
        return proyRepo.save(modProy);
    }

    public List<Proyecto> obtenerProyectos() throws ProyectoNotfoundException, RuntimeException {
        return proyRepo.findAll();
    }

    public List<Tarea> obtenerTareasDelProyecto(Long idProyecto) throws ProyectoNotfoundException, RuntimeException {
        Proyecto modProy = proyRepo.findById(idProyecto).orElseThrow(() -> new RuntimeException());
        return modProy.getTareas();
    }

    public Tarea marcarTareaHecha(Long idTarea) throws TareaNotfoundException, RuntimeException {
        Tarea modTarea = tareaRepo.findById(idTarea).orElseThrow(() -> new RuntimeException());
        em.detach(modTarea);
        modTarea.setCompletada(Boolean.parseBoolean("true"));
        return modTarea;
    }

}
