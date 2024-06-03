package com.metodos.licencias.logic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="Usuarios")

@Data

public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    //No se si agregar mas datos personales como puse en la maqueta

    private String nombreUsuario;
    private String contrasenia;
    private TipoDocumento tipoDocumento;
    private String nroDocumento;
    private Rol rol;

    public Usuario(String usuario, String contrasenia, TipoDocumento tipoDocumento, String nroDocumento, Rol rol) {
        
        nombreUsuario = usuario;
        this.contrasenia = contrasenia;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.rol = rol;
    }

}
