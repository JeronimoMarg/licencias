package com.metodos.licencias.logic;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name="Tramite")

@Data

public class Tramite {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate fechaRealizacion;
    private TipoTramite tipoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario")
    private Usuario usuarioAdministrativo;

    public Tramite (TipoTramite tipo){
        this.tipoTramite = tipo;
        this.fechaRealizacion = LocalDate.now();
        //this.usuarioAdministrativo = obtenerUsuario();
    }
    
}
