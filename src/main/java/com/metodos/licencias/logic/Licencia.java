package com.metodos.licencias.logic;

import java.time.LocalDate;

import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name="licencias")

@Data
public class Licencia {

    @Id
    @GeneratedValue
    private Long numeroLicencia;

    private LocalDate inicioVigencia;
    private LocalDate finVigencia;

    @ManyToOne(cascade = CascadeType.MERGE)
    private TipoLicencia tipoLicencia;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Tramite emitidaPor;

    private String observaciones;

    @ManyToOne
    private Titular titular;
    
    private int numeroCopia;

    public void aumentarNumCopia(){
        numeroCopia++;
    }
}
