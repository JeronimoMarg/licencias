package com.metodos.licencias.logic;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name="tramite")

@Data

public class Tramite {

    @Id
    @GeneratedValue
    private Long id;
    private Date fechaRealizacion;
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuarioAdministrativo;
    
}
