package com.metodos.licencias.logic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="domicilios")

@Data

public class Domicilio {

    @Id
    @GeneratedValue
    private Long id;

    private String localidad;
    private String provincia;
    private String nombreCalle;
    private String numeroCalle;
    //private String pisoDepartamento;
    //private String numeroDepartamento; No me parecen importante para el dominio
    private Integer codigoPostal;
    
}
