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
    //private String emitidaPor; 
    //private String titular;
    private String observaciones;

    public LicenciaDTO(Item tipoLicencia, String observaciones){
        this.tipoLicencia = tipoLicencia;
        this.observaciones = observaciones;
    }
}
