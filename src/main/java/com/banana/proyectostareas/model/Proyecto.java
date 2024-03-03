package com.banana.proyectostareas.model;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proyecto")
@ToString
@Schema(name = "product", description = "Modelo producto")
@XmlRootElement
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProy")
    @Schema(name = "Proyecto ID", example = "1", required = false)
    private Long id;

    @Column(name="nombre")
    @Schema(name = "Proyecto nombre", example = "Proyecto 1", required = true)
    private String nombre;

    @Column(name="fechaCreacion")
    @Schema(name = "Fecha creacion proyecto", example = "2024-01-01", required = true)
    private LocalDate fechaCreacion;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "proyecto_id")
    private List<Tarea> tareas;
}
