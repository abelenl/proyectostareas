package com.banana.proyectostareas.model;

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
    private Long id;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="fechaLimite")
    private LocalDate fechaLimite;

    @Column(name="orden")
    private Integer orden;

    @Column(name="completada")
    private boolean completada;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;
}
