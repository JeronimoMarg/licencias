package com.metodos.licencias.logic;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity(name="tipodelicencias")

@Data

public class TipoLicencia {

    @Id
    @GeneratedValue
    private Long id;

    private String letraClase;
    private String descripcion;
    private int edadMinima;

}
