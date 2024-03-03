package com.banana.proyectostareas.controller;

import com.banana.proyectostareas.exception.ProyectoNotfoundException;
import com.banana.proyectostareas.model.Proyecto;
import com.banana.proyectostareas.model.StatusMessage;
import com.banana.proyectostareas.model.Tarea;
import com.banana.proyectostareas.service.ProyectoTareaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/proyecto")
@Tag(name = "Proyects API", description = "Proyects management APIs")
public class ProyectoTareaController {
    private static final Logger logger = LoggerFactory.getLogger(ProyectoTareaController.class);
    @Autowired
    ProyectoTareaService proyTserv;

    @Operation(summary = "Añadir nuevo proyecto", description = "Devuelve un proyecto persistido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Successfully created"),
            @ApiResponse(responseCode = "4XX", description = "Bad request")
    })
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity crearProyecto(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "Dato Proyecto")
            @RequestBody @Valid Proyecto newProy
    ) {
        newProy.setId(null);
        proyTserv.crearProyecto(newProy);

        if (newProy != null && newProy.getId() > 0) return new ResponseEntity<>(newProy, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(new StatusMessage(HttpStatus.BAD_REQUEST.value(), "No encontrado"), HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/{pid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity anadeTareaProyecto(
            @PathVariable @Min(1) Long pid,
            @RequestBody @Valid Tarea tarea
    ) {
        return new ResponseEntity<>(proyTserv.anadeTareaAProyecto(pid,tarea), HttpStatus.CREATED);
    }

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Proyecto>> getAllProyectos() {
        List<Proyecto> proyectos = proyTserv.obtenerProyectos();
        if (proyectos != null && !proyectos.isEmpty()) return ResponseEntity.status(HttpStatus.OK).body(proyectos);
        else throw new ProyectoNotfoundException("No hay proyectos");
    }

    @GetMapping(value = "/{pid}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Tarea>> getAllTareasdeProyecto(
            @PathVariable @Min(1) Long pid
    ) {
        List<Tarea> tareas = proyTserv.obtenerTareasDelProyecto(pid);
        if (tareas != null && !tareas.isEmpty()) return ResponseEntity.status(HttpStatus.OK).body(tareas);
        else throw new ProyectoNotfoundException("El proyecto no tiene tareas");
    }

    @PutMapping(value = "/{tid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity marcarTareaCompletada(
            @PathVariable @Min(1) Long tid
    ) {
        return new ResponseEntity<>(proyTserv.marcarTareaHecha(tid), HttpStatus.CREATED);
    }

}