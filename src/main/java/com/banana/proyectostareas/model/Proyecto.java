package com.banana.proyectostareas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Min(0)
    @Schema(name = "Proyecto ID", example = "1", required = false)
    private Long id;

    @Column
    @NotBlank(message = "Debe tener valor")
    @NotNull
    @Size(min = 3, max = 50)
    @Schema(name = "Proyecto nombre", example = "Proyecto 1", required = true)
    private String nombre;

    @Column
    @Schema(name = "Fecha creacion proyecto", example = "2024-01-01", required = true)
    private LocalDate fechaalta;

    @Column
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY,mappedBy = "proyecto")
    @JsonIgnore
    @Transient
    @Schema(name = "proyecto_id", example = "", required = false)
    private List<Tarea> tareas;
}
