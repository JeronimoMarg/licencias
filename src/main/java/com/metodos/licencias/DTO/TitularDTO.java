package com.metodos.licencias.DTO;

import java.util.Date;

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
    private String claseSolicitada;
    
    public TitularDTO(){
    }

    public TitularDTO(String nombre, String apellido, String tipoDoc, String numDNI, String grupoSanguineo,
            Date fechaNacimiento, boolean donante, String calle, String altura, String claseSolicitada) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDoc = tipoDoc;
        this.numDNI = numDNI;
        this.grupoSanguineo = grupoSanguineo;
        this.fechaNacimiento = fechaNacimiento;
        this.donante = donante;
        this.calle = calle;
        this.altura = altura;
        this.claseSolicitada = claseSolicitada;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getTipoDoc() {
        return tipoDoc;
    }
    public String getNumDNI() {
        return numDNI;
    }
    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getCalle() {
        return calle;
    }
    public String getAltura() {
        return altura;
    }
    public String getClaseSolicitada() {
        return claseSolicitada;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }
    public void setNumDNI(String numDNI) {
        this.numDNI = numDNI;
    }
    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public void setAltura(String altura) {
        this.altura = altura;
    }
    public void setClaseSolicitada(String claseSolicitada) {
        this.claseSolicitada = claseSolicitada;
    }

    public boolean isDonante() {
        return donante;
    }

    public void setDonante(boolean donante) {
        this.donante = donante;
    }

    

}
