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
    private Boolean vigente;
    private Item tipoLicencia;
    private String observaciones;
    private Integer numCopia;

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
}
