package com.metodos.licencias.logic;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity(name="titulares")

@Data

public class Titular {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    @Enumerated(EnumType.STRING)
    private FactorSanguíneo factorSanguíneo; //Podriamos hacerlo una clase en vez de una enum, mas manejable
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento; //Podriamos hacerlo una clase en vez de una enum, mas manejable
    private String numeroDocumento;
    private Boolean donanteDeOrganos;

    @OneToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;

    @OneToOne(cascade = CascadeType.ALL)
    private Tramite emitidaPor;
    
}
