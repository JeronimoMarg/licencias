package com.metodos.licencias.logic;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="titulares")

@Data

public class Titular {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private FactorSanguíneo factorSanguíneo; //Podriamos hacerlo una clase en vez de una enum, mas manejable
    private TipoDocumento tipoDocumento; //Podriamos hacerlo una clase en vez de una enum, mas manejable
    private String numeroDocumento;
    private Boolean donanteDeOrganos;


    private Domicilio domicilio;
    
}
