package com.metodos.licencias.logic;

import jakarta.persistence.CascadeType;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Tramite")

@Data
@NoArgsConstructor

public class Tramite {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate fechaRealizacion;
    @Enumerated(EnumType.STRING)
    private TipoTramite tipoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario")
    private Usuario usuarioAdministrativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_licencia")
    private Licencia licenciaAsociada;
    
    public Tramite (TipoTramite tipo){
        this.tipoTramite = tipo;
        this.fechaRealizacion = LocalDate.now();
        this.usuarioAdministrativo = UsuarioLogeado.getUsuarioLogeado();
    }
    
}
