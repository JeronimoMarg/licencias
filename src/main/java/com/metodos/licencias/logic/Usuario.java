package com.metodos.licencias.logic;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Usuario")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    
    private String nombreUsuario;
    private String contrasenia;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    private String nroDocumento;

    public Usuario(String usuario, String contrasenia, TipoDocumento tipoDocumento, String nroDocumento, Rol rol) {
        
        nombreUsuario = usuario;
        this.contrasenia = contrasenia;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.rol = rol;
    }

}
