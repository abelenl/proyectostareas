package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.model.Proyecto;
import com.banana.proyectostareas.model.Tarea;

import java.util.List;

public interface TareaJPARepository {

    public Tarea findById(Long id) throws RuntimeException;

    public List<Tarea> findByProject(Long idProyecto) throws RuntimeException;

    public Tarea update(Tarea tarea) throws RuntimeException;
}
