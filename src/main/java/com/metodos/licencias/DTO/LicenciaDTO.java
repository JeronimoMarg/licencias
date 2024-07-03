package com.metodos.licencias.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

import com.metodos.licencias.util.Item;

@Data
@AllArgsConstructor
public class LicenciaDTO {

   
    private Long numeroLicencia;
    private Date inicioVigencia;
    private Date finVigencia;
    private Item tipoLicencia;
    private String observaciones;
    private Integer numCopia;
    private String nombreTitular;
    private String apellidoTitular;

    public LicenciaDTO(Item tipoLicencia, String observaciones){
        this.tipoLicencia = tipoLicencia;
        this.observaciones = observaciones;
    }

    public LicenciaDTO(Long numeroLicencia2, Date from, Date from2, Item item, String observaciones2) {
        this.numeroLicencia = numeroLicencia2;
        this.inicioVigencia = from;
        this.finVigencia = from2;
        this.tipoLicencia = item;
        this.observaciones = observaciones2;
    }

    public LicenciaDTO(Long numeroLicencia, Date from, Date from0, Item item, String observaciones, int numeroCopia) {
        this.numeroLicencia = numeroLicencia;
        this.inicioVigencia = from;
        this.finVigencia = from0;
        this.tipoLicencia = item;
        this.observaciones = observaciones;
        this.numCopia = numeroCopia;
    }
}
