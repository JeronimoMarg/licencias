package com.metodos.licencias.logic;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="titulares")

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Long numeroDocumento;
    private Boolean donanteDeOrganos;
    @OneToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;

    /* 
    @OneToOne(cascade = CascadeType.ALL)
    private Tramite emitidaPor;
    */
    
    public Titular(String nombre, String apellido, LocalDate nacimiento, FactorSanguíneo factor,
    TipoDocumento tipoDoc, String numDNI, boolean donante, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = nacimiento;
        this.factorSanguíneo = factor;
        this.tipoDocumento = tipoDoc;
        this.numeroDocumento = Long.parseLong(numDNI);
        this.donanteDeOrganos = donante;
        this.domicilio = domicilio;
    }

}
