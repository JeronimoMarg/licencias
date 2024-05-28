package com.metodos.licencias.logic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="costos")

@Data


public class Costo {
    
    @Id
    private TipoLicencia licenciaPerteneciente;
    private Double costo;
    private Integer vigencia;

    private TipoLicencia tipoLicencia;
}
