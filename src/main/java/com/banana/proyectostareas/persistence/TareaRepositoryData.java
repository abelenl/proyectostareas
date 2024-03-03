package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(propagation = Propagation.MANDATORY)
public interface TareaRepositoryData extends JpaRepository<Tarea, Long>{
}
