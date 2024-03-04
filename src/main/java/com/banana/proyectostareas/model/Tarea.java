package com.banana.proyectostareas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Schema(name = "Tarea ID", example = "1", required = false)
    private Long id;

    @Column(name="descripcion")
    @Schema(name = "Descripción tarea", example = "Tarea 1", required = true)
    private String descripcion;

    @Column(name="fechaLimite")
    @Schema(name = "Fecha limite tarea", example = "2024-01-01", required = true)
    private LocalDate fechaLimite;

    @Column(name="orden")
    @Schema(name = "Orden tarea", example = "1", required = false)
    private Integer orden;

    @Column(name="completada")
    @Schema(name = "Estado tarea", example = "true/false", required = false)
    private boolean completada;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "proyecto_id")
    @ToString.Exclude
    @Schema(name = "proyecto_id", example = "", required = false)
    private Proyecto proyecto;
}
