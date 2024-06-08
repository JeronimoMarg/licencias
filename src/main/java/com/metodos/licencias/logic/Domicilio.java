package com.metodos.licencias.logic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="domicilios")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Domicilio {

    @Id
    @GeneratedValue
    private Long id;

    //private String localidad;
    //private String provincia;
    private String nombreCalle;
    private String numeroCalle;
    //private String pisoDepartamento;
    //private String numeroDepartamento; No me parecen importante para el dominio
    //private Integer codigoPostal;

    public Domicilio(String nombre, String numero){
        this.nombreCalle = nombre;
        this.numeroCalle = numero;

    }
    
}
