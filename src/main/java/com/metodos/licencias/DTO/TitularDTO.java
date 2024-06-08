package com.metodos.licencias.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TitularDTO {

    //datos personales
    private String nombre;
    private String apellido;
    private String tipoDoc;
    private String numDNI;
    private String grupoSanguineo;
    private Date fechaNacimiento;
    private boolean donante;
    //direccion
    private String calle;
    private String altura;
    //licencia
    //private String claseSolicitada;


    

}
