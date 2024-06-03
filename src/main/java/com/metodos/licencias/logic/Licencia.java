package com.metodos.licencias.logic;

import java.sql.Date;


import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="licencias")

@Data

public class Licencia {

    @Id
    @GeneratedValue
    private Long numeroLicencia;

    private Date inicioVigencia;
    private Date finVigencia;

    @OneToOne(cascade = CascadeType.ALL)
    private TipoLicencia tipoLicencia;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Tramite emitidaPor;
    
}
