package com.metodos.licencias.logic;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="tipo-de-licencias")

@Data


public class TipoLicencia {

    @Id
    @GeneratedValue
    private Long id;

    private String letraClase;
    private String descripción;
    private Integer edadMinima;

    private List<Costo> costos;
    
}
